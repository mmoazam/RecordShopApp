package com.northcoders.recordshopapp.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopapp.model.Album;
import com.northcoders.recordshopapp.ui.mainactivity.MainActivity;
import com.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {

    private Album album;
    private MainActivityViewModel viewModel;
    private long id;
    private Context context;

    public UpdateAlbumClickHandlers(MainActivityViewModel viewModel, Album album, Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void onSubmitButtonClicked(View view) {
        Album newAlbum = new Album(
                album.getId(),
                album.getName(),
                album.getDescription(),
                album.getArtist(),
                album.getGenre(),
                album.getReleaseYear(),
                album.getStockLevel()
        );

        if (newAlbum.getName().isEmpty() ||
                newAlbum.getDescription().isEmpty() ||
                newAlbum.getArtist().isEmpty() ||
                newAlbum.getGenre().isEmpty()) {
            Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT).show();
        } else {
            id = album.getId();
            viewModel.updateAlbum(id, newAlbum);
            context.startActivity(new Intent(context, MainActivity.class));
        }
    } // end onSubmitButtonClicked

    public void onDeleteButtonClicked(View view) {
        id = album.getId();
        viewModel.deleteAlbum(id);
        context.startActivity(new Intent(context, MainActivity.class));
    } // end onDeleteButtonClicked

    public void onBackButtonClicked(View view) {
        context.startActivity(new Intent(context, MainActivity.class));
    } // end onBackButtonClicked

} // end UpdateAlbumClickHandlers
