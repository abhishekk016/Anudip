package com.example.moodmusic.model;

public class Song {
    private String title;
    private String artist;
    private String uri;

    public Song() {
    }

    public Song(String title, String artist, String uri) {
        this.title = title;
        this.artist = artist;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
