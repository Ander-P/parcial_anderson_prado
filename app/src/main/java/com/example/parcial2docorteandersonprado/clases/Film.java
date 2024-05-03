package com.example.parcial2docorteandersonprado.clases;

public class Film {
    private String name;
    private String duration;
    private String image;

    private String status;

    private String gender;

    private String city;
    private String planet;

    public Film(String name, String duration, String image, String status, String gender, String city, String planet) {
        this.name = name;
        this.duration = duration;
        this.image = image;
        this.status = status;
        this.gender = gender;
        this.city = city;
        this.planet = planet;
    }

    //public Film(String name, String duration, String image) {
        //this.name = name;
        //this.duration = duration;
       // this.image = image;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

