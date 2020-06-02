package com.eatanapple.musicplayerapp.dto;

public class Song {

    private String title;
    private String artist;
    private String album;
    private String albumArt;

    public Song() {
    }

    public Song(String title, String artist, String album, String albumArt) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumArt = albumArt;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", albumArt='" + albumArt + '\'' +
                '}';
    }
}
