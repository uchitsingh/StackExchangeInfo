package com.example.stackexchangeinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackexchangeinfo.data.model.UserResponse
import com.example.stackexchangeinfo.data.repository.UserRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _userObservable: MutableLiveData<UserResponse> = MutableLiveData()
    val userObservable: LiveData<UserResponse>
        get() = _userObservable

    fun fetchUsers() {

        Timber.d("Fetch Users initiated ")
        disposable.add(
            userRepository.getUsers(KEY, SITE_MAP).subscribe(
                {
                    Timber.d("Fetch Users Success , $it ")
                    _userObservable.value = it

                }, {
                    Timber.d("Fetch Users Failure , ${it.localizedMessage} ")

                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    companion object {
        private const val KEY = "t2ck5iQeCGoOt3ED*v77RA(("
        private const val SITE_MAP = "stackoverflow"
    }
}