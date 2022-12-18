package com.example.doit.recyclerview;

public class ModelClass {
    private int id;
    private String category;
    private String message;
    private String date;
    private String time;

    public ModelClass(String category, String message, String date, String time) {
        this.category = category;
        this.message = message;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
