package com.example.capyy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.capyy.databinding.ActivityPlayerzBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class playerz : AppCompatActivity() {
    private var ip1:String=""
    private var ip2:String=""
    private var ip3:String=""
    private var ic1:String=""
    private var ic2:String=""
    private var ic3:String=""
    //val hsw = intent.getStringExtra("highscore")

    private lateinit var binding: ActivityPlayerzBinding

    @SuppressLint("WrongViewCast", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        ic1=""
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

        getmyplayer()
        //val play:TextView=findViewById(R.id.play)
        /*binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

    }
    @SuppressLint("SuspiciousIndentation")
    private fun getmyplayer() {
            val retrofit= ServiceBuilder.buildService(apiinterface::class.java)
            val obj=p("player")
            retrofit.getplayer(obj).enqueue(
                object:Callback<players>{
                    override fun onResponse(call: Call<players>, response: Response<players>) {
                        val pn1:TextView=findViewById(R.id.pn1)
                        val pd1:TextView=findViewById(R.id.pd1)
                        val pt1:TextView=findViewById(R.id.pt1)
                        val p1:ImageView=findViewById(R.id.p1)

                        val pn2:TextView=findViewById(R.id.pn2)
                        val pd2:TextView=findViewById(R.id.pd2)
                        val pt2:TextView=findViewById(R.id.pt2)
                        val p2:ImageView=findViewById(R.id.p2)

                        val pn3:TextView=findViewById(R.id.pn3)
                        val pd3:TextView=findViewById(R.id.pd3)
                        val pt3:TextView=findViewById(R.id.pt3)
                        val p3:ImageView=findViewById(R.id.p3)

                        val player = response.body()?.characters

                        val play1= player?.get(0)
                        pn1.text= play1!!.name
                        pd1.text= play1!!.description
                        pt1.text= play1!!.type
                        ip1=play1.imageUrl
                        Picasso.get().load("${play1.imageUrl}").into(p1)

                        val play2= player?.get(1)
                        pn2.text= play2!!.name
                        pd2.text= play2!!.description
                        pt2.text= play2!!.type
                        ip2=play2.imageUrl
                        Picasso.get().load("${play2.imageUrl}").into(p2)

                        val play3= player?.get(2)
                        pn3.text= play3!!.name
                        pd3.text= play3!!.description
                        pt3.text= play3!!.type
                        ip3=play3.imageUrl
                        Picasso.get().load("${play3.imageUrl}").into(p3)
                        Log.d("TAG","response success for player ${play1.imageUrl}")
                    }

                    override fun onFailure(call: Call<players>, t: Throwable) {
                        Log.d("TAG","response not found for player")

                    }
                }
            )
            val obj1=p("chaser")
            retrofit.getplayer(obj1).enqueue(
                object:Callback<players>{
                    override fun onResponse(call: Call<players>, response: Response<players>) {
                        val cn1:TextView=findViewById(R.id.cn1)
                        val cd1:TextView=findViewById(R.id.cd1)
                        val ct1:TextView=findViewById(R.id.ct1)
                        val c1:ImageView=findViewById(R.id.c1)


                        val cn2:TextView=findViewById(R.id.cn2)
                        val cd2:TextView=findViewById(R.id.cd2)
                        val ct2:TextView=findViewById(R.id.ct2)
                        val c2:ImageView=findViewById(R.id.c2)

                        val cn3:TextView=findViewById(R.id.cn3)
                        val cd3:TextView=findViewById(R.id.cd3)
                        val ct3:TextView=findViewById(R.id.ct3)
                        val c3:ImageView=findViewById(R.id.c3)

                        val chaser = response.body()?.characters

                        val chas1= chaser?.get(0)
                        cn1.text= chas1!!.name
                        cd1.text= chas1!!.description
                        ct1.text= chas1!!.type
                        ic1=chas1.imageUrl
                        Picasso.get().load("${chas1.imageUrl}").into(c1)

                        val chas2= chaser?.get(1)
                        cn2.text= chas2!!.name
                        cd2.text= chas2!!.description
                        ct2.text= chas2!!.type
                        ic2=chas2.imageUrl
                        Picasso.get().load("${chas2.imageUrl}").into(c2)

                        val chas3= chaser?.get(2)
                        cn3.text= chas3!!.name
                        cd3.text= chas3!!.description
                        ct3.text= chas3!!.type
                        ic3=chas3.imageUrl
                        Picasso.get().load("${chas3.imageUrl}").into(c3)

                        Log.d("TAG","response success for player ${chas1.name}")
                    }

                    override fun onFailure(call: Call<players>, t: Throwable) {
                        Log.d("TAG","response not found for chaser")

                    }
                }
            )



        val next:Button=findViewById(R.id.button3)
        next.setOnClickListener{
            val intent = Intent(this, info::class.java)


                //intent.putExtra("highscore",hsw)
                intent.putExtra("ip1",ip1)
                intent.putExtra("ip2",ip2)
                intent.putExtra("ip3",ip3)
                intent.putExtra("ic1",ic1)
                intent.putExtra("ic2",ic2)
                intent.putExtra("ic3",ic3)
                startActivity(intent)
            }

        }

        }

