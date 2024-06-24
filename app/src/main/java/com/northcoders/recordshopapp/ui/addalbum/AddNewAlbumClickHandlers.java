package com.northcoders.recordshopapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopapp.model.Album;
import com.northcoders.recordshopapp.ui.mainactivity.MainActivity;
import com.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumClickHandlers {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddNewAlbumClickHandlers(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = mainActivityViewModel;
    }

    public void onSubmitButtonClick(View view) {
        if (album.getName().isEmpty() ||
                album.getArtist().isEmpty() ||
                album.getGenre().isEmpty() ||
                album.getDescription().isEmpty() ||
                album.getReleaseYear() < 1900 ||
                album.getStockLevel() < 0) {
            Toast.makeText(context, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);

            Album newAlbum = new Album(
                    album.getId(),
                    album.getName(),
                    album.getDescription(),
                    album.getArtist(),
                    album.getGenre(),
                    album.getReleaseYear(),
                    album.getStockLevel());

            viewModel.addAlbum(newAlbum);

            context.startActivity(intent);
        }
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

} // end of addAlbumClickHandlers class
