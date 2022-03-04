package fr.isen.debacq.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import fr.isen.debacq.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding  : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.homeStarters.setOnClickListener {
            //Toast.makeText(this, getString(R.string.home_starters),Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.home_starters))
        }
        binding.homeDishes.setOnClickListener {
            //Toast.makeText(this, getString(R.string.home_dishes),Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.home_dishes))
        }
        binding.homeDeserts.setOnClickListener {
            //Toast.makeText(this, getString(R.string.home_deserts),Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.home_deserts))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "L'activité est détruite")
    }

    private fun startCategory(category: String) {
        val intent = Intent(this, CategoryActivity::class.java)
        intent.putExtra(CATEGORY_KEY, category)
        startActivity(intent)
    }

    companion object {
        const val CATEGORY_KEY = "category"
    }
    }


