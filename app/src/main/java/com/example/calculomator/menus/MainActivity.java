package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculomator.R;
import com.example.calculomator.menus.GamemodesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonplay = findViewById(R.id.button_play);
        buttonplay.setOnClickListener(view -> openGamemodesActivity());
    }

    private void openGamemodesActivity() {
        Intent intent = new Intent(this, GamemodesActivity.class);
        startActivity(intent);
    }
}