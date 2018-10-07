package inc.mtwo.perumahan.InfoActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import inc.mtwo.perumahan.R;

public class GambarActivity extends AppCompatActivity {

    private WebView webView;
    public static final String URL = "http://lara-lumni.000webhostapp.com/webview/alert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URL);

    }

}