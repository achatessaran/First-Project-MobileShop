package com.example.mobileshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileshop.ui.theme.MobileShopTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MobileShopTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ShopScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun ShopScreen(innerPadding: PaddingValues) {
    var total by remember { mutableDoubleStateOf(0.0) }
    val products = listOf(

        Product(
            name = "Nike Air Max",
            price = 120.0,
            imageRes = R.drawable.shoe1
        ),

        Product(
            name = "Nike Revolution",
            price = 95.0,
            imageRes = R.drawable.shoe2
        ),

        Product(
            name = "Nike Jordan",
            price = 150.0,
            imageRes = R.drawable.shoe3
        ),

        Product(
            name = "Adidas Runner",
            price = 110.0,
            imageRes = R.drawable.shoe4
        ),

        Product(
            name = "Puma Sports Shoe",
            price = 85.0,
            imageRes = R.drawable.shoe5
        ),

        Product(
            name = "New Balance Classic",
            price = 130.0,
            imageRes = R.drawable.shoe6
        )

    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(start = 16.dp, end = 16.dp, top = 40.dp, bottom = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Mobile Shoe Shop",
            fontSize = 30.sp,
            color = Color(0xFF1565C0)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Shopping Bag Total: $$total",
            fontSize = 22.sp,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(20.dp))

        products.forEach { product ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F5F5)
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = product.name,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$" + product.price,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(onClick = {
                        total += product.price
                    }) {
                        Text(text = "Add to Bag")
                    }
                }
            }
        }

    }
}
data class Product(
    val name: String,
    val price: Double,
    val imageRes: Int
)