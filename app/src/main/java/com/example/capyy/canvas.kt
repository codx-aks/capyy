package com.example.capyy
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.NonCancellable.cancel

class canvas(
    context: Context?, val dialog: () -> Unit,
    val ic1: String,
    val ip1: String,
    val wordz: MutableList<String>,
    val wo: MutableList<String>,
    val wordz1: String
): View(context) {
    //private lateinit var wo:MutableList<String>
    private var wor= mutableListOf<String>()
   // private var xco= mutableListOf<Float>(5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F,5000F)
private var value=0

    private lateinit var ar: Rect
    private lateinit var br: Rect
    private lateinit var cr: Rect
    private lateinit var dr: Rect
    private lateinit var er: Rect
    private lateinit var fr: Rect
    private lateinit var gr: Rect
    private lateinit var hr: Rect
    private lateinit var ir: Rect
    private lateinit var jr: Rect
    private lateinit var kr: Rect
    private lateinit var lr: Rect
    private lateinit var mr: Rect
    private lateinit var nr: Rect
    private lateinit var orr: Rect
    private lateinit var pr: Rect
    private lateinit var qr: Rect
    private lateinit var rr: Rect
    private lateinit var sr: Rect
    private lateinit var tr: Rect
    private lateinit var ur: Rect
    private lateinit var vr: Rect
    private lateinit var wr: Rect
    private lateinit var xr: Rect
    private lateinit var yr: Rect
    private lateinit var zr: Rect





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
    private var s:Int=1
    private var l:Int=900
    private var p1:Int=950
    private var e:Int=1
    var score:Int=0
    private var m:Int=100000
    private var sa:Int=100000
    private var sp:Int=100000
    private var k:Int=0
    private lateinit var paint: Paint
    private lateinit var tran: Paint






    private val capybara by lazy{
        if(ip1=="a"){
        BitmapFactory.decodeResource(resources, R.drawable.capybara)}
        else if(ip1=="https://ik.imagekit.io/obstacleDodge/images/player/player782503.png"){
            Log.d("capybara","response present ${ip1}")
            BitmapFactory.decodeResource(resources, R.drawable.player1)

            /*val ulrn= URL(ip1)
            val con= ulrn.openConnection()
            con.doInput=true
            con.connect()
            val ism =con.getInputStream()
            BitmapFactory.decodeStream(ism)
            ism.close()*/
        }
        else if(ip1=="https://ik.imagekit.io/obstacleDodge/images/player/player798755.png"){
            BitmapFactory.decodeResource(resources, R.drawable.player2)
        }
        else{
            BitmapFactory.decodeResource(resources, R.drawable.player3)
        }
    }
    private val pelican by lazy{
        if(ic1=="a"){
        BitmapFactory.decodeResource(resources, R.drawable.pelican1)}
        else if(ic1=="https://ik.imagekit.io/obstacleDodge/images/chaser/chaser230408.png"){
            Log.d("pelican","response present")
            BitmapFactory.decodeResource(resources, R.drawable.chaser1)
        }
        else if(ic1=="https://ik.imagekit.io/obstacleDodge/images/chaser/chaser598404.png"){
            Log.d("pelican","response present")
            BitmapFactory.decodeResource(resources, R.drawable.chaser2)}
        else {
            BitmapFactory.decodeResource(resources, R.drawable.chaser3)
        }
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
    private val A by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.a)
    }
    private val B by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.b)
    }
    private val C by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.c)
    }
    private val D by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.d)
    }
    private val E by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.e)
    }
    private val F by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.f)
    }
    private val G by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.g)
    }
    private val H by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.h)
    }
    private val I by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.i)
    }
    private val J by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.j)
    }
    private val K by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.k)
    }
    private val L by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.l)
    }
    private val M by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.m)
    }
    private val N by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.n)
    }
    private val O by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.o)
    }
    private val P by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.p)
    }
    private val Q by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.q)
    }
    private val Ralpha by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.r)
    }
    private val S by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.s)
    }
    private val T by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.t)
    }
    private val U by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.u)
    }
    private val V by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.v)
    }
    private val W by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.w)
    }
    private val X by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.x)
    }
    private val Y by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.y)
    }
    private val Z by lazy{
        BitmapFactory.decodeResource(resources,R.drawable.z)
    }

    var ai=5000
    var bi=5000
    var ci=5000
    var di=5000
    var ei=5000
    var fi=5000
    var gi=5000
    var hi=5000
    var ii=5000
    var ji=5000
    var ki=5000
    var li=5000
    var mi=5000
    var ni=5000
    var oi=5000
    var pi=5000
    var qi=5000
    var ri=5000
    var si=5000
    var ti=5000
    var ui=5000
    var vi=5000
    var wi=5000
    var xi=5000
    var yi=5000
    var zi=5000


    override fun onDraw(canvas: Canvas?){
        //Log.d("canvaswordd","response ? ${wordz} ")


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


        ar=Rect(ai,bottom-90,ai+75,bottom-15)
        br=Rect(bi,bottom-90,bi+75,bottom-15)
        cr=Rect(ci,bottom-90,ci+75,bottom-15)
        dr=Rect(di,bottom-90,di+75,bottom-15)
        er=Rect(ei,bottom-90,ei+75,bottom-15)
        fr=Rect(fi,bottom-90,fi+75,bottom-15)
        gr=Rect(gi,bottom-90,gi+75,bottom-15)
        hr=Rect(hi,bottom-90,hi+75,bottom-15)
        ir=Rect(ii,bottom-90,ii+75,bottom-15)
        jr=Rect(ji,bottom-90,ji+75,bottom-15)
        kr=Rect(ki,bottom-90,ki+75,bottom-15)
        lr=Rect(li,bottom-90,li+75,bottom-15)
        mr=Rect(mi,bottom-90,mi+75,bottom-15)
        nr=Rect(ni,bottom2-90,ni+75,bottom2-15)
        orr=Rect(oi,bottom2-90,oi+75,bottom2-15)
        pr=Rect(pi,bottom2-90,pi+75,bottom2-15)
        qr=Rect(qi,bottom2-90,qi+75,bottom2-15)
        rr=Rect(ri,bottom2-90,ri+75,bottom2-15)
        sr=Rect(si,bottom2-90,si+75,bottom2-15)
        tr=Rect(ti,bottom2-90,ti+75,bottom2-15)
        ur=Rect(ui,bottom2-90,ui+75,bottom2-15)
        vr=Rect(vi,bottom2-90,vi+75,bottom2-15)
        wr=Rect(wi,bottom2-90,wi+75,bottom2-15)
        xr=Rect(xi,bottom2-90,xi+75,bottom2-15)
        yr=Rect(yi,bottom2-90,yi+75,bottom2-15)
        zr=Rect(zi,bottom2-90,zi+75,bottom2-15)



      //to draw text



        paint=Paint().apply { isAntiAlias=true
        color=Color.BLACK
        style=Paint.Style.FILL}
        paint.textSize= 60F
        canvas!!.drawText(score.toString(),920F,225F,paint)
        tran=Paint().apply { isAntiAlias=true
            color=Color.BLUE
            style=Paint.Style.FILL}
            tran.textSize= 60F

        canvas!!.drawText(wordz1,70F,125F,tran)

                /*

                 inside if{
                 j=random(0..wo.size-1)
                 make the x[j] equal to the conditions of the powerup
                 if picked up , add the wo[j] to wor(another array)
                 if(wor[k]==w[k]){
                     k=k+1
                 }
                 else{
                 k=0
                 clear the list named wor
                 }
                }
                if(k>=w.size)
                {
                score=score+25000
                }
                  */










        //for(j in 0..wo.size-1){
            //Log.d("tagggggggg","response success ${xco[j]}")
           // canvas!!.drawText("${wo[j]}", xco[j],920F,tran)
        //}

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

                score+=6900

            m=100000}}
        if(Math.abs(((xc1 + 100) - sa) - 38) <139){
              if(c1>860) {
                    xc1=800

                sa=100000}}
        if(Math.abs(((xc1 + 100) - sp) - 38) <139){
            if(c1>860) {

                    a=1

                sp=100000
            }}





        if(Math.abs(((xc1 + 100) - ai) - 38) <139){
            if(c1>860) {
                    if(wor.size<wordz.size){
                        if(wordz[wor.size].uppercase()=="A"){
                            wor.add("A")
                        }
                    }

            ai=5000}}
        if(Math.abs(((xc1 + 100) - bi) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="B"){
                        wor.add("B")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()


                }

            bi=5000}}
        if(Math.abs(((xc1 + 100) - ci) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="C"){
                        wor.add("C")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }


            ci=5000}}
        if(Math.abs(((xc1 + 100) - di) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="D"){
                        wor.add("D")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            di=5000}}
        if(Math.abs(((xc1 + 100) - ei) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="E"){
                        wor.add("E")
                    }
                }else{
                    wor= mutableListOf()
                }

            if(wor.size==wordz.size){
                score=score+25000
                wor= mutableListOf()
            }

            ei=5000}}
        if(Math.abs(((xc1 + 100) - fi) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="F"){
                        wor.add("F")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            fi=5000}}
        if(Math.abs(((xc1 + 100) - gi) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="G"){
                        wor.add("G")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            gi=5000}}
        if(Math.abs(((xc1 + 100) - hi) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="H"){
                        wor.add("H")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            hi=5000}}
        if(Math.abs(((xc1 + 100) - ii) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="I"){
                        wor.add("I")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ii=5000}}
        if(Math.abs(((xc1 + 100) - ji) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="J"){
                        wor.add("J")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ji=5000}}
        if(Math.abs(((xc1 + 100) - ki) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="K"){
                        wor.add("K")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ki=5000}}
        if(Math.abs(((xc1 + 100) - li) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="L"){
                        wor.add("L")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            li=5000}}
        if(Math.abs(((xc1 + 100) - mi) - 38) <139){
            if(c1>860) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="M"){
                        wor.add("M")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            mi=5000}}
        if(Math.abs(((xc1 + 100) - ni) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="N"){
                        wor.add("N")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ni=5000}}
        if(Math.abs(((xc1 + 100) - oi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="O"){
                        wor.add("O")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            oi=5000}}
        if(Math.abs(((xc1 + 100) - pi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="P"){
                        wor.add("P")
                    }
                    else{
                        wor= mutableListOf()

                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            pi=5000}}
        if(Math.abs(((xc1 + 100) - qi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="Q"){
                        wor.add("Q")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            qi=5000}}
        if(Math.abs(((xc1 + 100) - ri) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="R"){
                        wor.add("R")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ri=5000}}
        if(Math.abs(((xc1 + 100) - si) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="S"){
                        wor.add("S")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            si=5000}}
        if(Math.abs(((xc1 + 100) - ti) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="T"){
                        wor.add("T")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ti=5000}}
        if(Math.abs(((xc1 + 100) - ui) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="U"){
                        wor.add("U")
                    }
                    else{
                        wor= mutableListOf()

                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            ui=5000}}
        if(Math.abs(((xc1 + 100) - vi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="V"){
                        wor.add("V")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            vi=5000}}
        if(Math.abs(((xc1 + 100) - wi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="W"){
                        wor.add("W")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            wi=5000}}
        if(Math.abs(((xc1 + 100) - xi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="X"){
                        wor.add("X")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            xi=5000}}
        if(Math.abs(((xc1 + 100) - yi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="Y"){
                        wor.add("Y")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            yi=5000}}
        if(Math.abs(((xc1 + 100) - zi) - 38) <139){
            if(c1<660) {
                if(wor.size<wordz.size){
                    if(wordz[wor.size].uppercase()=="Z"){
                        wor.add("Z")
                    }
                    else{
                        wor= mutableListOf()
                    }
                }
                if(wor.size==wordz.size){
                    score=score+25000
                    wor= mutableListOf()
                }

            zi=5000}}




























        fun creeper(){

            y0=(2230..3000).random()
            while(Math.abs(y0-xe)<l){
                y0=(2230..3000).random()
            }
            xc=y0
            if(a<40&&a!=0) {a=a+1}
            var rand=(1..10).random()
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
            if(rand in (4..10)){
                k=(0..wo.size-1).random()
                var zz=wo[k]


                if(zz.uppercase()=="A"){
                    ai=(xc+xe)/2
                }
                else{
                    ai=5000
                }
                if(zz.uppercase()=="B"){
                    bi=(xc+xe)/2
                }
                else{
                    bi=5000
                }
                if(zz.uppercase()=="C"){
                    ci=(xc+xe)/2
                }
                else{
                    ci=5000
                }
                if(zz.uppercase()=="D"){
                    di=(xc+xe)/2
                }
                else{
                    di=5000
                }
                if(zz.uppercase()=="E"){
                    ei=(xc+xe)/2
                }
                else{
                    ei=5000
                }
                if(zz.uppercase()=="F"){
                    fi=(xc+xe)/2
                }
                else{
                    fi=5000
                }
                if(zz.uppercase()=="G"){
                    gi=(xc+xe)/2
                }
                else{
                    gi=5000
                }
                if(zz.uppercase()=="H"){
                    hi=(xc+xe)/2
                }
                else{
                    hi=5000
                }
                if(zz.uppercase()=="I"){
                    ii=(xc+xe)/2
                }
                else{
                    ii=5000
                }
                if(zz.uppercase()=="J"){
                    ji=(xc+xe)/2
                }
                else{
                    ji=5000
                }
                if(zz.uppercase()=="K"){
                    ki=(xc+xe)/2
                }
                else{
                    ki=5000
                }
                if(zz.uppercase()=="L"){
                    li=(xc+xe)/2
                }
                else{
                    li=5000
                }
                if(zz.uppercase()=="M"){
                    mi=(xc+xe)/2
                }
                else{
                    mi=5000
                }
                if(zz.uppercase()=="N"){
                    ni=(xc+xe)/2
                }
                else{
                    ni=5000
                }
                if(zz.uppercase()=="O"){
                    oi=(xc+xe)/2
                }
                else{
                    oi=5000
                }
                if(zz.uppercase()=="P"){
                    pi=(xc+xe)/2
                }
                else{
                    pi=5000
                }
                if(zz.uppercase()=="Q"){
                    qi=(xc+xe)/2
                }
                else{
                    qi=5000
                }
                if(zz.uppercase()=="R"){
                    ri=(xc+xe)/2
                }
                else{
                    ri=5000
                }
                if(zz.uppercase()=="S"){
                    si=(xc+xe)/2
                }
                else{
                    si=5000
                }
                if(zz.uppercase()=="T"){
                    ti=(xc+xe)/2
                }
                else{
                    ti=5000
                }
                if(zz.uppercase()=="U"){
                    ui=(xc+xe)/2
                }
                else{
                    ui=5000
                }
                if(zz.uppercase()=="V"){
                    vi=(xc+xe)/2
                }
                else{
                    vi=5000
                }
                if(zz.uppercase()=="W"){
                    wi=(xc+xe)/2
                }
                else{
                    wi=5000
                }
                if(zz.uppercase()=="X"){
                    xi=(xc+xe)/2
                }
                else{
                    xi=5000
                }
                if(zz.uppercase()=="Y"){
                    yi=(xc+xe)/2
                }
                else{
                    yi=5000
                }
                if(zz.uppercase()=="Z"){
                    zi=(xc+xe)/2
                }
                else{
                    zi=5000
                }
































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
        if(a*s<20){
            if(xc<xe1+21+300&&xc>xe1+300-60||xe<xe1+300+21&&xe>xe1+300-60){
                p1=p1-4*a*s
            }
            if(p1>950){
                p1=950
            }
        if((xc<xe1+300-388&&xc>xe1+300-430+e||xe<xe1+300-388&&xe>xe1+300-430+e)){
            p1=p1+8*(a*s)
        }
        if(p1<630){
            p1=630
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


        if(ai<5000){
            ai=ai-s*a}
        if(bi<5000){
            bi=bi-s*a}
        if(ci<5000){
            ci=ci-s*a}
        if(di<5000){
            di=di-s*a}
        if(ei<5000){
            ei=ei-s*a}
        if(fi<5000){
            fi=fi-s*a}
        if(gi<5000){
            gi=gi-s*a}
        if(hi<5000){
            hi=hi-s*a}
        if(ii<5000){
            ii=ii-s*a}
        if(ji<5000){
            ji=ji-s*a}
        if(ki<5000){
            ki=ki-s*a}
        if(li<5000){
            li=li-s*a}
        if(mi<5000){
            mi=mi-s*a}
        if(ni<5000){
            ni=ni-s*a}
        if(oi<5000){
            oi=oi-s*a}
        if(pi<5000){
            pi=pi-s*a}
        if(qi<5000){
            qi=qi-s*a}
        if(ri<5000){
            ri=ri-s*a}
        if(si<5000){
            si=si-s*a}
        if(ti<5000){
            ti=ti-s*a}
        if(ui<5000){
            ui=ui-s*a}
        if(vi<5000){
            vi=vi-s*a}
        if(wi<5000){
            wi=wi-s*a}
        if(xi<5000){
            xi=xi-s*a}
        if(yi<5000){
            yi=yi-s*a}
        if(zi<5000){
            zi=zi-s*a}




















       // if(xco[k]<5000){
           // xco[k]=xco[k]-s*a}

        canvas?.drawBitmap(capybara,null,rect,null)
        canvas?.drawBitmap(pelican,null,pel,null)
        canvas?.drawBitmap(creeper,null,cre,null)
        canvas?.drawBitmap(enderman,null,end,null)
        canvas?.drawBitmap(bomb,null,nuc,null)
        canvas?.drawBitmap(safety,null,safe,null)
        canvas?.drawBitmap(multiple,null,multi,null)
        canvas?.drawBitmap(speed,null,speedd,null)


        canvas?.drawBitmap(A,null,ar,null)
        canvas?.drawBitmap(B,null,br,null)
        canvas?.drawBitmap(C,null,cr,null)
        canvas?.drawBitmap(D,null,dr,null)
        canvas?.drawBitmap(E,null,er,null)
        canvas?.drawBitmap(F,null,fr,null)
        canvas?.drawBitmap(G,null,gr,null)
        canvas?.drawBitmap(H,null,hr,null)
        canvas?.drawBitmap(I,null,ir,null)
        canvas?.drawBitmap(J,null,jr,null)
        canvas?.drawBitmap(K,null,kr,null)
        canvas?.drawBitmap(L,null,lr,null)
        canvas?.drawBitmap(M,null,mr,null)
        canvas?.drawBitmap(N,null,nr,null)
        canvas?.drawBitmap(O,null,orr,null)
        canvas?.drawBitmap(P,null,pr,null)
        canvas?.drawBitmap(Q,null,qr,null)
        canvas?.drawBitmap(Ralpha,null,rr,null)
        canvas?.drawBitmap(S,null,sr,null)
        canvas?.drawBitmap(T,null,tr,null)
        canvas?.drawBitmap(U,null,ur,null)
        canvas?.drawBitmap(V,null,vr,null)
        canvas?.drawBitmap(W,null,wr,null)
        canvas?.drawBitmap(X,null,xr,null)
        canvas?.drawBitmap(Y,null,yr,null)
        canvas?.drawBitmap(Z,null,zr,null)




















        //canvas!!.drawText("${wo[k]}", xco[k],920F,tran)
        //Log.d("tagggggggg","response success ${xco[k]}")
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
        c1=950
        dialog()
    }
    private fun cancel(){
        c1=550
        dialog()
    }


    }

