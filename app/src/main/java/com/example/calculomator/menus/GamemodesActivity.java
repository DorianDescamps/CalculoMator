package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculomator.R;
import com.example.calculomator.gamemodes.ChronoActivity;
import com.example.calculomator.gamemodes.ClassicActivity;
import com.example.calculomator.gamemodes.InfiniteActivity;

public class GamemodesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemodes);

        Button buttonInfinite = findViewById(R.id.button_infinite);
        buttonInfinite.setOnClickListener((view -> openInfiniteActivity()));

        Button buttonClassic = findViewById(R.id.button_classic);
        buttonClassic.setOnClickListener(view -> openClassicActivity());

        Button buttonChrono = findViewById(R.id.button_chrono);
        buttonChrono.setOnClickListener(view -> openChronoActivity());

    }

    private void openChronoActivity() {
        Intent intent = new Intent(this, ChronoActivity.class);
        startActivity(intent);
    }

    private void openClassicActivity() {
        Intent intent = new Intent(this, ClassicActivity.class);
        startActivity(intent);
    }

    private void openInfiniteActivity() {
        Intent intent = new Intent(this, InfiniteActivity.class);
        startActivity(intent);
    }
}