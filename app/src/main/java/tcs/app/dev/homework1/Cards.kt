package tcs.app.dev.homework1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ScatterPlot
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tcs.app.dev.homework1.data.Discount
import tcs.app.dev.homework1.data.Euro
import tcs.app.dev.homework1.data.Item
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.homework1.data.times
import tcs.app.dev.ui.theme.AppTheme

@Composable
fun ItemCard(modifier: Modifier = Modifier, item: Item, add: (Item) -> Unit) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(MockData.getImage(item)),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = stringResource(MockData.getName(item)),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Button(onClick = { add(item) }) {
                Column() {
                    Text(text = "Add to Cart")
                    Text(text = MockData.ExampleShop.prices[item].toString())
                }

            }
        }

    }
}

@Composable
fun DiscountCard(modifier: Modifier = Modifier, discount: Discount, add: (Discount) -> Unit) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                discount.icon(),
                contentDescription = "Discount Icon"
            )
            Text(
                text = discount.name(),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Button(onClick = { add(discount) }) {
                Column() {
                    Text(text = "Add to Cart")
                }

            }
        }

    }
}

fun Discount.name(): String =
    when (this) {
        is Discount.Bundle -> "${item.id}: Get $amountItemsGet for $amountItemsPay!"
        is Discount.Fixed -> "-${this.amount}"
        is Discount.Percentage -> "-${this.value}%"
    }

fun Discount.icon(): ImageVector =
    when (this) {
        is Discount.Bundle -> Icons.Filled.ScatterPlot
        is Discount.Fixed -> Icons.Filled.MoneyOff
        is Discount.Percentage -> Icons.Filled.Percent
    }

@Composable
fun CartItemCard(
    modifier: Modifier = Modifier,
    item: Item,
    add: () -> Unit,
    remove: () -> Unit,
    amount: UInt = 0u,
    price: Euro = Euro(0u)
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(MockData.getImage(item)),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = stringResource(MockData.getName(item)),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                text = (price*amount).toString(),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            PlusMinus(modifier, add, remove)
        }

    }
}

@Composable
fun CartDiscountCard(
    modifier: Modifier = Modifier,
    discount: Discount,
    add: () -> Unit = {},
    remove: () -> Unit = {}
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                discount.icon(),
                contentDescription = "Discount Icon"
            )
            Text(
                text = discount.name(),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            PlusMinus(modifier, add, remove)
        }

    }
}

@Composable
fun PlusMinus(modifier: Modifier, add: () -> Unit, remove: () -> Unit) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = add,

            ) {
            Icon(Icons.Filled.Add, contentDescription = null)
        }
        IconButton(
            onClick = remove,

            ) {
            Icon(Icons.Filled.Remove, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun CartDiscountPreview() {
    AppTheme() {
        CartDiscountCard(discount = Discount.Percentage(10u)) { }
    }
}