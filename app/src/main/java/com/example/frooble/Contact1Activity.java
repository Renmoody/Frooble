package com.example.frooble;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.Toast;
import com.example.frooble.Contact;

import java.util.ArrayList;
import java.util.List;

public class Contact1Activity extends AppCompatActivity {

    String email;
    TextInputEditText inputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputEditText = findViewById(R.id.email1Id); // Initialize inputEditText

        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = inputEditText.getText().toString();
                // Now email contains the text entered by the user
                // You can use it as needed, such as saving to a database, displaying, etc.
                // For example:
                showToast("User input: " + email);
                // Create a new Contact object
                Contact contact = new Contact("New Contact", email, "");
                // Optionally, you can add the new contact to a list if needed
                // contact.addToList(contact);
                // Log the creation of the contact
                //Log.d("Contact1Activity", "Contact created: " + contact.getName() + " - " + contact.getEmail());
               // User user = new User("DeviceUser", null);
                //user.addContact(contact);
               // List<Contact> c = user.getContacts();
               // Email contactEmail = new Email(c.get(0), "Finally working");
                //contactEmail.send();
                Email contactEmail = new Email(contact, "Finally working");
                Log.d("Contact1 Activity", "Contact created: " + contact.getName() + " - " + contact.getEmail());

                contactEmail.send();
                // Optionally, you can add the new contact to a list if needed
                // contact.addToList(contact);
                // Log the creation of the contact
                Log.d("Contact2Activity", "Contact created: " + contact.getName() + " - " + contact.getEmail());
                //Log.d("Contact2Activity", "Contact created: " + contact.getName() + " - " + contact.getEmail());
            }
        });
    }

    public void saveInput(View view) { // Corrected the method signature
        email = inputEditText.getText().toString();
        // Now email contains the text entered by the user
        // You can use it as needed, such as saving to a database, displaying, etc.
        // For example:
        showToast("User input: " + email);
        // Create a new Contact object
        Contact contact = new Contact("New Contact", email, "123");
        User user = new User("DeviceUser", null);
        user.addContact(contact);
        List<Contact> c = user.getContacts();
        Email contactEmail = new Email(c.get(0), "Finally working");
        contactEmail.send();
        // Optionally, you can add the new contact to a list if needed
        // contact.addToList(contact);
        // Log the creation of the contact
        Log.d("Contact2Activity", "Contact created: " + contact.getName() + " - " + contact.getEmail());

    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
