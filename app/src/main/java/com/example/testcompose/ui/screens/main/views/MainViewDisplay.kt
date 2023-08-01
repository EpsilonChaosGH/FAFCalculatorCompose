package com.example.testcompose.ui.screens.main.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.testcompose.R
import com.example.testcompose.domain.model.ResultState
import com.example.testcompose.ui.screens.main.models.MainViewState
import com.example.testcompose.ui.theme.BlueUef
import com.example.testcompose.ui.theme.RedCybran

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainViewDisplay(
    modifier: Modifier,
    viewState: MainViewState.Display,
    onMassCostImeAction: (Int) -> Unit = {},
    onMassIncomeImeAction: (Int) -> Unit = {},
    resultList: List<ResultState> = emptyList()
) {

    Scaffold(modifier = modifier,
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BlueUef),
            )
            {
                NumberFieldTest(
                    nameId = R.string.mass_cost,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(4.dp),
                    numbersFieldValue = viewState.config.massCost,
                    imeAction = onMassCostImeAction
                )

                NumberFieldTest(
                    nameId = R.string.income,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(4.dp),
                    numbersFieldValue = viewState.config.massIncome,
                    imeAction = onMassIncomeImeAction
                )
            }
        }
    ) { innerPadding ->
        Column {
            LazyColumn(
                modifier = Modifier
                    .background(RedCybran)
                    .fillMaxSize()
                    .weight(1f)
                    .padding(innerPadding),
            ) {
                stickyHeader {
                    ResultItemTitle()
                }
                items(resultList) { ResultItem(result = it) }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NumberFieldTest(
    nameId: Int,
    modifier: Modifier = Modifier,
    numbersFieldValue: Int,
    imeAction: (Int) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = numbersFieldValue.toString(),
        onValueChange = { value ->
            if (value.length > 9) return@OutlinedTextField
            if (value.isEmpty()) {
                imeAction(1)
            } else {
                imeAction(value.filter { it.isDigit() }.toInt())
            }
        },
        label = {
            Text(
                text = stringResource(id = nameId),
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        singleLine = true,
        modifier = modifier,
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}