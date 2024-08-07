package com.koniukhov.movieselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.koniukhov.movieselection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindNavigationBar()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun bindNavigationBar(){
        val bottomBar = binding.bottomNavigation
        NavigationUI.setupWithNavController(bottomBar, getNavController())
    }

    private fun getNavController(): NavController{
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        return navHostFragment.navController
    }
}