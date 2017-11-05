/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface UserDao {
  @Insert(onConflict = REPLACE)
  fun save(user: User)

  @Query("SELECT * FROM users WHERE id = :userId")
  fun load(userId: Long): LiveData<User>
}
