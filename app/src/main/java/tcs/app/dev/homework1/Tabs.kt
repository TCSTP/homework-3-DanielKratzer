package tcs.app.dev.homework1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tcs.app.dev.homework1.data.Cart
import tcs.app.dev.homework1.data.Discount
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.homework1.data.Shop
import tcs.app.dev.homework1.data.plus
import tcs.app.dev.ui.theme.AppTheme

@Composable
fun ItemTab(
    cart: Cart,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (item in cart.shop.prices.keys) {
            ItemCard(modifier = Modifier, item, add = { i -> cart + i })
        }
    }
}

@Composable
fun DiscountTab(
    cart: Cart,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (discount in MockData.ExampleDiscounts) {
            DiscountCard(modifier = Modifier, discount, add = { i -> cart + i })
        }
    }
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