package com.northcoders.recordshopapp.model;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshopapp.service.AlbumApiService;
import com.northcoders.recordshopapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {

        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public void addMutableLiveData(Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.addAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album added to database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Error adding album to database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateAlbum(Long id, Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album updated in database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Error updating album in database",
                        Toast.LENGTH_SHORT).show();
            }
        }); // end of callback
    } // end of updateBook

    public void deleteAlbum(Long id){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<String> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album deleted from database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Error deleting album from database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

} // end of class AlbumRepository
