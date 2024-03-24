package com.example.frooble;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private String email;
    private String phone;
    private List<Contact> contactList;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.contactList = new ArrayList<>();
    }

    public Contact edit(String newName, String newEmail, String newPhone) {
        if (newName != null) {
            this.name = newName;
        }
        if (newEmail != null) {
            this.email = newEmail;
        }
        if (newPhone != null) {
            this.phone = newPhone;
        }
        return this;
    }

    public void addToList(Contact contact) {
        this.contactList.add(contact);
    }

    public void deleteFromList(Contact contact) {
        this.contactList.remove(contact);
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }
}
