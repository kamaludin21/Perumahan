package inc.mtwo.perumahan.InfoActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import inc.mtwo.perumahan.R;

public class InfoActivity extends AppCompatActivity {

    private WebView syarat;
    private Context context;

    public static final String URL = "http://lara-lumni.000webhostapp.com/webview/info.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        syarat = (WebView) findViewById(R.id.syarat);
        syarat.setWebViewClient(new WebViewClient());

        WebSettings webSetting = syarat.getSettings();
        webSetting.setJavaScriptEnabled(true);

        syarat.loadUrl(URL);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InfoActivity.this, GambarActivity.class);
                startActivity(i);
            }
        });
    }
}
