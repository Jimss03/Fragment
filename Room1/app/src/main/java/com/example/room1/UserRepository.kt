package com.example.room1

import androidx.lifecycle.LiveData
import com.example.room1.data.User
import com.example.room1.data.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

  suspend  fun addUser(user:User){
        userDao.addUser(user)
    }
}