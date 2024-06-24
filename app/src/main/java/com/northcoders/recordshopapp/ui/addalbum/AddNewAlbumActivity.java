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
     MainActivityViewModel viewModel;
     AddNewAlbumClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        handlers = new AddNewAlbumClickHandlers(album, this, viewModel);

        binding.setHandlers(handlers);
        binding.setAlbum(album);
    }
}

//package com.northcoders.recordshopapp.ui.addalbum;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import androidx.databinding.DataBindingUtil;
//import androidx.lifecycle.ViewModelProvider;
//import com.northcoders.recordshopapp.R;
//import com.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
//import com.northcoders.recordshopapp.model.Album;
//import com.northcoders.recordshopapp.ui.addalbum.AddNewAlbumClickHandlers;
//import com.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;
//
//public class AddNewAlbumActivity extends AppCompatActivity {
//
//    ActivityAddNewAlbumBinding binding;
//    MainActivityViewModel model;
//    AddNewAlbumClickHandlers clickHandlers;
//    Album album;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_new_album);
//
//        album = new Album();
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);
//        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
//        clickHandlers = new AddNewAlbumClickHandlers(album, this, model);
//        binding.setHandlers(clickHandlers);
//        binding.setAlbum(album);
//
//    }
//}