package com.pm.ecogarden.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.pm.ecogarden.R

sealed class TrashType(
    @DrawableRes val image: Int,
    val arg: String,
    val startGradientColor: Color,
    val endGradientColor: Color,
    val arcColor: Color
) {
    object MetalCan : TrashType(
        image = R.drawable.ic_metal_can,
        arg = "metal_can",
        startGradientColor = Color(0xFFFF9ECD),
        endGradientColor = Color(0xFFF0BBB0),
        arcColor = Color(0xFFFCB4EC).copy(alpha = 0.14f),
    )

    object Paper : TrashType(
        image = R.drawable.ic_paper,
        arg = "paper",
        startGradientColor = Color(0xFFF8FFA3),
        endGradientColor = Color(0xFFFFD178),
        arcColor = Color(0xFFC0B78A).copy(alpha = 0.16f),
    )

    object PlasticBottle : TrashType(
        image = R.drawable.ic_plastic_bottle,
        arg = "plastic_bottle",
        startGradientColor = Color(0xFFADC2FF),
        endGradientColor = Color(0xFF67EDE9),
        arcColor = Color(0xFF96D0E4).copy(alpha = 0.16f),
    )

    object GlassBottle : TrashType(
        image = R.drawable.ic_glass_bottle,
        arg = "glass_bottle",
        startGradientColor = Color(0xFFEBFFB1),
        endGradientColor = Color(0xFF3AFF8A),
        arcColor = Color(0xFF73FAA4).copy(alpha = 0.13f),
    )

    object Battery : TrashType(
        image = R.drawable.ic_battery,
        arg = "battery",
        startGradientColor = Color(0xFFFFFCD2),
        endGradientColor = Color(0xFFFFAC4B),
        arcColor = Color(0xFFE39D3C).copy(alpha = 0.14f),
    )

    companion object {
        fun fromString(string: String): TrashType {
            return when (string.lowercase()) {
                MetalCan.arg -> MetalCan
                PlasticBottle.arg -> PlasticBottle
                GlassBottle.arg -> GlassBottle
                Paper.arg -> Paper
                else -> Battery
            }
        }
    }
}
