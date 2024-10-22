package com.example.constructionsite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
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
    private val projects = mutableListOf<Project>() // List of Project objects
    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        drawerLayout = findViewById(R.id.drawer_layout)
        projectRecyclerView = findViewById(R.id.projectRecyclerView)

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

        // Set up RecyclerView
        initializeMockProjects()
        projectAdapter = ProjectAdapter(projects) { project ->
            // Navigate to the Dashboard screen with project name
            val intent = Intent(this, DashboardScreen::class.java).apply {
                putExtra("PROJECT_NAME", project.name)
            }
            startActivity(intent)
        }
        projectRecyclerView.adapter = projectAdapter
        projectRecyclerView.layoutManager = LinearLayoutManager(this)

        // Floating Action Button for adding new projects
        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            showCreateProjectDialog()
        }
    }

    private fun initializeMockProjects() {
        // Adding mock projects with icons
        projects.add(Project("High Rise Building", R.drawable.conicon))
        projects.add(Project("Shopping Mall", R.drawable.iconsite))
        projects.add(Project("Office Complex", R.drawable.conicon))
        projects.add(Project("Residential Area", R.drawable.conicon))
        // Add more mock projects as needed
    }

    private fun showCreateProjectDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_create_project, null)
        val projectNameEditText = view.findViewById<EditText>(R.id.projectNameEditText)

        builder.setView(view)
            .setPositiveButton("Create") { dialog, _ ->
                val projectName = projectNameEditText.text.toString()
                if (projectName.isNotEmpty()) {
                    // For simplicity, using a default icon for new projects
                    projects.add(Project(projectName, R.drawable.conicon))
                    projectAdapter.notifyItemInserted(projects.size - 1) // Notify adapter of new item
                    projectRecyclerView.scrollToPosition(projects.size - 1) // Scroll to new item
                } else {
                    Toast.makeText(this, "Project name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_project_name -> {
                // Navigate to Project Name screen
            }
            R.id.nav_change_password -> {
                // Navigate to Change Password screen
            }
            R.id.nav_support -> {
                // Navigate to Support screen
            }
            R.id.nav_logout -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
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

    // Project Adapter class to display the project list
    inner class ProjectAdapter(
        private val projectList: MutableList<Project>,
        private val onProjectClick: (Project) -> Unit
    ) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

        inner class ProjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val projectIcon: ImageView = view.findViewById(R.id.projectIcon)
            val projectName: TextView = view.findViewById(R.id.projectName)

            init {
                view.setOnClickListener {
                    onProjectClick(projectList[adapterPosition])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.project_item, parent, false)
            return ProjectViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
            val project = projectList[position]
            holder.projectIcon.setImageResource(project.iconResId)
            holder.projectName.text = project.name
        }

        override fun getItemCount() = projectList.size
    }

    // Data class for Project
    data class Project(val name: String, val iconResId: Int)
}