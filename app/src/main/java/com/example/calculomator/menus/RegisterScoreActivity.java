package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculomator.R;
import com.example.calculomator.database.LeaderboardBaseHelper;

public class RegisterScoreActivity extends AppCompatActivity {

    LeaderboardBaseHelper db;

    Button add_data;
    EditText add_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_score);

        db = new LeaderboardBaseHelper(this);

        add_data = (Button) findViewById(R.id.button_addData);
        add_name = (EditText) findViewById(R.id.editText_addName);
        add_score = (TextView) findViewById(R.id.textView_addScore);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                int score = Integer.parseInt(add_score.getText().toString());
                if (name.length() > 0 && db.insertData(name, score)) {
                    Toast.makeText(RegisterScoreActivity.this, "Score enregistré !", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    add_score.setText("");
                } else {
                        Toast.makeText(RegisterScoreActivity.this, "Erreur lors de l'enregistrement !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }