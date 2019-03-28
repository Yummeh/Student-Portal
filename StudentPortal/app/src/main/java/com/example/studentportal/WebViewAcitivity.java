package com.example.studentportal;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewAcitivity extends AppCompatActivity {
	
	private WebView mWebView;
	private String URL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_acitivity);
		mWebView = findViewById(R.id.WebView);
		
		Portal portal =	getIntent().getParcelableExtra(MainActivity.key);
		URL = portal.getmPortalURL();
		mWebView.loadUrl(URL);
		
	}
}
