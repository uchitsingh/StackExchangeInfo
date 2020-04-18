package com.example.stackexchangeinfo.data.remote

import com.example.stackexchangeinfo.Constants
import com.example.stackexchangeinfo.data.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(Constants.USER_URL)
    fun getUsers(@Query("Key") key :String,  @Query("site") site: String): Single<UserResponse>
}