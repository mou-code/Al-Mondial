package com.worldcup.almondial.ui_.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.worldcup.almondial.R
import com.worldcup.almondial.ui_.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private lateinit var fade : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fade = AnimationUtils.loadAnimation(this, R.anim.fade)

        imgAppLogo.startAnimation(fade)
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            MainActivity.start(this)
        }, 1000)
    }
}