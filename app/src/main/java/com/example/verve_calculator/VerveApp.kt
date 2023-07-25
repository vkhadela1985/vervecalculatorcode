package com.example.verve_calculator

import android.app.Application
import android.util.Log
import net.pubnative.lite.sdk.HyBid

class VerveApp: Application() {
    override fun onCreate() {
        super.onCreate()
        HyBid.initialize("",this, HyBid.InitialisationListener {
            if(it){
                Log.d("SDK STATUS", "initialised")
            }else {
                Log.e("SDK STATUS", "Not initialised")
            }
        })
    }
}