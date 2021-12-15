package com.mylib.polkalibrary

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast




class CallingActivity : AppCompatActivity() {
    private lateinit var webvw: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.libview)

        webvw = findViewById<WebView>(R.id.webvw)


        webvw.addJavascriptInterface(  JavaScriptInterface(this), "Android");
        webvw.getSettings().setJavaScriptEnabled(true)





//userMnemonics
        //            override fun onPageFinished(view: WebView, url: String) {
//               // webvw.loadUrl("javascript:init('" + theArgumentYouWantToPass.toString() + "')")
//            }



    }

    fun createMnemonicsandAddress() {
        webvw.loadUrl("file:///android_asset/substrate.html")
    }

    fun importAddress( mnemonics: String?) {
        webvw.loadUrl("file:///android_asset/substrate_custom_address.html")
        webvw.setWebViewClient(object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                webvw.loadUrl("javascript:var userMnemonics = $mnemonics")
            }
        })
    }

    fun sendTransaction() {
        webvw.loadUrl("file:///android_asset/send.html")
        webvw.setWebViewClient(object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                webvw.loadUrl("javascript:var from_address = '5FdpFmkCeM4g8qBfPAkD9ut2suj2WM5GhdT6PBCh5t74qHr1'")
                webvw.loadUrl("javascript:var fromMnemonics = 'already gold shoot famous excess uncle remind flock lucky announce gain blind'")
                webvw.loadUrl("javascript:var amtTobeTransferred = '1000'")
                webvw.loadUrl("javascript:var toAddress = '5FThCokUgAJSgbNSQJbGMioAB13sRtZZJxZd6f5s64Qp2BQs'")
                webvw.loadUrl("javascript:var endPoint = 'https://leadwallet-dot.getblock.io/d3af9e8a-444c-4e8f-be5b-651461334800/'")
                // webvw.loadUrl("javascript:var made instance = 'made instance'")


            }
        })
    }


}