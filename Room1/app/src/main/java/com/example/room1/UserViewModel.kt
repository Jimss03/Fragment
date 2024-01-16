package com.example.room1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room1.data.User
import com.example.room1.data.UserDao
import com.example.room1.data.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {
    private val readAllData:LiveData<List<User>>
    private val repository:UserRepository
    init {
        val userDao = UserDatabase.getDatabase(application).UserDao()
        repository= UserRepository(userDao)
        readAllData = repository.readAllData

    }
    fun addUser(user: User){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addUser(user)
        }
    }
}