package com.example.teplo.newsapp.presentation.drawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.teplo.newsapp.R
import com.example.teplo.newsapp.presentation.about.AboutAsFragment
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*
import kotlinx.android.synthetic.main.part_navigation.*

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var aboutAs: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        initToolbar()
        initNavigationDrawer()

    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun initNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val menu = navigationView.menu
        aboutAs = menu.findItem(R.id.about_as)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer()
            return
        }
        super.onBackPressed()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_as -> openAboutAs()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openAboutAs() {
        title = "About as"
        selectFragment(AboutAsFragment())
    }

    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, null)
                .commitAllowingStateLoss()
        closeDrawer()
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawers()
    }
}
