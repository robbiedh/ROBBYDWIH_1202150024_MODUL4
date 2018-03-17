package com.example.bangijan69.robbydwih_1202150024_modul4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    WebView webView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new MyBrowser()); // set webveiw client
        webView.getSettings().setLoadsImagesAutomatically(true); // bisa load image
        webView.getSettings().getJavaScriptEnabled();
        webView.getSettings().setJavaScriptEnabled(true); // java scipt enable
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY); // scroll view aaktif
        editText = (EditText)findViewById(R.id.edit_url); //passing edit text
        button = (Button)findViewById(R.id.button_cari); // parssing button
        progressDialog = new ProgressDialog(this);


        button.setOnClickListener(new View.OnClickListener() { // onclik slitener
            @Override
            public void onClick(View view) {

                webView.loadUrl(editText.getText().toString()); // load url

            }
        });


    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog.show(); // menapilkan progressdialog
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss(); // progress dialog demiis
            super.onPageFinished(view, url);
        }
    }
}
