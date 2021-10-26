package com.dan.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        tvNumber.text = viewModel.number.toString()

        btnAdd.setOnClickListener {
            viewModel.addNumber()
            tvNumber.text = viewModel.number.toString()
        }

    }
}