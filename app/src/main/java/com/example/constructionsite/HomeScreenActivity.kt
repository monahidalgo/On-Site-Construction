package com.example.constructionsite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


class HomeScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var projectRecyclerView: RecyclerView
    private val projects = mutableListOf<String>()
    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        drawerLayout = findViewById(R.id.drawer_layout)
        projectRecyclerView = findViewById(R.id.projectRecyclerView) // Make sure you have this in your layout

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

        // Set up RecyclerView
        projectAdapter = ProjectAdapter(projects) { projectName ->
            // Handle project click (you can open a new activity with project details here)
            // For now, just a Toast message
            Toast.makeText(this, "Clicked on project: $projectName", Toast.LENGTH_SHORT).show()
        }
        projectRecyclerView.adapter = projectAdapter
        projectRecyclerView.layoutManager = LinearLayoutManager(this)

        // Floating Action Button for adding new projects
        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton) // Make sure you have this in your layout
        fab.setOnClickListener {
            showCreateProjectDialog()
        }
    }

    private fun showCreateProjectDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_create_project, null)
        val projectNameEditText = view.findViewById<EditText>(R.id.projectNameEditText)

        builder.setView(view)
            .setPositiveButton("Create") { dialog, _ ->
                val projectName = projectNameEditText.text.toString()
                if (projectName.isNotEmpty()) {
                    projects.add(projectName)
                    projectAdapter.notifyItemInserted(projects.size - 1)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
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
                // Handle logout (e.g., add clearUserSession() function to clear user session,
                // navigate to MainActivity, and finish HomeScreenActivity)
                // in onResume() to check if user is still logged in)
                val intent = Intent(this, MainActivity::class.java)
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




// ProjectAdapter class (inside HomeScreenActivity.kt for simplicity)
