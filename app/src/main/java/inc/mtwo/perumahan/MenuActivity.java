package inc.mtwo.perumahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import inc.mtwo.perumahan.InfoActivity.InfoActivity;
import inc.mtwo.perumahan.InfoActivity.SimulActivity;
import inc.mtwo.perumahan.Rumah.Rumah2Activity;

public class MenuActivity extends AppCompatActivity {

    @OnClick(R.id.infobtn) void menuInfio() {
        Intent intent = new Intent(MenuActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.login) void regActivity() {
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rumah) void rumahActivity() {
        Intent i = new Intent(MenuActivity.this, Rumah2Activity.class);
        startActivity(i);
    }

    @OnClick(R.id.simulasi) void simulActivity() {
        Intent i = new Intent(MenuActivity.this, SimulActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }
}
