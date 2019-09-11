package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class Adapter_2 extends RecyclerView.Adapter<Adapter_2.RClass> {
    boolean p = false;
    Listener listener;
    Context context;
    Adapter_3 adapter;

    public Adapter_2(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_2, parent, false);
        return new RClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RClass holder, int position) {

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new Adapter_3(context);
        //adapter.setClickListener(this);
        holder.recyclerView.setAdapter(adapter);
    }

    public void setListener(Listener listener1) {
        this.listener = listener1;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class RClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        RecyclerView recyclerView;

        public RClass(@NonNull View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.iv_arrow);
            recyclerView = itemView.findViewById(R.id.recycle_2);
           /* imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!p) {
                        imageView.setBackgroundResource(R.drawable.ic_arrow_drop_up);
                        p = true;
                        listener.listenClickEvent(p);
                    } else {
                        imageView.setBackgroundResource(R.drawable.ic_arrow_drop);
                        p = false;
                        listener.listenClickEvent(p);
                    }
                }
            });*/
        }
    }

}
