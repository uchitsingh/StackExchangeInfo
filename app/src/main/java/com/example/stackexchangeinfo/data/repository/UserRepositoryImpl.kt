package com.example.stackexchangeinfo.data.repository

import com.example.stackexchangeinfo.data.model.UserResponse
import com.example.stackexchangeinfo.data.remote.UserService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserRepositoryImpl(private val service: UserService) : UserRepository {

    override fun getUsers(key: String, site: String): Single<UserResponse> {
        return service.getUsers(key, site)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
