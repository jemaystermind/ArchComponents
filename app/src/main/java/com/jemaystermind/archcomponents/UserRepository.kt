/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents

import android.arch.lifecycle.LiveData
import com.jemaystermind.archcomponents.persistence.User
import com.jemaystermind.archcomponents.persistence.UserDao

class UserRepository(private val userDao: UserDao) {

  fun fetchUser(userId: Long): LiveData<User> {
    userDao.save(User(userId, "Jeremy", 23, 1L))
    return userDao.load(userId)
  }
}
