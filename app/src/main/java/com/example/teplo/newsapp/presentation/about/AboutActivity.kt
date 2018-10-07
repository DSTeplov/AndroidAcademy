package com.example.teplo.newsapp.presentation.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.teplo.newsapp.R

class AboutActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AboutActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_about)
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayShowHomeEnabled(false)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
////
// }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//
//                // drawerLayout.openDrawer(GravityCompat.START)
//                onBackPressed()
//                true
//            }
//            else -> false
//        }
    //}
}
