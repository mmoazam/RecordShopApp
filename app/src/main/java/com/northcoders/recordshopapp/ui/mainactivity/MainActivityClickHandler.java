package com.northcoders.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.northcoders.recordshopapp.R;
import com.northcoders.recordshopapp.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void addAlbumButtonClick(View view) {

        Log.d("MainActivity", "addAlbumButtonClick");

        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);

        context.startActivity(intent);
    }


}
