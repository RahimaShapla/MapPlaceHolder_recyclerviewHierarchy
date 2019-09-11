package com.example.myapplication.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements Listener{
    Adapter_1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re);

        RecyclerView recyclerView = findViewById(R.id.recycler_main_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_1(this);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void listenClickEvent(boolean open) {

    }
}
