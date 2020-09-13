package com.example.projecttask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    MyDatabaseHelper myDatabaseHelper;
    ArrayList<String> name, email;

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myDatabaseHelper = new MyDatabaseHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();

        diaplayData();

        myAdapter = new MyAdapter(MainActivity.this,this, name, email);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void diaplayData(){
        Cursor cursor = myDatabaseHelper.readAllData();
        if(cursor.getCount() == 1){
            Toast.makeText(this,"NO DATA ",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
            }
        }
    }
}
