package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculomator.R;
import com.example.calculomator.database.LeaderboardBaseHelper;

import java.util.ArrayList;

public class RegisterScoreActivity extends AppCompatActivity {

    LeaderboardBaseHelper db;

    ListView userList;

    ArrayList<String> scores;
    ArrayAdapter<String> adapter;

    Button add_data;
    EditText add_name;
    TextView add_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_score);

        scores = new ArrayList<>();

        db = new LeaderboardBaseHelper(this);

        userList = findViewById(R.id.userList);

        add_data = (Button) findViewById(R.id.button_addData);
        add_name = (EditText) findViewById(R.id.editText_addName);
        add_score = (TextView) findViewById(R.id.textView_addScore);

        String score = getIntent().getStringExtra("score");

        add_score.setText(score);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                int score = Integer.parseInt(add_score.getText().toString());
                if (name.length() > 0 && db.insertData(name, score)) {
                    Toast.makeText(RegisterScoreActivity.this, "Score enregistré !", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    add_score.setText("");
                    viewData();
//                    returnToMenu();
                } else {
                        Toast.makeText(RegisterScoreActivity.this, "Erreur lors de l'enregistrement !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    private void returnToMenu() {
        Intent intent = new Intent(this, GamemodesActivity.class);
        startActivity(intent);
    }

    private void viewData() {
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Aucune donnée", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                scores.add(cursor.getString(1) + " : " + cursor.getString(2));
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scores);
            userList.setAdapter(adapter);
        }
    }

    }