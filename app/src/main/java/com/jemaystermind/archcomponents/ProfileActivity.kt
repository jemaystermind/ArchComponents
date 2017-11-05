package com.jemaystermind.archcomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jemaystermind.archcomponents.databinding.ActivityProfileBinding
import com.jemaystermind.archcomponents.persistence.Address
import com.jemaystermind.archcomponents.persistence.AppDb
import com.jemaystermind.archcomponents.persistence.User
import timber.log.Timber

class ProfileActivity : AppCompatActivity() {

  private var userId: Long = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Set the view for this activity and return the binding
    // which will be used to bind our data and the UI
    val binding: ActivityProfileBinding = DataBindingUtil.setContentView(
        this, R.layout.activity_profile)

    if (savedInstanceState != null) {
      userId = savedInstanceState.getLong("user_id")
      Timber.i("Saved userId=$userId")
    }

    // Create a ViewModel for this lifecycle aware component
    val userViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)

    // Sample call to trigger a data change
    userViewModel.init(userId)

    // Bind the user to our UI which automatically updates the UI
    // every time the data changes
    userViewModel.user?.observe(this, Observer { binding.user = it })

    sampleRoom()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putLong("user_id", 1)
    super.onSaveInstanceState(outState)
  }

  fun sampleRoom() {
    // Note: Make this object singleton since each instance is very expensive
    val room = Room.databaseBuilder(applicationContext, AppDb::class.java,"arch-components")
        .allowMainThreadQueries()
        .build()
    val address = Address("street", "state", "city", 6018)
    room.userDao().save(User(userId, "jemaystermind", 18, 1L))

    val loadedUser = room.userDao().load(userId).value
    Timber.i("Loaded user=$loadedUser")
  }
}
