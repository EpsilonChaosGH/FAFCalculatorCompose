package com.example.testcompose.ui.screens.main.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.domain.model.ResultState
import com.example.testcompose.ui.theme.AppTheme
import com.example.testcompose.ui.theme.GreenAeon
import com.example.testcompose.ui.theme.RedCybran

@Composable
fun ResultItem(result: ResultState) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(
            if (result.best) GreenAeon
            else AppTheme.colors.primaryBackground
        )
    ) {
        Row(modifier = Modifier.weight(0.33f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.sacu),
                modifier = Modifier.size(26.dp), contentDescription = "sacu"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = result.sacu,
                color = AppTheme.colors.primaryTextColor,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Row(modifier = Modifier.weight(0.34f), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(26.dp),
                painter = painterResource(id = R.drawable.mass_icon),
                contentDescription = "income"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = result.massIncome,
                color = AppTheme.colors.primaryTextColor,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Row(
            modifier = Modifier.weight(0.33f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(26.dp),
                painter = painterResource(
                    id =
                    if (!result.best) R.drawable.ic_time
                    else R.drawable.ic_star
                ), contentDescription = "time"
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = result.time,
                color = AppTheme.colors.primaryTextColor,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun ResultItemTitle() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(AppTheme.colors.secondaryBackground)
            .padding(4.dp)
    ) {
        Text(
            modifier = Modifier.weight(0.33f),
            text = "SACU",
            color = AppTheme.colors.primaryTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.weight(0.34f),
            text = "INCOME",
            color = AppTheme.colors.primaryTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.weight(0.33f),
            text = "TIME",
            color = AppTheme.colors.primaryTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultItemPreview() {
    Column {
        ResultItemTitle()
        ResultItem(result = ResultState("1", "222", "15.2", false))
        ResultItem(result = ResultState("1", "222", "15.2", true))
    }
}