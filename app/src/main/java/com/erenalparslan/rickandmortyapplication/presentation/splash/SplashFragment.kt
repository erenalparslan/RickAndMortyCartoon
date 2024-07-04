package com.erenalparslan.rickandmortyapplication.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.SplashSharedPreferencesManager
import com.erenalparslan.rickandmortyapplication.common.viewBinding
import com.erenalparslan.rickandmortyapplication.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    private lateinit var splash: SplashSharedPreferencesManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splash = SplashSharedPreferencesManager(requireContext())
        binding.splashText.text = if (splash.firstLoginCheck()) "Hello!" else "Welcome!"
        splash.setLogin()
        lifecycleScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                findNavController().navigate(R.id.homeFragment)
            }
        }

    }
}