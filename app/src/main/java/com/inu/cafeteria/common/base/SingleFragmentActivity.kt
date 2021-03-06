/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.common.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.inu.cafeteria.R
import com.inu.cafeteria.common.extension.inImmediateTransaction

abstract class SingleFragmentActivity : BaseActivity() {

    abstract val fragment: Fragment
    open val layoutId: Int? = R.layout.single_fragment_activity

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutId?.let { setContentView(it) }

        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (fragment as? BaseFragment)?.onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?:
        supportFragmentManager.inImmediateTransaction {
            add(R.id.fragment_container, fragment)
            this
        }
}