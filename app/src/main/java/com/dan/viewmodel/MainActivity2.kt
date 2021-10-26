package com.dan.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tvNumber = findViewById<TextView>(R.id.tvNumber2)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val etText = findViewById<EditText>(R.id.etText)

        val viewModel = ViewModelProvider(this).get( MainActivityViewModel2::class.java)

        //viewModel.startTimer()


        viewModel.finished.observe(this, Observer {
           if(it){
               Toast.makeText(this,"Finished!", Toast.LENGTH_SHORT).show()
           }
        })

        viewModel.seconds().observe(this, Observer {
            tvNumber.text = it.toString()
        })


        btnStart.setOnClickListener {

            if(etText.text.isEmpty() || etText.text.length < 4){
                Toast.makeText(this,"Invalid!", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.timerValue.value = etText.text.toString().toLong()
                viewModel.startTimer()
            }
        }

        btnStop.setOnClickListener {
            if(etText.text.isNotEmpty()){
                tvNumber.text = "0"
                viewModel.stopTimer()
            }
        }
    }
}