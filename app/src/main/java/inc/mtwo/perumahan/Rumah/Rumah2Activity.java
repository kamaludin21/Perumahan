package inc.mtwo.perumahan.Rumah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inc.mtwo.perumahan.Adapter.RecyclerViewAdapter2;
import inc.mtwo.perumahan.InterfaceApi.RegisterApi;
import inc.mtwo.perumahan.MenuActivity;
import inc.mtwo.perumahan.Model.Rumah;
import inc.mtwo.perumahan.Model.Value;
import inc.mtwo.perumahan.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rumah2Activity extends AppCompatActivity {

    // Before login

    public static final String URL = "http://lara-lumni.000webhostapp.com/";
    private List<Rumah> rumah = new ArrayList<>();
    private RecyclerViewAdapter2 viewAdapter;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah2);

        ButterKnife.bind(this);

        viewAdapter = new RecyclerViewAdapter2(this, rumah);

        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataRumah();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataRumah();
    }


    private void loadDataRumah() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterApi api = retrofit.create(RegisterApi.class);
        Call<Value> call = api.view();

        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                if (value.equals("1")) {
                    rumah = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter2(Rumah2Activity.this, rumah);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Rumah2Activity.this, MenuActivity.class);
        startActivity(i);
    }


}
