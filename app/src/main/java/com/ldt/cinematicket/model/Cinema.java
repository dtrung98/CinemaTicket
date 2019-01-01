package com.ldt.cinematicket.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cinema {
    @SerializedName("Address")
    private String Address;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Hotline")
    private String Hotline;
    @SerializedName("ID")
    private int ID;
    @SerializedName("ImageUrl")
    private String ImageUrl;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Movies")
    private ArrayList<Integer> Movies;
    @SerializedName("ShowTimes")
    private ArrayList<Integer> ShowTimes;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setHotline(String Hotline) {
        this.Hotline = Hotline;
    }

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Integer> getMovies() {
        return Movies;
    }

    public void setMovies(ArrayList<Integer> Movies) {
        this.Movies = Movies;
    }

    public ArrayList<Integer> getShowTimes() {
        return ShowTimes;
    }

    public void setShowTimes(ArrayList<Integer> ShowTimes) {
        this.ShowTimes = ShowTimes;
    }
}
