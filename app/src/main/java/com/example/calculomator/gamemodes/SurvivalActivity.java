package com.example.calculomator.gamemodes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.calculomator.R;
import com.example.calculomator.model.TypeOperationEnum;


public class SurvivalActivity extends AppCompatActivity {
    private Long premierElement =0L;
    private Long deuxiemeElement=0L;
    private TypeOperationEnum typeOperationEnum = null;
    private TextView textViewCalcul;
    private Long BORNE_HAUTE = 9999L;
    private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival);
    }
}