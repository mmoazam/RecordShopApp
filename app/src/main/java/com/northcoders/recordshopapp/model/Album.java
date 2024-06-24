package com.northcoders.recordshopapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.northcoders.recordshopapp.BR;

public class Album extends BaseObservable implements Parcelable {
    private int id;
    private String name;
    private String description;
    private String artist;
    private String genre;
    private int releaseYear;
    private int stockLevel;

    protected Album(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        artist = in.readString();
        genre = in.readString();
        releaseYear = in.readInt();
        stockLevel = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public int getStockLevel() {
        return stockLevel;
    }

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

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
        notifyPropertyChanged(BR.stockLevel);
    }



    public Album() {
    }

    public Album(int id, String name, String description, String artist, String genre, int releaseYear, int stockLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stockLevel = stockLevel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(artist);
        dest.writeString(genre);
        dest.writeInt(releaseYear);
        dest.writeInt(stockLevel);
    }


}


