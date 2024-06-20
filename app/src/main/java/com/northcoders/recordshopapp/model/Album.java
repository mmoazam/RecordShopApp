package com.northcoders.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshopapp.BR;

public class Album extends BaseObservable {
    private int id;
    private String name;
    private String description;
    private String artist;
    private String genre;
    private int releaseYear;

    @Bindable
    public int getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    public Album() {
    }

    public Album(int id, String name, String description, String artist, String genre, int releaseYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}


