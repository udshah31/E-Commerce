package com.journeyfortech.e_commerce.common

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomRoundedArcShape :Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawArcPath(size = size)
        )
    }
}

fun drawArcPath(size: Size): Path {
    return Path().apply {
        reset()
        lineTo(size.width, 0f)
        lineTo(size.width, size.height)
        arcTo(
            rect = Rect(
                Offset(0f, 0f),
                Size(size.width, size.height)
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 180f,
            forceMoveTo = false
        )
        lineTo(0f, 0f)
        close()
    }
}