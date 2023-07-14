package com.example.capyy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class info : AppCompatActivity() {
    var wordz=""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        getscores()
        val capyplay:ImageButton =findViewById(R.id.capyplay)
        val hsw = intent.getStringExtra("highscore")
        val ip1=intent.getStringExtra("ip1")
        val ip2=intent.getStringExtra("ip2")
        val ip3=intent.getStringExtra("ip3")
        val ic1=intent.getStringExtra("ic1")
        val ic2=intent.getStringExtra("ic2")
        val ic3=intent.getStringExtra("ic3")
        val t1:TextView=findViewById(R.id.t1)
        val t2:TextView=findViewById(R.id.t2)
        val t3:TextView=findViewById(R.id.t3)
        var p1:String
        var c1:String

        getword()












        capyplay.setOnClickListener{
            Log.d("wordzzzzzzz","word found ${wordz}")

            if(t2.text.toString().toLowerCase()=="jack"){
                p1= ip1.toString()
            }
            else if(t2.text.toString().toLowerCase()=="maxwell"){
                p1= ip2.toString()
            }
            else if(t2.text.toString().toLowerCase()=="alex"){
                p1=ip3.toString()
            }
            else{
                p1=""
            }
            if(t3.text.toString().toLowerCase()=="michael"){
                c1=ic1.toString()
            }
            else if(t3.text.toString().toLowerCase()=="mio"){
                c1=ic2.toString()
            }
            else if(t3.text.toString().toLowerCase()=="oliver"){
                c1=ic3.toString()
            }
            else{
                c1=""
            }
            Log.d("TAG","response success ${c1}")
            Log.d("TAG","response success ${p1}")

            val intent = Intent(this, spalshactivity::class.java)
            intent.putExtra("highscore",hsw)
            intent.putExtra("ip1",p1)
            intent.putExtra("word",wordz)
            intent.putExtra("name",t1.text.toString())

            intent.putExtra("ic1",c1)


            startActivity(intent)
        }
    }
    private fun getword(){
        val retrofitBuilder2 = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
            .create(apiinterface::class.java)

        val retrofitData2 = retrofitBuilder2.getword()
        retrofitData2.enqueue(object: Callback<word> {

            override fun onResponse(call: Call<word>, response: Response<word>) {
                wordz = response.body()!!.word
                Log.d("word","word found ${wordz}")
            }

            override fun onFailure(call: Call<word>, t: Throwable) {
                Log.d("word","word not found")
            }

        }
        )
    }




    private fun getscores(){
        val s1:TextView=findViewById(R.id.s1)
        val s2:TextView=findViewById(R.id.s2)
        val s3:TextView=findViewById(R.id.s3)
        val s4:TextView=findViewById(R.id.s4)
        val s5:TextView=findViewById(R.id.s5)

        val l1:TextView=findViewById(R.id.l1)
        val l2:TextView=findViewById(R.id.l2)
        val l3:TextView=findViewById(R.id.l3)
        val l4:TextView=findViewById(R.id.l4)
        val l5:TextView=findViewById(R.id.l5)

        val retrofitBuilder1 = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
            .create(apiinterface::class.java)

        val retrofitData1 = retrofitBuilder1.getscore()
        retrofitData1.enqueue(object: Callback<score> {

            override fun onResponse(call: Call<score>, response: Response<score>) {
                val score = response.body()?.scores
                var scorelist= mutableListOf<Int>()
                var namelist= mutableListOf<String>()


                if (score != null && score.isNotEmpty()) {
                    for(i in 0..score.size-1){
                        scorelist.add(score[i].score)
                    }
                    scorelist.sort()

                        for(k in 0..score.size-1) {
                            if (score[k].score in scorelist) {
                                namelist.add(score[k].name)
                            }
                        }
                    s1.text=(scorelist[scorelist.size-1]*312).toString()
                    s2.text=(scorelist[scorelist.size-2]*312).toString()
                    s3.text=(scorelist[scorelist.size-3]*312).toString()
                    s4.text=(scorelist[scorelist.size-4]*312).toString()
                    s5.text=(scorelist[scorelist.size-5]*312).toString()

                    l1.text=namelist[0]
                    l2.text=namelist[1]
                    l3.text=namelist[2]
                    l4.text=namelist[3]
                    l5.text=namelist[4]

                    val sc1= score[0].name
                    Log.d("TAG","response success for score ${sc1}")
                    Log.d("TAG","response success for scorelist ${scorelist[0]}")
                }

                Log.d("TAG","response success for score ${score?.size}")
            }

            override fun onFailure(call: Call<score>, t: Throwable) {
                Log.d("TAG","response not found for player")

            }
        }
        )
    }
}