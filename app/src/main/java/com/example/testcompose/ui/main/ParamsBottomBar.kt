package com.example.testcompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcompose.R
import com.example.testcompose.ui.theme.BlueUef

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParamsBottomBar(
    massCost: State<Int>,
    onMassCostValueChange: (String) -> Unit,
    massIncome: State<Int>,
    onMassIncomeValueChange: (String) -> Unit,
    onNavigateToExp: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(BlueUef),
    )
    {
        val massCostTextValue = massCost.value.toString()
        val massIncomeTextValue = massIncome.value.toString()

        OutlinedTextField(
            modifier = Modifier
                .weight(0.4f)
                .padding(4.dp),
            value = massCostTextValue, onValueChange = onMassCostValueChange
        )

        Image(
            modifier = Modifier
                .background(Color.Green)
                .weight(0.2f)
                .height(60.dp)
                .padding(4.dp)
                .clickable {
                    onNavigateToExp()
                },
            painter = painterResource(id = R.drawable.ahwassa), contentDescription = "Image"
        )

        OutlinedTextField(
            modifier = Modifier
                .weight(0.4f)
                .padding(4.dp),
            value = massIncomeTextValue, onValueChange = onMassIncomeValueChange
        )
    }
}
