package com.example.frooble;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.frooble.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    String email;

    EditText email1Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<String> list = new ArrayList<String>();
        list.add("main.py");

        ProcessBuilder build = new ProcessBuilder(list);
        Process process = processBuilder.start();
        process.waitFor();
       
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button contact1 = findViewById(R.id.contact1activity);
        email = getString(R.string.Enter_Email);
        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Contact1Activity.class);
                startActivity(intent);
            }
        });
    }


    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }


}
