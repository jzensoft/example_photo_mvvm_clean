package com.example.photo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photo.R
import com.example.photo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        initAdapter()
        initListener()
        subscribe()

        viewModel.getPhotos()
    }

    private fun initAdapter() {
        photoAdapter = PhotoAdapter()
        binding.rvPhoto.apply {
            adapter = photoAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun subscribe() {
        viewModel.photos.observe(this) {
            binding.refresh.isRefreshing = false
            photoAdapter.setData(it)
        }
    }

    private fun initListener() {
        binding.refresh.setOnRefreshListener {
            viewModel.updatePhotos()
        }
    }
}