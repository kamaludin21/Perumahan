package inc.mtwo.perumahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inc.mtwo.perumahan.InfoActivity.InfoActivity;
import inc.mtwo.perumahan.Rumah.RumahActivity;

public class HomeActivity extends AppCompatActivity {

    @OnClick(R.id.info) void infoActivity() {
        Intent i = new Intent(HomeActivity.this, InfoActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.profil) void profilActivity() {
        Intent intent = new Intent(HomeActivity.this, ProfilActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rumah) void rumahActivity() {
        Intent i = new Intent(HomeActivity.this, RumahActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.order_btn) void pesananActivity() {
        Intent i = new Intent(HomeActivity.this, OrderActivity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

}
