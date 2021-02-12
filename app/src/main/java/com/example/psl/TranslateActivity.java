package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TranslateActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://ec2-54-203-215-115.us-west-2.compute.amazonaws.com/psl-engtosign/avatarnew.php");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.getAllowContentAccess();
        settings.getBuiltInZoomControls();
    }
}