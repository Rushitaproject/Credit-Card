package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.instantcreditcard.easycreditcard.creditcardapply.binchecker.databinding.ActivitySubmitFromBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class Easy_SubmitFromActivity_29 : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySubmitFromBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySubmitFromBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewAction()
    }

    private fun initViewAction() {
        mBinding.ivBackBtn.setOnClickListener(this)
        mBinding.konfettiView.start(
            Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )
        )
    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.ivBackBtn->{
                onBackPressed()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onBackPressed() {
        nextActivity()
    }

    private fun nextActivity() {
        val resultInt = Intent()
        resultInt.putExtra("Added", "yesAdded")
        setResult(RESULT_OK, resultInt)
        finish()
    }


}