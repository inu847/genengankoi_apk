package com.example.genengankoi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.ui.RetrofitClient
import com.example.genengankoi.ui.product.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    private val list = ArrayList<ProductResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_product, R.id.navigation_lelang, R.id.navigation_rekpen))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        val appLinkIntent = intent
//        val appLinkAction = appLinkIntent.action
//        val appLinkData = appLinkIntent.data
    }

//    override fun onNewIntent(intent: Intent) {
//        super.onNewIntent(intent)
//        handleIntent(intent)
//    }
//
//    private fun handleIntent(intent: Intent) {
//        val appLinkAction = intent.action
//        val appLinkData: Uri? = intent.data
//        if (Intent.ACTION_VIEW == appLinkAction) {
//            appLinkData?.lastPathSegment?.also { recipeId ->
//                Uri.parse("content://com.recipe_app/recipe/")
//                    .buildUpon()
//                    .appendPath(recipeId)
//                    .build().also { appData ->
//                        showRecipe(appData)
//                    }
//            }
//        }
//    }
}