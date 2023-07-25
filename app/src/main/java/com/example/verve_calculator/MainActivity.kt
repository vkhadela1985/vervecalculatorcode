package com.example.verve_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.pubnative.lite.sdk.views.HyBidBannerAdView
import net.pubnative.lite.sdk.views.PNAdView


class MainActivity : AppCompatActivity() {
    private var total=0
    var current = 0
    private var currentOperator=""

    private val myAdListener = object: PNAdView.Listener {
        override fun onAdLoaded() {
            Log.d("AdListener", "Ad Loaded")
        }

        override fun onAdLoadFailed(error: Throwable?) {
            Log.d("AdListener", "Ad Failed")
        }

        override fun onAdImpression() {
            Log.d("AdListener", "Ad Impression")
        }

        override fun onAdClick() {
            Log.d("AdListener", "Ad Clicked")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt1).setOnClickListener(listener)
        findViewById<Button>(R.id.bt2).setOnClickListener(listener)
        findViewById<Button>(R.id.bt3).setOnClickListener(listener)
        findViewById<Button>(R.id.bt4).setOnClickListener(listener)
        findViewById<Button>(R.id.bt5).setOnClickListener(listener)
        findViewById<Button>(R.id.bt6).setOnClickListener(listener)
        findViewById<Button>(R.id.subtract).setOnClickListener(listener)
        findViewById<Button>(R.id.add).setOnClickListener(listener)
        findViewById<HyBidBannerAdView>(R.id.hybid_banner).load("my_banner", myAdListener)
    }

    private val listener = View.OnClickListener { view ->
        when(view.id) {
            R.id.equals -> {
                Log.d("Bt1", "Perform calculation")

            }
            R.id.subtract -> {
                currentOperator = "-"
            }
            R.id.add -> {
                currentOperator = "+"
            }
            else -> {
                var b = findViewById<Button>(view.id)
                var display = findViewById<TextView>(R.id.textView)
                if(total == 0 ){
                    total = Integer.parseInt(b.text.toString())
                    display.append(b.text.toString())
                } else {
                    when(currentOperator) {
                        "-" -> {
                            total = total.minus(Integer.parseInt(b.text.toString()))
                        }
                        "+" -> {
                            total = total.plus(Integer.parseInt(b.text.toString()))
                        }
                    }
                    display.text = total.toString()
                }

            }
        }
    }
}