/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.common.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import org.koin.core.inject

/**
 * Base pager adapter that use view for page item.
 */
abstract class ViewPagerAdapter : BasePagerAdapter() {

    protected val context: Context by inject()

    /**
     * Prevent calling super.
     * This method works for [FragmentPagerAdapter].
     */
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}