package com.example.constructionsite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.example.constructionsite.R // Adjust package name if needed

class HomeScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Set profile information in the header (fetch from user data)
        val headerView = navigationView.getHeaderView(0)
        val profileNameTextView = headerView.findViewById<TextView>(R.id.profileNameTextView)
        val profilePhoneTextView = headerView.findViewById<TextView>(R.id.profilePhoneTextView)
        val profileEmailTextView = headerView.findViewById<TextView>(R.id.profileEmailTextView)

        profileNameTextView.text = "Mona Hidalgo " // Replace with actual user name
        profilePhoneTextView.text = "Phone: 323-400-0421" // Replace with actual phone
        profileEmailTextView.text = "Email: mona@bittleco.com" // Replace with actual email
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_project_name -> {
                // Navigate to Project Name screen
                // Start your ProjectNameActivity here (create a new activity for it)
            }
            R.id.nav_change_password -> {
                // Navigate to Change Password screen
                // Start your ChangePasswordActivity here
            }
            R.id.nav_support -> {
                // Navigate to Support screen
                // Start your SupportActivity here
            }
            R.id.nav_logout -> {
                // Handle logout (e.g., clear user session, navigate to LoginActivity)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Finish HomeScreenActivity
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}