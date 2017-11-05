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
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface SchoolDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun save(school: School)

  @Query("SELECT * FROM school WHERE school_id = :schoolId")
  fun load(schoolId: Long): LiveData<School>
}
