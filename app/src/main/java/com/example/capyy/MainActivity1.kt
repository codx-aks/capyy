package com.example.capyy

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity1 : AppCompatActivity() {
    var x:Int=0
    lateinit var canvas:canvas
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlaye: MediaPlayer
    private lateinit var media: MediaPlayer
    var rank:Int = 0
    var w= mutableListOf<String>()
    var wo= mutableListOf<String>()



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        var ip1=intent.getStringExtra("ip1")
        var ic1=intent.getStringExtra("ic1")
        val wordz=intent.getStringExtra("word")

        val t1=intent.getStringExtra("name")
        if(ip1==""){
            ip1="a"
        }
        if(ic1==""){
            ic1="a"
        }


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
            media.start()
                mediaPlayer.stop()
                mediaPlaye.stop()


                val dialogBinding1 = layoutInflater.inflate(R.layout.gameover, null)
                val mydialog1 = Dialog(this)
                mydialog1.setContentView(dialogBinding1)
                mydialog1.setCancelable(true)
                val score = dialogBinding1.findViewById<TextView>(R.id.score)
                val home = dialogBinding1.findViewById<ImageButton>(R.id.home1)
                val ran = dialogBinding1.findViewById<TextView>(R.id.rank)
                val retrofitBuilder1 = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASEURL)
                    .build()
                    .create(apiinterface::class.java)

                val retrofitData1 = retrofitBuilder1.getscore()
                retrofitData1.enqueue(object: Callback<score> {

                    override fun onResponse(call: Call<score>, response: Response<score>) {
                        val scorez = response.body()?.scores

                        var scorelist= mutableListOf<Int>()
                        var namelist= mutableListOf<String>()


                        if (scorez != null && scorez.isNotEmpty()) {
                            for(i in 0..scorez.size-1){
                                scorelist.add((scorez[i].score)*312)
                            }
                            scorelist.add(canvas.score)
                            scorelist.sort()

                            for(i in 0..scorelist.size-1){
                                if(scorelist[i]==canvas.score){
                                    rank=(scorelist.size)-i

                                }
                            }
                            ran.text=rank.toString()


                            val sc1= scorez[0].name
                            Log.d("TAG","response success for rank ${rank}")
                            Log.d("TAG","response success for scorelist ${scorelist[0]}")
                        }

                        Log.d("TAG","response success for score ${scorez?.size}")
                    }

                    override fun onFailure(call: Call<score>, t: Throwable) {
                        Log.d("TAG","response not found for player")

                    }
                }
                )
                Log.d("rankkkk","response not found for player ${rank}")


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
                mydialog1.show()



            }



        }




        super.onCreate(savedInstanceState)
        mediaPlayer= MediaPlayer.create(this,R.raw.rick)
        mediaPlayer.start()
        mediaPlayer.isLooping=true
        for(i in 0..(wordz!!.length)-1){
            w.add(wordz[i].toString())
        }
        for(i in 0..w.size-1){
            if(!(w[i] in wo)){
                wo.add(w[i])
            }
        }
        canvas=canvas(this,dialog, ip1.toString(), ic1.toString(), w,wo,wordz)
        Log.d("canvaswordd","response ? ${wordz} ${wo}  ${w[0]}")
        setContentView(canvas)

       }

    }
