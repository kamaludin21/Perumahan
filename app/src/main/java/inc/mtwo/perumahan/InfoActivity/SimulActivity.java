package inc.mtwo.perumahan.InfoActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import inc.mtwo.perumahan.R;

public class SimulActivity extends AppCompatActivity {

    private WebView simul;
    private Context context;

    public static final String URL = "http://lara-lumni.000webhostapp.com/webview/alert.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simul);

        simul = (WebView) findViewById(R.id.simul);
        simul.setWebViewClient(new WebViewClient());

        WebSettings webSetting = simul.getSettings();
        webSetting.setJavaScriptEnabled(true);

        simul.loadUrl(URL);

    }
}
