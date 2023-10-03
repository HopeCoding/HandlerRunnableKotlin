package com.hopecoding.handlerrunnablekotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.hopecoding.handlerrunnablekotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var handler=Handler(Looper.myLooper()!!)

    var runnable:Runnable= Runnable {  }

    var time:Int=0




    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
    }


    @SuppressLint("SetTextI18n")
    fun start(view:View){
        runnable=object :Runnable{
            override fun run() {
                time++
                binding.timeText.text="Time:$time"
                handler.postDelayed(runnable,1000)
            }
        }

        handler.post(runnable)
        binding.startbtn.isEnabled=false
        binding.stopbtn.isEnabled=true

    }

    fun stop(view:View){
        handler.removeCallbacks(runnable)
        time=0
        binding.timeText.text="Time has stopped"
        binding.startbtn.isEnabled=true
        binding.stopbtn.isEnabled=false

    }
}