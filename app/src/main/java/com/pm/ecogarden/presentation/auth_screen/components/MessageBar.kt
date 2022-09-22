package com.pm.ecogarden.auth.auth_one_click.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.R
import com.pm.ecogarden.auth.auth_one_click.domain.model.MessageBarState
import com.pm.ecogarden.shared.util.UiText
import com.pm.ecogarden.ui.theme.ErrorRed
import com.pm.ecogarden.ui.theme.InfoGreen
import com.pm.ecogarden.ui.theme.LocalSpacing
import kotlinx.coroutines.delay
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun MessageBar(
    modifier: Modifier = Modifier,
    state: MessageBarState
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    var startAnimation by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(state) {
        if (state.error != null) {
            errorMessage = when (state.error) {
                is SocketTimeoutException -> {
                    UiText.StringResource(R.string.connection_timeout).asString(context)
                }
                is ConnectException -> {
                    UiText.StringResource(R.string.internet_unavailable).asString(context)
                }
                else -> {
                    "${state.error.message}"
                }
            }
        }
        startAnimation = true
        delay(3000)
        startAnimation = false
    }

    AnimatedVisibility(
        visible = (state.error != null || state.message != null) && startAnimation,
        enter = expandVertically(
            animationSpec = tween(300),
            expandFrom = Alignment.Top
        ),
        exit = shrinkVertically(
            animationSpec = tween(300),
            shrinkTowards = Alignment.Top
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(
                    if (state.error != null) ErrorRed
                    else InfoGreen
                )
                .padding(horizontal = spacing.spaceMedium)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector =
                if (state.error != null) Icons.Default.Warning
                else Icons.Default.Check,
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(spacing.spaceSmall))
            Text(
                text = if (state.error != null) errorMessage
                else state.message.toString(),
                color = Color.White,
                style = MaterialTheme.typography.labelLarge,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}