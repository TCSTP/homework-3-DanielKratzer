package tcs.app.dev.homework1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tcs.app.dev.homework1.data.Cart
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.homework1.data.Shop
import tcs.app.dev.ui.theme.AppTheme

@Composable
fun ItemTab(
    cart: Cart,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for ((item, euro) in cart.shop.prices) {
            ItemCard(item.id, euro)
        }
    }
}

@Composable
fun DiscountTab(
    cart: Cart,
    modifier: Modifier
) {
}

@Composable
fun CartTab(
    cart: Cart,
    modifier: Modifier
) {
}

@Composable
@Preview
fun ItemTabPreview() {
    AppTheme() {
        ItemTab(Cart(MockData.ExampleShop), modifier = Modifier)
    }
}