package com.northcoders.recordshopapp.service;

import com.northcoders.recordshopapp.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("albums")
    Call<List<Album>> getAlbums();
}
