package com.ziyata.mengenalbuah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //TODO 2 menginisiasikan widget recycleview
    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    //TODO 3 membuat variabel
    String namaBuah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "stroberry"};

    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    int suara_buah[]= {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // TODO 4 Membuat objek unntuk adapter agar bisa digunakan
        Adapter adapter = new Adapter(MainActivity.this,gambar_buah, suara_buah, namaBuah);

        // TODO 5 mensetting recycleview dan memasukkan adapter ke rycycleview
        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        myRecycleView.setAdapter(adapter);


    }
}
