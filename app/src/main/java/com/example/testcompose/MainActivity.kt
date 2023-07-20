package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.ui.theme.Gray
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.theme.ToxicGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ExpGrid()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpGrid() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 90.dp)
    ) {
        itemsIndexed(ExpState.getList()) { _, exp ->
            ExpItem(exp = exp)
        }
    }
}

@Composable
fun ExpItem(exp: ExpState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = exp.iconResId),
                contentDescription = stringResource(id = exp.titleResId),
                modifier = Modifier.size(64.dp),
            )
            Text(
                modifier = Modifier
                    .background(exp.factionColor)
                    .fillMaxSize()
                    .padding(4.dp),
                text = stringResource(id = exp.titleResId),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Gray)
            ) {
                Image(
                    painter = painterResource(R.drawable.mass_icon),
                    contentDescription = "Mass",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(18.dp)
                )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    text = stringResource(id = exp.costResId),
                    color = ToxicGreen,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}