package com.example.capyy
import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Rect
import android.media.MediaPlayer
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.NonCancellable.cancel
class canvas(context: Context?, val dialog:()->Unit): View(context) {
    private lateinit var rect: Rect
    private lateinit var pel: Rect
    private lateinit var cre: Rect
    private lateinit var end: Rect
    private lateinit var nuc: Rect
    private lateinit var jetpack: Rect
    private lateinit var safe: Rect
    private lateinit var multi: Rect
    private lateinit var speedd: Rect

    private var bottom: Int=950
    private var bottom1: Int=950
    private var bottom2: Int=550
    private var xc:Int = 1500
    private var xe:Int = 2600
    var xc1:Int = 800
    var xe1:Int = 200
    private var y0:Int=0
    private var y:Int=0
    var c1:Int=950
    private var y2:Int=2050
    var a:Int=1
    private var s:Int=3
    private var l:Int=900
    private var p1:Int=950
    private var e:Int=1
    var score:Int=0
    private var m:Int=100000
    private var sa:Int=100000
    private var sp:Int=100000
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var paint: Paint
    private lateinit var tran: Paint
    private val capybara by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.capybara)
    }
    private val pelican by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.pelican1)
    }
    private val creeper by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.creeper)
    }
    private val enderman by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.enderman)
    }
    private val bomb by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.bomb)
    }
    private val jet by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.jetpack)
    }
    private val safety by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.block)
    }
    private val multiple by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.score_multiplier)
    }
    private val speed by lazy{
        BitmapFactory.decodeResource(resources, R.drawable.speedd)
    }
    override fun onDraw(canvas: Canvas?){
        setBackgroundResource(R.drawable.forest)

        super.onDraw(canvas)
        rect= Rect(xc1,c1-120,xc1+200,c1)
        pel=Rect(xe1,p1-254,xe1+300,p1)
        cre=Rect(xc,bottom-200,xc+98,bottom)
        end=Rect(xe,bottom1-300,xe+110,bottom1)
        nuc=Rect(y2,bottom2-63,y2 +110,bottom2)
        jetpack=Rect(xc1-15,c1-130,xc1+75,c1-40)
        safe=Rect(sa,bottom-90,sa+75,bottom-15)
        multi=Rect(m,bottom-90,m+75,bottom-15)
        speedd=Rect(sp,bottom-90,sp+75,bottom-15)
        paint=Paint().apply { isAntiAlias=true
        color=Color.BLACK
        style=Paint.Style.STROKE}
        paint.textSize= 60F
        canvas!!.drawText(score.toString(),950F,225F,paint)
        tran=Paint().apply { isAntiAlias=true
            color=Color.TRANSPARENT
            style=Paint.Style.FILL}
        if(Math.abs(((xc1 + 100) - xc) - 49) <150){
            if(Math.abs((c1-60-850))<160) {
                if(xc1>(xe1+300)){
                xc=525}
                else{
                    xc=300
                }
                xc1-= 150
                if(xc1==xe1+300){
                   a=0
                    xc1=10000

                    dialog()
                }
            }
            else{
                score+=a*s
            }
        }
        if(Math.abs(((xc1 + 100) - xe) - 55) <156){
            if(Math.abs((c1-60-800))<210) {
                    a=0
                c1=10000
                xc1=10000
                    dialog()
            }
            else{
                score+=a*s
            }
        }
        if(Math.abs(((xc1 + 100) - y2) - 55) <156){
            if(Math.abs((c1-60-518))<92) {
                    a=0
                c1=10000
                xc1=10000
                    dialog()
            }
            else{
                score+=a*s
            }
        }
        if(Math.abs(((xc1 + 100) - m) - 38) <139){
            if(c1>860) {

                score+=2500
            }
            m=100000}
            if(Math.abs(((xc1 + 100) - sa) - 38) <139){
              if(c1>860) {
                    xc1=800
                }
                sa=100000}
        if(Math.abs(((xc1 + 100) - sp) - 38) <139){
            if(c1>860) {
               if(a>5){
                   a=5
               }
                else{
                    a=1
               }
                sp=100000
            }}
        fun creeper(){
            y0=(2230..3000).random()
            while(Math.abs(y0-xe)<l){
                y0=(2230..3000).random()
            }
            xc=y0
            if(a<40&&a!=0) {a=a+1}
            var rand=(1..15).random()
            if(rand==1){
                m=(xc+xe)/2
            }
            else{
                m=100000
            }
            if(rand==2){
                sa=(xc+xe)/2
            }
            else{
                sa=100000
            }
            if(rand==3){
                sp=(xc+xe)/2
            }
            else{
                sp=100000
            }
        }
        fun enderman(){
            y=(2230..3000).random()
            while(Math.abs(y-xc)<l){
                y=(2230..3000).random()
            }
            xe=y
            y2=(xc+xe)/2
        }
        if(xc<e){
          creeper()
        }
        if(xe<e){
            enderman()
        }
        if(a*s<10){
            if(xc<xe1+21+300&&xc>xe1+300-60||xe<xe1+300+21&&xe>xe1+300-60){
                p1=p1-4*a*s
            }
        if((xc<xe1+300-388&&xc>xe1+300-430+e||xe<xe1+300-388&&xe>xe1+300-430+e)){
            p1=p1+8*(a*s)
        }}
       else{
            if(xc<xe1+21+300&&xc>xe1+300-60||xe<xe1+300+21&&xe>xe1+300-60){
                p1=630
            }
            if(xc<xe1+300-388&&xc>xe1+300-430+e||xe<xe1+300-388&&xe>xe1+300-430+e){
                p1=950
            }
        }
        xc=xc-s*a
        xe=xe-s*a
        y2=y2-s*a
        if(m<10000){
        m=m-s*a}
        if(sa<10000){
        sa=sa-s*a}
        if(sp<10000){
            sp=sp-s*a}
        canvas?.drawBitmap(capybara,null,rect,null)
        canvas?.drawBitmap(pelican,null,pel,null)
        canvas?.drawBitmap(creeper,null,cre,null)
        canvas?.drawBitmap(enderman,null,end,null)
        canvas?.drawBitmap(bomb,null,nuc,null)
        canvas?.drawBitmap(safety,null,safe,null)
        canvas?.drawBitmap(multiple,null,multi,null)
        canvas?.drawBitmap(speed,null,speedd,null)
        if(c1!=950){
            canvas?.drawBitmap(jet,null,jetpack,null)
        }
        invalidate()
    }
    override fun onTouchEvent(event: MotionEvent?):Boolean{
        when(event?.action){
            MotionEvent.ACTION_UP->jump()
            MotionEvent.ACTION_DOWN->cancel()
        }
        return true
    }
    private fun jump(){
        while(c1<950){

            c1=c1+10
        }

        dialog()
    }
    private fun cancel(){
        while(c1>550){
            c1=c1-10}
        dialog()
    }
}
