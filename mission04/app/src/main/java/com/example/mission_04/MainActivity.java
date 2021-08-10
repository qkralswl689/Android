package com.example.mission_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textLenght;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editTextTextPersonName);
        textLenght = findViewById(R.id.textView);

        // EditText리스너 (입력시 반응)
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence,  int start, int before, int count) {

            }

            // 글자수 TextView에 보여주기
            @Override
            public void afterTextChanged(Editable editable) {
                textLenght.setText(editable.length() + " / 80 바이트");
            }
        });
    }
}