package com.example.calculomator.gamemodes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculomator.R;
import com.example.calculomator.model.TypeOperationEnum;


public class SurvivalActivity extends AppCompatActivity {
    private Long premierElement =0L;
    private Long deuxiemeElement=0L;
    private TypeOperationEnum typeOperationEnum = null;
    private TextView textViewCalcul;
    private Long BORNE_HAUTE = 9999L;
    //private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival);

        textViewCalcul = findViewById(R.id.textView_Answer);

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

        /*Button boutonAdd = findViewById(R.id.button_add);
        boutonAdd.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.ADD));

        Button boutonSubstract = findViewById(R.id.button_substract);
        boutonSubstract.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.SUBSTRACT));

        Button boutonDivide = findViewById(R.id.button_divide);
        boutonDivide.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.DIVIDE));

        Button boutonMultiply = findViewById(R.id.button_multiply);
        boutonMultiply.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.MULTIPLY));*/
    }

    private void ajouterNombre(Integer valeur){
        if(typeOperationEnum == null){
            if(10*premierElement+valeur > BORNE_HAUTE){
                Toast.makeText(this,getString(R.string.message_valeur_trop_grande),Toast.LENGTH_LONG).show();
            }else{
                premierElement = 10 * premierElement+valeur;
            }
        }else{
            if(10*deuxiemeElement+valeur > BORNE_HAUTE){
                Toast.makeText(this,getString(R.string.message_valeur_trop_grande),Toast.LENGTH_LONG).show();
            }else{
                deuxiemeElement = 10 * deuxiemeElement+valeur;
            }
        }
        majTextView();
    }

    private void majTextView() {
        String valeurAAfficher = "";
        if(typeOperationEnum == null){
            valeurAAfficher = premierElement.toString();
        }else{
            valeurAAfficher = premierElement + " "+ typeOperationEnum.getSymbol()+" "+ deuxiemeElement;
        }
        textViewCalcul.setText(valeurAAfficher);
    }

}