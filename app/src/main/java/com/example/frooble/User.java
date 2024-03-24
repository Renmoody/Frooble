package com.example.frooble;

import java.util.ArrayList;
import java.util.List;
public class User {

    private String username;
    private List<Contact> contacts;

    public User(String user, List<Contact> con) {
        this.username = user;
        if (con == null) {
            con = new ArrayList<>();
        } else {
            this.contacts = con;
        }
    }

    public void addContact (Contact con){
        this.contacts.add(con);
    }

    public String getUser (){
        return this.username;
    }

    public List<Contact> getContacts(){
        return contacts;
    }
}

