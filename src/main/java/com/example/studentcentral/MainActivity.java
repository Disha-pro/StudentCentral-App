package com.example.studentcentral;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button button_notice;
    Button button_notes;
    Button button_faculty;
    Button button_delnotes;
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user==null){
            Intent intent4 = new Intent(getApplicationContext(),login.class);
            startActivity(intent4);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent4 = new Intent(getApplicationContext(),login.class);
                startActivity(intent4);
                finish();
            }
        });

        button_notice=(Button) findViewById(R.id.button_notice);
        button_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,upload_notice.class);
                startActivity(intent);
            }
        });

        button_notes=(Button) findViewById(R.id.button_notes);
        button_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MainActivity.this,upload_notes.class);
                startActivity(intent1);
            }
        });

        Button button_faculty;
        button_faculty=(Button) findViewById(R.id.button_faculty);
        button_faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(MainActivity.this,upload_faculty.class);
                startActivity(intent2);
            }
        });

        Button button_delnotes;
        button_delnotes=(Button) findViewById(R.id.button_delnotes);
        button_delnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(MainActivity.this,delete_notes.class);
                startActivity(intent3);
            }
        });

    }
}