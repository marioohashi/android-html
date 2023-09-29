package com.example.webapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import android.annotation.SuppressLint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView: WebView = findViewById(R.id.webView)

        // Configurar as configurações da WebView
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true

        var jsInterface: JavaScriptInterface = JavaScriptInterface(this);
        webView.addJavascriptInterface(jsInterface, "Android");

        // Carregar um site externo (por exemplo, o site da up)
        webView.loadUrl("file:///android_asset/index.html")

    }

    class JavaScriptInterface(private val context: Context) {
        @JavascriptInterface
        fun showToast(message: String?) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }





}