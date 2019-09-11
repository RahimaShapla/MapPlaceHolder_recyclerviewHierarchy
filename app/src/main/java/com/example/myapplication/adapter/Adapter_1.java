package com.example.myapplication.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class Adapter_1 extends RecyclerView.Adapter<Adapter_1.RClass> {
    boolean p = false;
    Listener listener;
    Context context;
    Adapter_2 adapter;

    public Adapter_1(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
        return new RClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RClass holder, int position) {
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new Adapter_2(context);
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
            imageView = itemView.findViewById(R.id.iv_arrow);
            recyclerView = itemView.findViewById(R.id.recycer2);
            recyclerView.setVisibility(View.GONE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!p) {
                        imageView.setBackgroundResource(R.drawable.ic_arrow_drop_up);
                        p = true;
                       // recyclerView.setVisibility(View.VISIBLE);
                        recyclerView.animate()
                                .translationY(0)
                                .alpha(1.0f)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        recyclerView.setVisibility(View.VISIBLE);
                                    }
                                });
                        listener.listenClickEvent(p);
                    } else {
                        imageView.setBackgroundResource(R.drawable.ic_arrow_drop);
                        p = false;
                        listener.listenClickEvent(p);
                       // recyclerView.setVisibility(View.GONE);
                        recyclerView.animate()
                                .translationY(0)
                                .alpha(0.0f)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        recyclerView.setVisibility(View.GONE);
                                    }
                                });
                    }
                }
            });
        }
    }

}
