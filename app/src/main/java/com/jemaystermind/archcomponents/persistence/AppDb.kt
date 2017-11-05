/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(School::class, User::class), version = 1)
abstract class AppDb : RoomDatabase() {
  abstract fun userDao(): UserDao

  abstract fun schoolDao(): SchoolDao
}
