package inc.mtwo.perumahan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import inc.mtwo.perumahan.Model.Order;
import inc.mtwo.perumahan.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Order> order;
    private Context context;

    public Adapter(List<Order> order, Context context) {
        this.order = order;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.blok.setText(order.get(position).getBlok());
        holder.harga.setText(order.get(position).getHarga());

    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView blok, harga;

        public MyViewHolder(View itemView) {
            super(itemView);
            blok = itemView.findViewById(R.id.blok);
            harga = itemView.findViewById(R.id.harga);
        }
    }
}
