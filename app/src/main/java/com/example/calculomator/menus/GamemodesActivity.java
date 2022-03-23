package com.example.calculomator.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculomator.R;
import com.example.calculomator.gamemodes.ChronoActivity;
import com.example.calculomator.gamemodes.ClassicActivity;
import com.example.calculomator.gamemodes.InfiniteActivity;
import com.example.calculomator.gamemodes.SurvivalActivity;

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

        Button buttonSurvival = findViewById(R.id.button_survival);
        buttonSurvival.setOnClickListener(view -> openSurvivalActivity());

        Button buttonScores = findViewById(R.id.button_scores);
        buttonScores.setOnClickListener(view -> openScoresActivity());
    }

    private void openScoresActivity() {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    private void openSurvivalActivity() {
        Intent intent = new Intent(this, SurvivalActivity.class);
        startActivity(intent);
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