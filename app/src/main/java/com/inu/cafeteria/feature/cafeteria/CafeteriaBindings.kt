/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.feature.cafeteria

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.inu.cafeteria.model.FoodMenu
import com.inu.cafeteria.model.scheme.Cafeteria
import timber.log.Timber

@BindingAdapter("cafeteria")
fun setCafeteria(listView: RecyclerView, data: List<Cafeteria>?) {
    val adapter = listView.adapter as? CafeteriaAdapter
    if (adapter == null) {
        Timber.w("Adapter not set.")
        return
    }

    adapter.data = data.orEmpty()

    Timber.i("Cafeteria is updated.")
}

@BindingAdapter("corners")
fun setCorners(listView: RecyclerView, data: FoodMenu?) {
    val adapter = listView.adapter as? CornersAdapter
    if (adapter == null) {
        Timber.w("Adapter not set.")
        return
    }

    adapter.data = data?.corners.orEmpty()

    Timber.i("Corners is(are) updated.")
}
