package com.example.testcompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.R
import com.example.testcompose.model.MassCostState
import com.example.testcompose.model.TextFieldState
import com.example.testcompose.ui.theme.BlueUef

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ParamsBottomBar(
    massCostState: TextFieldState = remember { MassCostState() },
    massIncomeState: TextFieldState = remember { MassCostState() },
    onMassCostImeAction: () -> Unit = {},
    onMassIncomeImeAction: () -> Unit = {},
    onNavigateToExp: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(BlueUef),
    )
    {
        OutlinedTextField(
            value = massCostState.text,
            onValueChange = {
                massCostState.text = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.mass),
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            maxLines = 1,
            modifier = Modifier
                .weight(0.4f)
                .padding(4.dp)
                .onFocusChanged { focusState ->
                    massCostState.onFocusChange(focusState.isFocused)
                    if (!focusState.isFocused) {
                        massCostState.enableShowErrors()
                    }
                },
            textStyle = MaterialTheme.typography.bodyMedium,
            isError = massCostState.showErrors(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.NumberPassword
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onMassCostImeAction()
                    keyboardController?.hide()
                }
            ),
            trailingIcon = { massCostState.getError()?.let { IconError() } }
        )
        Image(
            modifier = Modifier
                .padding(4.dp)
                .weight(0.2f)
                .height(56.dp)
                .clickable {
                    onNavigateToExp()
                },
            painter = painterResource(id = R.drawable.ahwassa), contentDescription = "Image"
        )
        OutlinedTextField(
            value = massIncomeState.text,
            onValueChange = {
                massIncomeState.text = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.income),
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            maxLines = 1,
            modifier = Modifier
                .padding(4.dp)
                .weight(0.4f)
                .onFocusChanged { focusState ->
                    massIncomeState.onFocusChange(focusState.isFocused)
                    if (!focusState.isFocused) {
                        massIncomeState.enableShowErrors()
                    }
                },
            textStyle = MaterialTheme.typography.bodyMedium,
            isError = massIncomeState.showErrors(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.NumberPassword
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onMassIncomeImeAction()
                    keyboardController?.hide()
                }
            ),
            trailingIcon = { massIncomeState.getError()?.let { IconError() } }
        )
    }
}

@Composable
fun IconError() {
    Icon(
        modifier = Modifier.size(26.dp),
        painter = painterResource(id = R.drawable.ic_error),
        contentDescription = "Error",
        tint = MaterialTheme.colorScheme.error
    )
}

@Preview(showBackground = true)
@Composable
fun ParamsBottomBarPreview() {
    ParamsBottomBar() {

    }
}