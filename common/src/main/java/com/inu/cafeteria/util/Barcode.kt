/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.util

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.inu.cafeteria.extension.tryOrNull

class Barcode {
    companion object {
        fun from(data: String, width: Int = WIDTH, height: Int = HEIGHT): Bitmap? {

            return tryOrNull {
                val byteMap = MultiFormatWriter().encode(data, BarcodeFormat.CODE_128,
                    WIDTH,
                    HEIGHT
                )
                val bitmap = Bitmap.createBitmap(
                    WIDTH,
                    HEIGHT, Bitmap.Config.ARGB_8888)

                for (i in 0 until WIDTH)

                    for (j in 0 until HEIGHT) {
                        bitmap.setPixel(i, j, if (byteMap.get(i, j)) Color.BLACK else Color.WHITE)
                    }

                bitmap
            }
        }

        private const val WIDTH = 600
        private const val HEIGHT = 360
    }
}