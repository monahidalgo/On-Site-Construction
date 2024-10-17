import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.constructionsite.R

class DashboardScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_screen)

        val teamsButton = findViewById<Button>(R.id.teams_button)
        val projectsButton = findViewById<Button>(R.id.projects_button)
        val equipmentButton = findViewById<Button>(R.id.equipment_button)
        val orderItemsButton = findViewById<Button>(R.id.order_items_button)



        teamsButton.setOnClickListener {
            // Handle teams button click
        }

        projectsButton.setOnClickListener {
            // Handle projects button click
        }

        equipmentButton.setOnClickListener {
            // Handle equipment button click
        }

        orderItemsButton.setOnClickListener {

        }
    }
}