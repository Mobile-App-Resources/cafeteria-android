/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.repositories

import com.inu.cafeteria.entities.Notice
import com.inu.cafeteria.entities.FeedbackReply
import com.inu.cafeteria.functional.Result

abstract class InteractionRepository : Repository() {

    abstract fun getFeedbackReplies(): Result<List<FeedbackReply>>
    abstract fun getNotices(): Result<List<Notice>>
}