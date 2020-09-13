package com.example.projecttask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    Activity activity;
    ArrayList name, email;

    MyAdapter(Activity activity, Context context, ArrayList name, ArrayList email){
        this.context = context;
        this.activity= activity;
        this.name = name;
        this.email = email;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewName.setText(String.valueOf(name.get(position)));
        holder.textViewEmail.setText(String.valueOf(email.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("Name", name);
                intent.putExtra("Email", email);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return email.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public TextView textViewEmail;

        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName =itemView.findViewById(R.id.textViewName);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
