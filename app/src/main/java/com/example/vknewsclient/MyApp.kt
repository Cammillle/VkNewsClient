package com.example.vknewsclient

import android.app.Application
import com.vk.id.VKID

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        //VK.initialize(this)
        VKID.init(this)
    }
}