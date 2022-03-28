package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.calculomator.R;
import com.example.calculomator.database.DataBaseHelper;
import com.example.calculomator.database.LeaderboardBaseHelper;

import java.util.ArrayList;

public class ScoresActivity extends AppCompatActivity {

    LeaderboardBaseHelper db;

    ListView userList;

    ArrayList<String> scores;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        scores = new ArrayList<>();

        db = new LeaderboardBaseHelper(this);
        userList = findViewById(R.id.userList);

        viewData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
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