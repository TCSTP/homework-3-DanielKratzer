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
import tcs.app.dev.homework1.data.Euro
import tcs.app.dev.homework1.data.Item
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.homework1.data.Shop
import tcs.app.dev.homework1.data.minus
import tcs.app.dev.homework1.data.plus
import tcs.app.dev.ui.theme.AppTheme

@Composable
fun ItemTab(
    add: (Item) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (item in MockData.ExampleShop.items) {
            ItemCard(modifier = Modifier, item, add = add)
        }
    }
}

@Composable
fun DiscountTab(
    add: (Discount) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (discount in MockData.ExampleDiscounts) {
            DiscountCard(modifier = Modifier, discount, add = add)
        }
    }
}


@Composable
fun CartTab(
    cart: Cart,
    addItem: (Item) -> Unit,
    addDiscount: (Discount) -> Unit,
    removeItem: (Item) -> Unit,
    removeDiscount: (Discount) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for ((item, amount) in cart.items) {
            CartItemCard(
                modifier = Modifier,
                item,
                add = { addItem(item) },
                remove = { removeItem(item) },
                amount=amount,
                price = cart.shop.prices[item] ?: Euro(0u)
            )

        }
        for (discount in cart.discounts) {
            CartDiscountCard(
                modifier = Modifier,
                discount,
                add = { addDiscount(discount) },
                remove = { removeDiscount(discount) })
        }
    }
}

//@Composable
//@Preview
//fun ItemTabPreview() {
//    AppTheme() {
//        ItemTab(Cart(MockData.ExampleShop), modifier = Modifier)
//    }
//}