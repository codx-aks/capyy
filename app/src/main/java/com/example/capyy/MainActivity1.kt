package com.example.capyy

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity1 : AppCompatActivity() {
    var x:Int=0
    lateinit var canvas:canvas
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlaye: MediaPlayer
    private lateinit var media: MediaPlayer




    override fun onCreate(savedInstanceState: Bundle?) {

        val dialog={
            if(canvas.c1!=950){
                mediaPlaye= MediaPlayer.create(this,R.raw.rocket)
                mediaPlaye.start()
                mediaPlaye.isLooping=true

            }
            if(canvas.c1==950) {
                mediaPlaye.stop()
            }
            if(canvas.a==0){
            media= MediaPlayer.create(this,R.raw.sup)
            media.start()}
            if(canvas.a==0)
            {
                mediaPlayer.stop()
                mediaPlaye.stop()


                val dialogBinding1 = layoutInflater.inflate(R.layout.gameover, null)
                val mydialog1 = Dialog(this)
                mydialog1.setContentView(dialogBinding1)
                mydialog1.setCancelable(true)
                val score = dialogBinding1.findViewById<TextView>(R.id.score)
                val home = dialogBinding1.findViewById<ImageButton>(R.id.home1)
                sf=getSharedPreferences("MY", Context.MODE_PRIVATE)
                var highscore=sf.getString("highscore","").toString()
                score.text = canvas.score.toString()
                if(highscore!=""){
                if(canvas.score>highscore.toFloat()){
                    highscore=canvas.score.toString()
                }}
                else{
                    highscore=canvas.score.toString()
                }


                val editor=sf.edit()
                editor.putString("highscore",highscore)
                editor.apply()
                home.setOnClickListener{
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)

                    mydialog1.dismiss()
                }
                mydialog1.show()}



        }




        super.onCreate(savedInstanceState)
        mediaPlayer= MediaPlayer.create(this,R.raw.rick)
        mediaPlayer.start()
        mediaPlayer.isLooping=true
        canvas=canvas(this,dialog)
        setContentView(canvas)

       }
    }
