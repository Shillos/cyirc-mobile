package org.cyirc.cyirc;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebChromeClient;

public class MainActivity extends AppCompatActivity {
    private final WebView mywebView;

    public MainActivity(WebView mywebView) {
        this.mywebView = mywebView;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if (savedInstanceState == null) {
            mywebView.loadUrl("https://chat2.cyirc.org");
        }
        mywebView.setWebChromeClient(new WebChromeClient());
    }
    @Override
    protected void onSaveInstanceState(@SuppressWarnings("NullableProblems") Bundle outState )
    {
        super.onSaveInstanceState(outState);
        mywebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        mywebView.restoreState(savedInstanceState);
    }
}
