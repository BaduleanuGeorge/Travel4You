package com.example.travel4you;

public class Note {

    private String title;
    private String description;
    private long createdTime;

    Note(){}

    Note(String title, String description, long createdTime){
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
