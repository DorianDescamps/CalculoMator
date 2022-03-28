package com.example.calculomator.gamemodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculomator.R;
import com.example.calculomator.menus.GamemodesActivity;
import com.example.calculomator.menus.RegisterScoreActivity;

import java.util.Random;

public class ClassicActivity extends AppCompatActivity {
    private Integer errors = 3;
    private Long answer = 0L;
    private Long result = 0L;
    private TextView textViewAnswer;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewErrors;
    private TextView textViewCountdown;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 10000;
    private boolean timerRunning;
    private Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        textViewAnswer = findViewById(R.id.textView_Answer);
        textViewQuestion = findViewById(R.id.textView_Question);
        textViewScore = findViewById(R.id.textView_Score);
        textViewErrors = findViewById(R.id.textView_Errors);
        textViewCountdown = findViewById(R.id.textView_Countdown);

        textViewAnswer.setText(getString(R.string.result));
        textViewScore.setText(getString(R.string.view_score, score));
        textViewErrors.setText(getString(R.string.view_errors, errors));

        Button bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> ajouterNombre(1));

        Button bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> ajouterNombre(2));

        Button bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> ajouterNombre(3));

        Button bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> ajouterNombre(4));

        Button bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> ajouterNombre(5));

        Button bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> ajouterNombre(6));

        Button bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> ajouterNombre(7));

        Button bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> ajouterNombre(8));

        Button bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> ajouterNombre(9));

        Button bouton0 = findViewById(R.id.button_0);
        bouton0.setOnClickListener(view -> ajouterNombre(0));

        Button button_minus = findViewById(R.id.button_minus);
        button_minus.setOnClickListener(view -> minusNumber());

        Button button_delete = findViewById(R.id.button_delete);
        button_delete.setOnClickListener(view -> videTextViewCalcul());

        Button button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(view -> verifyResult());

        generateNumber();
        timerRunning = false;
        switchCountdown();

    }

    public void switchCountdown()
    {
        if (timerRunning)
        {
            stopTimer();
        }
        else
        {
            startTimer();
        }
    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), getString(R.string.time), Toast.LENGTH_LONG).show();
                endGame();
            }
        }.start();

        timerRunning = true;
    }

    public void stopTimer()
    {
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer()
    {
        int secs = (int) timeLeftInMilliseconds / 1000;

        String timeLeftText = "";

        timeLeftText += secs;

        textViewCountdown.setText(timeLeftText);
    }

    private void ajouterNombre(Integer valeur){
        long maxValue = 99999999L;
        if (10L * answer + valeur > maxValue){
            Toast.makeText(this, getString(R.string.message_valeur_trop_grande), Toast.LENGTH_LONG).show();
        }else{
            answer = 10 * answer+valeur;
        }
        majTextView();
    }

    private void generateNumber()
    {
        int number1 = new Random().nextInt(100);
        int number2 = new Random().nextInt(100);
        result = (long) number1 + number2;
        String question = Integer.toString(number1) + "+" + Integer.toString(number2);
        textViewQuestion.setText(question);
    }

    private void verifyResult()
    {
        if (answer.equals(result))
        {
            Toast.makeText(this, getString(R.string.valeur_correcte), Toast.LENGTH_LONG).show();
            generateNumber();
            videTextViewCalcul();
            textViewAnswer.setText(getString(R.string.result));
            score++;
            stopTimer();
            timeLeftInMilliseconds = 10000;
            startTimer();
            textViewScore.setText(getString(R.string.view_score, score));
        }
        else
        {
            Toast.makeText(this, getString(R.string.valeur_incorrecte), Toast.LENGTH_LONG).show();
            generateNumber();
            videTextViewCalcul();
            textViewAnswer.setText(getString(R.string.result));
            errors--;
            textViewErrors.setText(getString(R.string.view_errors, errors));
            if (errors == 0)
            {
                endGame();
                stopTimer();
            }
        }
    }

    private void endGame() {
        Intent intent = new Intent(this, RegisterScoreActivity.class);
        intent.putExtra("score", score.toString());
        startActivity(intent);
    }

    private void minusNumber()
    {
        answer *= -1;
        majTextView();
    }

    private void majTextView() {
        String valeurAAfficher = "";
        valeurAAfficher = answer.toString();
        textViewAnswer.setText(valeurAAfficher);
    }

    private boolean videTextViewCalcul() {
        textViewAnswer.setText("");
        answer = 0L;
        return true;
    }
}