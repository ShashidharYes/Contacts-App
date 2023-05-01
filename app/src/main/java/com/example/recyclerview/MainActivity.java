package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   FloatingActionButton Flo ;
   Button btn;
    Adapter adapter;
    Toolbar toolbar;
    ArrayList<card> arr = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycle);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Flo = findViewById(R.id.floating);

        Flo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_uping);

                EditText edtName = dialog.findViewById(R.id.namefill);
                EditText edtNum = dialog.findViewById(R.id.numfill);
                Button btnSubmit = dialog.findViewById(R.id.submit);

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name ="",num = "";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                            num = edtNum.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please Enter Contact Name",Toast.LENGTH_SHORT);
                        }
                        if(!edtNum.getText().toString().equals("")) {
                            num = edtNum.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please Enter Contact Num",Toast.LENGTH_SHORT);
                        }
                        arr.add(new card(name,num));
                        adapter.notifyItemInserted(arr.size()-1);
                        recycler.scrollToPosition(arr.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }



        });

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






        adapter = new Adapter(this, arr);

        recycler.setAdapter(adapter);

        //setting up of the toolbar
        toolbar = findViewById(R.id.toolbsr);
        //step 1;
        setSupportActionBar(toolbar); //this is when we are using toolbar of appcompat
        //setActionBar();  this is when we are using normal toolbar

        //step 2
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);// this enables the back button to go to previous activity


        }

        toolbar.setTitle("My toolBar");
        toolbar.setSubtitle("this is subtitle");

        //for menu bar of three dots
        //we have to create a menu baar first go to res folder ---> new resource file --> choose menu in that


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId  == R.id.opt_new){
            Toast.makeText(this,"new file Creating",Toast.LENGTH_SHORT);
        }else if(itemId == R.id.opt_save){
            Toast.makeText(this,"Saving the file",Toast.LENGTH_SHORT);
        }else if(itemId == R.id.opt_open){
            Toast.makeText(this,"Opening file",Toast.LENGTH_SHORT);
        } else if (itemId == android.R.id.home) {
            super.onBackPressed(); // to move to previous activity here home represents back
        }
        return super.onOptionsItemSelected(item);
    }
}