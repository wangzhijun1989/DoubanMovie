package com.annarm.douban.moive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.annarm.douban.moive.app.DMApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(DMApplication.instance, "kot lin lin a", Toast.LENGTH_SHORT).show()
    }
}
