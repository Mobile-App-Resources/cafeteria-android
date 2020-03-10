/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.core.interactor

import com.inu.cafeteria.base.FailableComponent
import com.inu.cafeteria.core.functional.Result
import kotlinx.coroutines.*

/**
 * Abstract class for Use Case (Interactor in terms of Clean Architecture).
 * Any use case in this application should implement this.
 */
abstract class UseCase<in Params, out Type> : FailableComponent() {
    abstract suspend fun run(params: Params): Result<Type>

    operator fun invoke(params: Params, onResult: (Result<Type>) -> Unit = {}) {
        CoroutineScope(Dispatchers.Main).launch {
            // Do on background
            val result = withContext(Dispatchers.IO) {
                run(params)
            }

            // Return to main thread.
            onResult(result)
        }

    }
}