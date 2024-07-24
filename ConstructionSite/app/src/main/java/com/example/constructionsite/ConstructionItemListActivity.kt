package com.example.constructionsite

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constructionsite.databinding.ActivityConstructionItemListBinding

class ConstructionItemListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstructionItemListBinding
    private val viewModel: ConstructionItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstructionItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ConstructionAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this) { items ->
            adapter.submitList(items)
        }

        // Add fake items for demonstration (extended list)
        viewModel.setItems(fakeItems())
    }

    private fun fakeItems(): List<ConstructionItem> {
        return listOf(
            ConstructionItem(1, "Metal & Parts", "High-quality steel beams", 100,  R.drawable.team.toString()),
            ConstructionItem(2, "Hammers & Drones", "Durable hammers and construction drones", 50,  R.drawable.team.toString()),
            ConstructionItem(3, "Ladders & Scaffolding", "Sturdy ladders and safe scaffolding", 20,  R.drawable.iconsite.toString()),
            ConstructionItem(4, "Power Tools", "Variety of power tools for construction", 15, R.drawable.iconsite.toString()),
            ConstructionItem(5, "BIM Software", "Enables a realistic model of a building", 10,  R.drawable.iconsite.toString()),
            ConstructionItem(6, "Concrete Mix", "Ready-to-use concrete mix", 200,  R.drawable.team.toString()),
            ConstructionItem(7, "Safety Gear", "Helmets, vests, gloves, and more", 80,  R.drawable.team.toString()),
            ConstructionItem(8, "Plumbing Supplies", "Pipes, fittings, and fixtures", 120,  R.drawable.iconsite.toString()),
            ConstructionItem(9, "Electrical Wiring", "Wires, cables, and electrical components", 150,  R.drawable.iconsite.toString()),
            ConstructionItem(10, "Lumber", "Various types of wood for construction", 300,  R.drawable.team.toString())
        )
    }
}