package com.northcoders.recordshopapp.ui.addalbum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopapp.R;
import com.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.recordshopapp.model.Album;
import com.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

     Album album;
     ActivityAddNewAlbumBinding binding;
     AddNewAlbumClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        handlers = new AddNewAlbumClickHandlers(album, this, viewModel);

        binding.setHandlers(handlers);
        binding.setAlbum(album);
    }



}

