package com.example.recyclerview;

import androidx.annotation.DrawableRes;

public class card {
    int img =R.drawable.ic_launcher_background ;
    String name,contact;

    card(int img,String name,String contact){
        this.img = img;
        this.name = name;
        this.contact = contact;
    }
    card(String name,String contact){

        this.name = name;
        this.contact = contact;
    }

}
