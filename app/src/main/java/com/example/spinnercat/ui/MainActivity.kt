package com.example.spinnercat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.spinnercat.DaggerApp
import com.example.spinnercat.R
import com.example.spinnercat.data.model.BreedsResponse
import com.example.spinnercat.di.ViewModel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: CatViewModel by viewModels { factory }

    private lateinit var spinner: Spinner
    private lateinit var image: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as DaggerApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupButton()
        setupImageView()

        viewModel.getBreads()
        viewModel.breedsLiveData.observe(this, ::onBreedsLoaded)
    }

    private fun setupViews() {
        spinner = findViewById(R.id.spinner)
        image = findViewById(R.id.imageView)
        button = findViewById(R.id.button)
    }

    private fun setupButton() {
        button.setOnClickListener {
            viewModel.getCatImage(spinner.selectedItem.toString())
            viewModel.catLiveData.observe(this, ::onCatImageLoaded)
        }
    }

    private fun setupImageView() {
        Glide.with(this).load(R.drawable.load).into(image)
    }

    private fun onBreedsLoaded(breedsResponses: List<BreedsResponse>) {
        val breedsNameList: List<String> = breedsResponses.mapNotNull { it.breed }
        spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, breedsNameList)
    }

    private fun onCatImageLoaded(catImageUrl: String) {
        Glide.with(this).load(catImageUrl).into(image)
    }
}
