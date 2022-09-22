package com.pm.ecogarden.profile_feature.presentation.settings_screen.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun DisplayAlertDialog(
    title: String = "Delete your account?",
    message: String = "Are sure you want to delete your account?",
    openDialog: Boolean,
    onYesClicked: () -> Unit,
    onDialogClosed: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            text = {
                Text(
                    text = message,
                    style = MaterialTheme.typography.titleMedium
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onYesClicked()
                        onDialogClosed()
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        onDialogClosed()
                    }
                ) {
                    Text(text = "No")
                }
            },
            onDismissRequest = onDialogClosed
        )
    }
}