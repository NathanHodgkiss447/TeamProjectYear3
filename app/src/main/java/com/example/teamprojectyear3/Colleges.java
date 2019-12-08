package com.example.teamprojectyear3;



public class Colleges {
    private String name;
    private String male;
    private String female;

    public Colleges(String name, String male, String female) {
        this.name = name;
        this.male = male;
        this.female = female;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }
}
