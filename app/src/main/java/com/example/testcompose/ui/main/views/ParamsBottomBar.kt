package com.example.testcompose.ui.main.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.R
import com.example.testcompose.ui.theme.BlueUef


@Composable
fun ParamsBottomBar(
    massCostTextFieldState: MutableState<Int> = remember { mutableStateOf(0) },
    massIncomeTextFieldState: MutableState<Int> = remember { mutableStateOf(0) },
    onMassCostImeAction: (Int) -> Unit = {},
    onMassIncomeImeAction: (Int) -> Unit = {},
    navController: NavController = rememberNavController()
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(BlueUef),
    )
    {
        TextFieldTest(
            nameId = R.string.mass_cost,
            modifier = Modifier
                .weight(0.4f)
                .padding(4.dp),
            numbersTextFieldState = massCostTextFieldState,
            imeAction = onMassCostImeAction

        )

        Image(
            modifier = Modifier
                .padding(4.dp)
                .weight(0.2f)
                .height(56.dp)
                .clickable {
                    navController.navigate("Exp")
                },
            painter = painterResource(id = R.drawable.ahwassa), contentDescription = "Image"
        )

        TextFieldTest(
            nameId = R.string.income,
            modifier = Modifier
                .weight(0.4f)
                .padding(4.dp),
            numbersTextFieldState = massIncomeTextFieldState,
            imeAction = onMassIncomeImeAction

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldTest(
    nameId: Int,
    modifier: Modifier = Modifier,
    numbersTextFieldState: MutableState<Int> = remember { mutableStateOf(0) },
    imeAction: (Int) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = numbersTextFieldState.value.toString(),
        onValueChange = { value ->
            if (value.length > 9) return@OutlinedTextField
            if (value.isEmpty()) {
                numbersTextFieldState.value = 0
                imeAction(0)
            } else {
                val number = value.filter { it.isDigit() }.toInt()
                numbersTextFieldState.value = number
                imeAction(number)
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