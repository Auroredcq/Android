package fr.isen.debacq.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.debacq.androiderestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extra = intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        binding.categoryTitle.text = intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        binding.categoryList.layoutManager = LinearLayoutManager(this)

        val category : List<Category> = when(extra){
            "Entrées"->{resources.getStringArray(R.array.starters).map{Category(it)}}
            "Plats"->{resources.getStringArray(R.array.dishes).map{Category(it)}}
            "Desserts"->{resources.getStringArray(R.array.deserts).map{Category(it)}.toList()}
            else->{
                emptyList()}
        }
        binding.categoryList.adapter = FoodAdapter(category)
    }



}




data class Food (
    val nom : String,
    val compo : String,
    //val prix : String
    )