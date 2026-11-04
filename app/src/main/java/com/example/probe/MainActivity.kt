package com.example.probe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web = WebView(this)
        setContentView(web)
        web.setBackgroundColor(Color.parseColor("#0B0F14"))
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.settings.loadWithOverviewMode = true
        web.settings.useWideViewPort = true
        web.webChromeClient = WebChromeClient()
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }
        }
        web.loadUrl(START_URL)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        web.saveState(outState)
    }
    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else finish()
    }

    companion object {
        const val START_URL = "file:///android_asset/www/index.html"
        const val APP_HOST = ""
    }
}
