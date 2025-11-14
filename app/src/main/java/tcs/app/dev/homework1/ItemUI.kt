package tcs.app.dev.homework1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tcs.app.dev.homework1.data.Euro
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.ui.theme.AppTheme

import tcs.app.dev.homework1.data.Item

@Composable
fun ItemCard(name: String, price: Euro, image: Painter){
    Card {
        Row{
            Image(image, contentDescription = null)
            Text(name)
            Text(price.toString())
            Button(onClick = {}) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemUIPreview() {
    AppTheme {
        ItemCard(name = "Apple", price = Euro(120u), image = painterResource(MockData.getImage(
            Item(
                "apple"
            )
        )))
    }
}