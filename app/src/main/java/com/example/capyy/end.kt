package com.example.capyy

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class end(): AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    val dialogBinding1 = layoutInflater.inflate(R.layout.gameover, null)
    val mydialog1 = Dialog(this)

    mydialog1.setContentView(dialogBinding1)
    mydialog1.setCancelable(true)
    mydialog1.show()
}}