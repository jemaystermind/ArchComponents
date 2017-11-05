/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.archcomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.jemaystermind.archcomponents.persistence.User
import com.jemaystermind.archcomponents.persistence.UserDao
import timber.log.Timber

// Note: ViewModel MUST NEVER reference a view or any class
// that may hold a reference to the activity context
class UserProfileViewModel : ViewModel() {
  var user: LiveData<User>? = null
  private val repository = UserRepository(object : UserDao {
    override fun save(user: User) {
      Timber.i("Saving user=$user")
    }

    override fun load(userId: Long): LiveData<User> {
      return MutableLiveData<User>().apply { value = User(userId, "Kotlin", 13, 1) }
    }
  }) // TODO Jemay: Use dependency injection!

  fun init(userId: Long) {
    if (user != null) {
      return
    }

    user = repository.fetchUser(userId)
  }

  fun sampleTransformations() {
    // Transformations
    val fullNameWithAge: LiveData<String> = Transformations.map(repository.fetchUser(1)) {
      it.name + " " + it.age
    }
  }
}
