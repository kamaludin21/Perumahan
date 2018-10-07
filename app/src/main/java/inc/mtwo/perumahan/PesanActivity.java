package inc.mtwo.perumahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PesanActivity extends AppCompatActivity {

    private TextView getBlok, getHarga, nama;
    private Button belirumah;
    private ProgressBar loading;
    private static String URL_BUY = "http://lara-lumni.000webhostapp.com/beli.php";

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        sessionManager = new SessionManager(this);
        sessionManager.cekLogin();

        belirumah = findViewById(R.id.belirumah);
        loading = findViewById(R.id.loadingpesan);

        getBlok = findViewById(R.id.getBlok);
        getHarga = findViewById(R.id.getHarga);
        nama = findViewById(R.id.namasesi);

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mNama = user.get(sessionManager.NAME);

        Intent intent = getIntent();
        String tfblok = intent.getStringExtra("blok");
        String tfharga = intent.getStringExtra("harga");

        getBlok.setText(tfblok);
        getHarga.setText(tfharga);
        nama.setText(mNama);

        belirumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesanRumah();
            }
        });

    }

    private void pesanRumah() {

        loading.setVisibility(View.VISIBLE);
        belirumah.setVisibility(View.GONE);

        sessionManager = new SessionManager(this);
        sessionManager.cekLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mNama = user.get(sessionManager.NAME);

        Intent intent = getIntent();
        String tfblok = intent.getStringExtra("blok");


        final String iduser = mNama;
        final String blok = tfblok;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_BUY,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(PesanActivity.this, "Pembelian berhasil, Silahkan menunggu konfirmasi dari admin kami",
                                        Toast.LENGTH_LONG).show();
                                Intent i = new Intent(PesanActivity.this, HomeActivity.class);
                                startActivity(i);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(PesanActivity.this, "Ups, Ada yang salah ", Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            belirumah.setVisibility(View.VISIBLE);
                        }
                    }
                },

                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PesanActivity.this,"Periksa Koneksi Anda", Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);
                        belirumah.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("iduser", iduser);
                params.put("blok", blok);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
