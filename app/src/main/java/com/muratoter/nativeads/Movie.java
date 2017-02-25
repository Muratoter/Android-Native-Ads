package com.muratoter.nativeads;

/**
 * Created by Murat on 21.02.2017.
 */

public class Movie {
    private String Poster;
    private String Name;
    private String Description;

    public Movie(String poster, String name, String description) {
        Poster = poster;
        Name = name;
        Description = description;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
