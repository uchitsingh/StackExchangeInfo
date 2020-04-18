package com.example.stackexchangeinfo.data.repository

import com.example.stackexchangeinfo.data.model.UserResponse
import io.reactivex.Single

interface UserRepository {

    fun getUsers(key: String, site: String): Single<UserResponse>

}