package com.pm.ecogarden.auth.auth_one_click.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.R
import com.pm.ecogarden.auth.auth_password.presentation.components.AuthButton
import com.pm.ecogarden.auth.auth_password.presentation.components.AuthField
import com.pm.ecogarden.auth.auth_password.presentation.components.RoundSignButton
import com.pm.ecogarden.ui.theme.LocalSpacing

@Composable
fun AuthBox(
    onAuthButtonClicked: () -> Unit,
    onSignButtonClicked: () -> Unit,
    loadingState: Boolean,
    login: String,
    password: String
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = MaterialTheme.shapes.extraLarge
            )
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = spacing.spaceLarge)
                .fillMaxWidth()
        ) {
            Text(
                text = "Behold!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .padding(vertical = spacing.spaceLarge)
                    .fillMaxWidth()
            )
            AuthField(
                text = stringResource(R.string.login),
                fieldValue = login,
                onValueChange = {
                    // viewModel.onEvent(AuthEvent.UsernameChanged(state.usernameText))
                }
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            AuthField(
                text = stringResource(R.string.password),
                fieldValue = password,
                onValueChange = {
                    // viewModel.onEvent(AuthEvent.UsernameChanged(state.passwordText))
                }
            )
            Text(
                text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(spacing.spaceLarge))
            AuthButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Sign In",
                onClick = {
                    onSignButtonClicked()
                    //  viewModel.onEvent(AuthEvent.SignButtonClicked(state.isSignUp))
                }
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(spacing.spaceLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RoundSignButton(
                    icon = R.drawable.ic_google_logo,
                    loadingState = loadingState,
                    onClick = onAuthButtonClicked
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
//                    if (!state.isSignUp) {
//                        Text(
//                            text = stringResource(R.string.dont_have_account),
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                    }
//                    Text(
//                        text = if (state.isSignUp) stringResource(R.string.sign_up)
//                        else stringResource(R.string.back_to_sign_in),
//                        style = MaterialTheme.typography.bodyMedium,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .clickable { viewModel.onEvent(AuthEvent.SignTextClicked) }
//                    )
        }
    }
}