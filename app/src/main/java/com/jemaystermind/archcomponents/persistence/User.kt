/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users"
//    foreignKeys = arrayOf(
//        ForeignKey(
//            entity = School::class,
//            parentColumns = arrayOf("school_id"),
//            childColumns = arrayOf("school_id"),
//            onDelete = ForeignKey.NO_ACTION,
//            onUpdate = ForeignKey.NO_ACTION
//        )
//    )
)
data class User(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "full_name") val name: String,
    val age: Int,
    @ColumnInfo(name = "school_id") val schoolId: Long
)
