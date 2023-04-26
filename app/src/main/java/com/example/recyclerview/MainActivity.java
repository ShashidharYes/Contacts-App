package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<card> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycle);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        card obj = new card(R.drawable.ic_launcher_background,"Shashi","943");
        // instead we can  create a new object even within the add()
        arr.add(obj);
        arr.add(new card(R.drawable.ic_launcher_foreground,"Shashidhar","1234"));
        arr.add(new card(R.drawable.ic_launcher_background,"jother","1234"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"pooran","1234"));
        arr.add(new card(R.drawable.ic_launcher_background,"maxwell","1424"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"A","1243"));
        arr.add(new card(R.drawable.ic_launcher_background,"B","1243"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"C","1243"));
        arr.add(new card(R.drawable.ic_launcher_background,"D","43"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"E","243"));
        arr.add(new card(R.drawable.ic_launcher_background,"F","14"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"rothal","143"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"rothal","123"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"rothal","1243"));
        arr.add(new card(R.drawable.ic_launcher_foreground,"rothal","1243"));

        Adapter adapter = new Adapter(this, arr);
        recycler.setAdapter(adapter);


    }
}