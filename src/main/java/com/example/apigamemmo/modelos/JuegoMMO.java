package com.example.apigamemmo.modelos;

public class JuegoMMO {

    public int id;
    public   String title;
    public String thumnail;
    public String short_description;
    public String game_url;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;
    public String release_date;
    public String profile_url;
    
    public JuegoMMO(
            int id, 
            String title, 
            String thumnail, 
            String short_description, 
            String game_url, 
            String genre,
            String platform,
            String publisher,
            String developer,
            String release_date,
            String profile_url
    ){
        this.id = id;
        this.title = title;
        this. thumnail = thumnail;
        this.short_description = short_description;
        this.game_url = game_url;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.release_date = release_date;
        this.profile_url = profile_url;
    }

    public int getId() {
        return id;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getGame_url() {
        return game_url;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getThumnail() {
        return thumnail;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Objeto molon:" +
                id + " " +
                title + " " +
                short_description + " " +
                developer + " " +
                platform + " " +
                release_date + " ";
    }
}
