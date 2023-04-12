package com.atilsamancioglu.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.atilsamancioglu.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPrefences Initialize
        sharedPreferences = this.getSharedPreferences("com.atilsamancioglu.storingdata",
            Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if (ageFromPreferences == -1) {
            binding.textView.text = "Your Age: "
        } else {
            binding.textView.text = "Your Age: $ageFromPreferences"
        }


    }

    fun save(view : View){

        val myAge = binding.editText.text.toString().toIntOrNull()

        if (myAge != null) {
            binding.textView.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }


    }

    fun delete(view: View) {

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if (ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your Age: "
        }

    }
}
