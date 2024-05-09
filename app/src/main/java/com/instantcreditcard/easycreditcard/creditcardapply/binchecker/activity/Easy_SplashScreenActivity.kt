package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySplashScreenBinding



class Easy_SplashScreenActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        Handler().postDelayed({ nextActivity() }, 2000)
    }


    private fun nextActivity() {
        startActivity(Intent(this, Easy_MainActivity_1::class.java))
        finish()
    }

    override fun onRestart() {
        super.onRestart()
    }

}