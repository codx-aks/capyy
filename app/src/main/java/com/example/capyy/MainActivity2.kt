package com.example.capyy

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.core.view.isVisible

class MainActivity2 : AppCompatActivity() {
    private lateinit var hsw:String
    private lateinit var media: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        media= MediaPlayer.create(this,R.raw.creepy)
        media.start()
        media.isLooping=true
        val v:VideoView=findViewById(R.id.videoview)
        val s:ImageButton=findViewById(R.id.imageButton)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.start)
        v.setVideoURI(uri)
        v.requestFocus()
        v.start()
        val hs:TextView=findViewById(R.id.hs)
        val sf=getSharedPreferences("MY", Context.MODE_PRIVATE)
        hsw= sf.getString("highscore","").toString()
        hs.text=hsw


        val info:ImageButton=findViewById(R.id.info)
        val close:ImageButton=findViewById(R.id.close)
        val rules:ImageView=findViewById(R.id.rules)
        info.setOnClickListener{
            close.isVisible=true
            rules.isVisible=true
            v.alpha=0.33F
        }
        close.setOnClickListener{
            close.isVisible=false
            rules.isVisible=false
            v.alpha=1.00F
        }
        s.setOnClickListener {
            media.stop()
            val intent = Intent(this, MainActivity1::class.java)
            intent.putExtra("highscore",hsw)
            startActivity(intent)
        }
        val dialogBinding1 = layoutInflater.inflate(R.layout.gameover, null)
        val mydialog1 = Dialog(this)
        mydialog1.setContentView(dialogBinding1)
        mydialog1.setCancelable(true)

    }
}