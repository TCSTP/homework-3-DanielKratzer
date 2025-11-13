package tcs.app.dev.homework1

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import tcs.app.dev.homework1.data.Discount
import tcs.app.dev.homework1.data.Item
import tcs.app.dev.homework1.data.MockData
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.ScatterPlot
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ItemCard(modifier: Modifier= Modifier, item: Item, add: (Item)-> Unit) {
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
            Button(onClick = {add(item)}) {
                Column() {
                    Text(text="Add to Cart")
                    Text(text = MockData.ExampleShop.prices[item].toString())
                }

            }
        }

    }
}
@Composable
fun DiscountCard(modifier: Modifier= Modifier, discount: Discount, add: (Discount)-> Unit) {
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
            Button(onClick = {add(discount)}) {
                Column() {
                    Text(text="Add to Cart")
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