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
import androidx.annotation.CallSuper
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inu.cafeteria.base.Failable
import com.inu.cafeteria.base.FailableContainer
import com.inu.cafeteria.base.Startable
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

/**
 * Base View Model that can handle failure inside it.
 */
abstract class BaseViewModel : ViewModel(), Startable, Failable, FailableContainer, KoinComponent {

    private val mContext: Context by inject()

    /**
     * Failure of View Model itself
     */
    private val failure = MutableLiveData<Failable.Failure>()

    /**
     * Failable properties inside this View Model
     */
    override val failables: MutableList<Failable> = mutableListOf()

    final override fun setFailure(failure: Failable.Failure) {
        this.failure.postValue(failure)
        Timber.w("Failure is set: ${failure.message}")
    }

    final override fun getFailure(): LiveData<Failable.Failure> {
        return failure
    }

    override fun fail(@StringRes message: Int, vararg formatArgs: Any?, show: Boolean) {
        setFailure(Failable.Failure(mContext.getString(message, *formatArgs), show))
    }

    @CallSuper
    override fun start() {
        Timber.v("${this::class.java.name} started.")
    }
}