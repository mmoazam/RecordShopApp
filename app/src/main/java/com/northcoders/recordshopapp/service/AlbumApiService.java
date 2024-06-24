package com.northcoders.recordshopapp.service;

import com.northcoders.recordshopapp.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {
    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> addAlbum(@Body Album album);

    @GET("albums/{id}")
    Call<Album> getAlbumById(@Path("id") long id);

    @PUT("albums/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<String> deleteAlbum(@Path("id") long id);
}
