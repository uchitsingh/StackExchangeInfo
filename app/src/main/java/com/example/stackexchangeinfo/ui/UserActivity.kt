package com.example.stackexchangeinfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.stackexchangeinfo.App
import com.example.stackexchangeinfo.R
import com.example.stackexchangeinfo.data.repository.UserRepository
import com.example.stackexchangeinfo.viewmodel.UserViewModel
import com.example.stackexchangeinfo.viewmodel.UserViewModelFactory
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: UserRepository

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        (applicationContext as App).appComponent.inject(this)
        setupViewModel()
    }

    fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            UserViewModelFactory(repository)
        ).get(UserViewModel::class.java)

        viewModel.fetchUsers()
        viewModel.userObservable.observe(this, Observer {
            Toast.makeText(this, it.items.toString(), Toast.LENGTH_SHORT).show()
        })
    }

}
