/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents.persistence

import android.arch.persistence.room.ColumnInfo

data class Address(
    var street: String,
    var state: String,
    var city: String,
    @ColumnInfo(name = "postal_code") var postalCode: Int
)
