package com.example.demau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button studentListBtn = findViewById(R.id.studentList);
        Button classListBtn = findViewById(R.id.classList);

        studentListBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentsScreen.class);
            this.startActivity(intent);
        });
    }
}