package inc.mtwo.perumahan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inc.mtwo.perumahan.Model.Rumah;
import inc.mtwo.perumahan.PesanActivity;
import inc.mtwo.perumahan.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Rumah> rumah;

    public RecyclerViewAdapter (Context context, List<Rumah> rumah) {
        this.context = context;
        this.rumah = rumah;
    }


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
    public int getItemCount()  {
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
        public void onClick (View view) {

            String getBlok = blok.getText().toString();
            String getHarga = harga.getText().toString();

            Intent i = new Intent(context, PesanActivity.class);
            i.putExtra("blok", getBlok);
            i.putExtra("harga", getHarga);

            context.startActivity(i);

        }

    }

}
