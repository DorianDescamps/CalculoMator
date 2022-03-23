package com.example.calculomator.gamemodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculomator.R;

import java.util.Random;

public class ChronoActivity extends AppCompatActivity {

    private Long answer = 0L;
    private Integer number1 = 0;
    private Integer number2 = 0;
    private String question = "";
    private TextView textViewAnswer;
    private TextView textViewQuestion;
    //private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival);

        textViewAnswer = findViewById(R.id.textView_Answer);
        textViewQuestion = findViewById(R.id.textView_Question);

        //calculService = new CalculService(new CalculDao(new ComputeBaseHelper(this)));

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
        button_confirm.setOnClickListener(view -> generateNumber());

        generateNumber();

    }

    private void ajouterNombre(Integer valeur){
        Long maxValue = 99999999L;
        if (10 * answer + valeur > maxValue){
            Toast.makeText(this, getString(R.string.message_valeur_trop_grande), Toast.LENGTH_LONG).show();
        }else{
            answer = 10 * answer+valeur;
        }
        majTextView();
    }

    private void generateNumber()
    {
        number1 = new Random().nextInt(100);
        number2 = new Random().nextInt(100);
        int result = number1 + number2;
        question = number1.toString() + "+" + number2.toString();
        textViewQuestion.setText(question.toString());
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