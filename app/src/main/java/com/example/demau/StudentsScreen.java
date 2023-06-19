package com.example.demau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.demau.repo.database.StudentDB;
import com.example.demau.repo.models.Student;

public class StudentsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_list);

        ListView lv = findViewById(R.id.studentListView);

        Button addBtn = findViewById(R.id.addStudent);
        addBtn.setOnClickListener(view -> {
            StudentDB db= new StudentDB(StudentsScreen.this);
//            db.deleteAllStudent();

            EditText name = findViewById(R.id.name);
            EditText dob = findViewById(R.id.dob);
            EditText home = findViewById(R.id.homeTown);
            EditText year = findViewById(R.id.year);


            db.addStudent(new Student(name.getText().toString()
                    , dob.getText().toString(),
                    home.getText().toString(),
                    Integer.parseInt(year.getText().toString())
                    ));
            ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_view_layout, db.getAllStudent());
            lv.setAdapter(adapter);

        });
    }
}