package com.ziyata.mengenalbuah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    //TODO 1 Membuat variable untuk menampung data pada saat object dibuat dan membawa data menggunakan adapter
    Context context;
    int[] gambarBuah,suaraBuah;
    String[] namaBuah;

    public Adapter(Context context, int[] gambarBuah, int[] suaraBuah, String[] namaBuah) {
        this.context = context;
        this.gambarBuah = gambarBuah;
        this.suaraBuah = suaraBuah;
        this.namaBuah = namaBuah;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // untuk menentukan tampilan dari adapter
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_buah, viewGroup, false );
        // Mengembalikan nilai untuk memberi tahu recycle view bahwa kita menggunakan view yang sudah kita buat
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder viewHolder, final int i) {
        // Mengubah nama buag dengan data nama buah yang kita miliki
        viewHolder.txtNamaBuah.setText(namaBuah[i]);
        // Menampilkan gambar dengan data yang kita miliki menggunakan library Glide
        Glide.with(context).load(gambarBuah[i]).into(viewHolder.imgNamaBuah);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailBuahActivity.class);
                pindah.putExtra("nb", namaBuah[i]);
                pindah.putExtra("gb", gambarBuah[i]);
                pindah.putExtra("ab", suaraBuah[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarBuah.length;
    }
 public class viewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaBuah;
        ImageView imgNamaBuah;
        public viewHolder(@NonNull View itemView){
            super(itemView);
            txtNamaBuah = itemView.findViewById(R.id.txtNamaBuah);
            imgNamaBuah = itemView.findViewById(R.id.imgBuah);
        }
 }
}
