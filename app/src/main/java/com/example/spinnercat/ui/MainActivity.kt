package com.example.spinnercat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.spinnercat.R


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)

        viewModel.getBreads()

        viewModel.breedsLiveData.observe(this) {
            val breedsNameList: List<String> =
                viewModel.breedsLiveData.value?.map { it.breed.toString() } ?: listOf()
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, breedsNameList)
        }
        val image = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            viewModel.getCatImage(spinner.selectedItem.toString())
            viewModel.catLiveData.observe(this) {
                Glide.with(this).load(it).placeholder(R.drawable.load).into(image)
            }
        }
    }
}