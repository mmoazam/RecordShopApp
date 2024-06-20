package com.northcoders.recordshopapp.model;

public class Album {
    public int id;
    public String name;
    public String description;
    public String artist;
    public String genre;
    public int releaseYear;

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


