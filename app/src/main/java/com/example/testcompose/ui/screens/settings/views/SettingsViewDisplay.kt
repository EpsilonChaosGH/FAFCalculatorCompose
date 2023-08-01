package com.example.testcompose.ui.screens.settings.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.domain.model.Config
import com.example.testcompose.domain.model.SacuCost
import com.example.testcompose.ui.screens.settings.models.SettingsViewState

@Composable
fun SettingsViewDisplay(
    viewState: SettingsViewState.Display,
    onSacuCostChanged: (SacuCost) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            text = stringResource(id = R.string.sacu_cost)
        )
        Column(
            Modifier
                .selectableGroup()
                .fillMaxWidth()
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = viewState.config.sacuCost == SacuCost.MASS_5320,
                    onClick = { onSacuCostChanged(SacuCost.MASS_5320) },
                )
                Image(
                    modifier = Modifier
                        .width(69.dp)
                        .height(64.dp)
                        .padding(4.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    painter = painterResource(id = R.drawable.with_fabricators),
                    contentDescription = stringResource(
                        id = R.string._5320
                    )
                )
                Spacer(modifier = Modifier.size(14.dp))
                Column {
                    Text(stringResource(id = R.string._5320), fontSize = 18.sp)
                    Text(
                        stringResource(id = R.string.with_fabricators),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = viewState.config.sacuCost == SacuCost.MASS_6450,
                    onClick = { onSacuCostChanged(SacuCost.MASS_6450) },
                )
                Image(
                    modifier = Modifier
                        .width(69.dp)
                        .height(64.dp)
                        .padding(4.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    painter = painterResource(id = R.drawable.without_fabricators),
                    contentDescription = stringResource(
                        id = R.string._6450
                    )
                )
                Spacer(modifier = Modifier.size(14.dp))
                Column {
                    Text(stringResource(id = R.string._6450), fontSize = 18.sp)
                    Text(
                        stringResource(id = R.string.without_fabricators),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            text = stringResource(id = R.string.sacu_cost_details)
        )
        Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsViewPreview() {
    SettingsViewDisplay(viewState = SettingsViewState.Display(Config()))
}