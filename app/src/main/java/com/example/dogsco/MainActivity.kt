package com.example.dogsco

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dogsco.databinding.ActivityMainBinding
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.dogsco.ui.gallery.GalleryFragment
import com.example.dogsco.ui.home.HomeFragment
import android.content.SharedPreferences
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        var Barf = BarfCalculator(Fragment(), 0.0, 0.0, 0.0)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val pref = applicationContext.getSharedPreferences("MyPref", 0)
        var appLaunchCount = pref.getInt("appLaunchCount", -1)
        if (appLaunchCount >= 2) {
            // code to show dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("DOGSBOX !")
            builder.setMessage("Voici DOGSBOX ! Cette application est une boîte à outil tout en un permettant de trouver des infos utiles et indispensables à tout propriétaire d’un canidé ! DOGSBOX propose un calculateur de ration crue personnalisé en fonction de votre chien, et une carte affichant les animaleries ou les vétérinaires les plus proches où que vous soyez !\n" +
                    "\n" +
                    "L’alimentation crue à de nombreux bénéfices :\n" +
                    "\n" +
                    "Un chien nourri au BARF bénéficie d'une nourriture saine et est en meilleure santé, son système immunitaire est renforcé, il a une meilleure vitalité et tombe moins souvent malade. De ce fait il vieillit mieux et son espérance de vie augmente. ")

            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.ok, Toast.LENGTH_SHORT).show()
            }
            builder.show()
            // reset
            appLaunchCount = 0

        } else {
            // increment count
            appLaunchCount += 1
        }
        val editor = pref.edit()
        editor.putInt("appLaunchCount", appLaunchCount)
        editor.apply()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)
        navHost?.let { navFragment ->
            navFragment.childFragmentManager.primaryNavigationFragment?.let { fragment ->
                if (fragment is HomeFragment) {
                    finish()
                } else {
                    finish()
                    startActivity(Intent(this, MainActivity::class.java))
                    super.onBackPressed()
                }
            }
        }
    }
}