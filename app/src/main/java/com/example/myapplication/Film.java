package com.example.myapplication;

public class Film {
    private String name;
    private String director;
    private String duration;
    private String releaseDate;
    private String category;
    private String nation;
    private String id;
    private String description;


    public Film(String id, String name, String director, String duration, String releaseDate, String category, String nation) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.category = category;
        this.nation = nation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Film{" +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", category='" + category + '\'' +
                ", nation='" + nation + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
