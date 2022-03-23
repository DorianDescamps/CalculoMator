package com.example.calculomator.gamemodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculomator.R;


public class SurvivalActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonDelete;
    private Button buttonEnter;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener((View.OnClickListener) this);

        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener((View.OnClickListener) this);

        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener((View.OnClickListener) this);

        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener((View.OnClickListener) this);

        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener((View.OnClickListener) this);

        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener((View.OnClickListener) this);

        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener((View.OnClickListener) this);

        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener((View.OnClickListener) this);

        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener((View.OnClickListener) this);

        button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener((View.OnClickListener) this);

        buttonDelete = (Button) findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener((View.OnClickListener) this);

        buttonEnter = (Button) findViewById(R.id.button_confirm);
        buttonEnter.setOnClickListener((View.OnClickListener) this);


        keyValues.put(R.id.button_1, "1");
        keyValues.put(R.id.button_2, "2");
        keyValues.put(R.id.button_3, "3");
        keyValues.put(R.id.button_4, "4");
        keyValues.put(R.id.button_5, "5");
        keyValues.put(R.id.button_6, "6");
        keyValues.put(R.id.button_7, "7");
        keyValues.put(R.id.button_8, "8");
        keyValues.put(R.id.button_9, "9");
        keyValues.put(R.id.button_0, "0");
        keyValues.put(R.id.button_confirm, "\n");
    }

    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.button_delete) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival);

        TextView editText = (TextView) findViewById(R.id.textView_Answer);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
    }
}