package com.erenalparslan.rickandmortyapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erenalparslan.rickandmortyapplication.common.viewBinding
import com.erenalparslan.rickandmortyapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}