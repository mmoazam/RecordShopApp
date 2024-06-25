package com.northcoders.recordshopapp.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

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
    private ArrayList<Album> albumList;
    MainActivityClickHandler clickHandler;
    private static final String ALBUM_KEY = "album";
    private SearchView searchView;
    AlbumAdapter albumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        clickHandler = new MainActivityClickHandler(this);
        binding.setHandlers(clickHandler);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });

        getAllAlbums();
    }

    private void filterList(String newText) {

        ArrayList<Album> filteredList = new ArrayList<>();

        for (Album album : albumList) {
            if (album.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(album);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            albumAdapter.setFilteredList(filteredList);
        }
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumList = (ArrayList<Album>) albums;
                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        RecyclerView recyclerView = binding.recyclerView;
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