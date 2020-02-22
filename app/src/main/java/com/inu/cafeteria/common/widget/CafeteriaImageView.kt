/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.common.widget

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.widget.ImageView

class CafeteriaImageView(context: Context, attrs: AttributeSet? = null) : ImageView(context, attrs) {
    init {
        background = ShapeDrawable(OvalShape())
        scaleType = ScaleType.CENTER_CROP
        clipToOutline = true
    }
}