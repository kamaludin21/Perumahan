package inc.mtwo.perumahan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;

import inc.mtwo.perumahan.Adapter.Adapter;
import inc.mtwo.perumahan.InterfaceApi.RegisterApi;
import inc.mtwo.perumahan.Model.Order;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Order> orders;
    private Adapter adapter;
    private RegisterApi apiInterface;
    ProgressBar progressBar;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        sessionManager = new SessionManager(this);
        sessionManager.cekLogin();

        progressBar = findViewById(R.id.progress_order);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mNama = user.get(sessionManager.NAME);


        fetchOrder(mNama);

    }

    public void fetchOrder (String iduser) {
        apiInterface = ApiClient.getApiClient().create(RegisterApi.class);
        Call<List<Order>> call = apiInterface.order(iduser);

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                progressBar.setVisibility(View.GONE);
                orders = response.body();
                adapter = new Adapter(orders, OrderActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(OrderActivity.this, "Ops, Periksa Koneksi Anda", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
