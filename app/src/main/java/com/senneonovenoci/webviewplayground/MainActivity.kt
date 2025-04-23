package com.senneonovenoci.webviewplayground

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        // Set a basic WebViewClient to handle navigation
        webView.webViewClient = WebViewClient()

        // Capture and log console messages from the WebView
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                consoleMessage?.let {
                    Log.d(TAG, "[${it.messageLevel()}] ${it.message()} -- From line ${it.lineNumber()} of ${it.sourceId()}")
                }
                return true
            }
        }

        // Enable JavaScript and DOM storage
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        // Load the web page you want to test
        webView.loadUrl("https://www.example.com")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        private const val TAG = "WebViewConsole"
    }
}