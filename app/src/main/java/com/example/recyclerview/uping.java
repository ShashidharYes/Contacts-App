package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class uping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uping);

        EditText name = findViewById(R.id.namefill);
        EditText Phone = findViewById(R.id.numfill);


        Button btn ;
        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent second = new Intent(uping.this,MainActivity.class);
                second.putExtra("name" ,name.getText().toString());
                second.putExtra("Phone",Phone.getText().toString());
                finish();
            }
        });









    }
}