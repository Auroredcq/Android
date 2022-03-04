package fr.isen.debacq.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Category(val nom: String)

class FoodAdapter(val categories: List<Category>) : RecyclerView.Adapter<FoodAdapter.CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.dishTitle.text=categories[position].nom
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val dishTitle: TextView = itemView.findViewById(R.id.dishTitle)
    }
}


