package com.example.placeholder;

public class FilmModel {
    private String title;
    private String genre;
    private String description;
    private int imageRes;

    public FilmModel(String title, String genre, String description, int imageRes) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getImageRes() {
        return imageRes;
    }
}
