/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.model.scheme

/**
 * Scheme for activated barcode result.
 */
data class ActivateBarcodeParams(
    /**
     * The barcode data to activate or not.
     */
    val barcode: String,

    /**
     * Whether to activate or not.
     * Must be "1"(activate) or "0"(deactivate).
     */
    val activated: String
) {
    companion object {
        const val ACTIVATE_TRUE = "1"
        const val ACTIVATE_FALSE = "0"

        fun ofActivating(barcode: String): ActivateBarcodeParams {
            return ActivateBarcodeParams(
                barcode = barcode,
                activated = ACTIVATE_TRUE
            )
        }

        fun ofInvalidating(barcode: String): ActivateBarcodeParams {
            return ActivateBarcodeParams(
                barcode = barcode,
                activated = ACTIVATE_FALSE
            )
        }
    }
}