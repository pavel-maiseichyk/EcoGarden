package com.pm.ecogarden.shared.util

import android.content.Context

sealed class UiText {
    data class DynamicString(val text: String) : UiText()
    data class StringResource(val resId: Int) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is StringResource -> context.getString(resId)
            is DynamicString -> text
        }
    }
}