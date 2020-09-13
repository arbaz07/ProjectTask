package com.example.projecttask;

public class ListItem {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ListItem(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
