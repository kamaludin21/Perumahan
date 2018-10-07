package inc.mtwo.perumahan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inc.mtwo.perumahan.LoginActivity;
import inc.mtwo.perumahan.Model.Rumah;
import inc.mtwo.perumahan.R;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{

    private Context context;
    private List<Rumah> rumah;

    public RecyclerViewAdapter2(Context context, List<Rumah> rumah) {
        this.context = context;
        this.rumah = rumah;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Rumah rmh = rumah.get(position);

        holder.blok.setText(rmh.getBlok());
        holder.harga.setText(rmh.getHarga());
        holder.status.setText(rmh.getStatus());
        holder.cicilan1.setText(rmh.getCicilan1());
        holder.cicilan2.setText(rmh.getCicilan2());
        holder.cicilan3.setText(rmh.getCicilan3());
    }



    @Override
    public int getItemCount() {
        return rumah.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.blok)TextView blok;
        @BindView(R.id.harga)TextView harga;
        @BindView(R.id.status)TextView status;
        @BindView(R.id.cicilan1)TextView cicilan1;
        @BindView(R.id.cicilan2)TextView cicilan2;
        @BindView(R.id.cicilan3)TextView cicilan3;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Toast.makeText(context, "Maaf, anda harus login untuk memesan", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);

        }
    }


}
