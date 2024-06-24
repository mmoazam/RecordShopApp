package com.northcoders.recordshopapp.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshopapp.R;
import com.northcoders.recordshopapp.databinding.ActivityMainBinding;
import com.northcoders.recordshopapp.model.Album;
import com.northcoders.recordshopapp.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private ArrayList<Album> albumList;
    MainActivityClickHandler clickHandler;
    private static final String ALBUM_KEY = "album";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new MainActivityClickHandler(this);

        getAllAlbums();
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>(){
            @Override
            public void onChanged(List<Album> albums) {
                albumList = (ArrayList<Album>) albums;
                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, this, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(this, UpdateAlbumActivity.class);
        intent.putExtra(ALBUM_KEY, albumList.get(position));
        startActivity(intent);
    }
}