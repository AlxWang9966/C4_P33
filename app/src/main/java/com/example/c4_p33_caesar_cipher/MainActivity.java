package com.example.c4_p33_caesar_cipher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // this is the activity with fixed shift
    TextView input, result;
    Button cipher, custom;
    // custom is the one to the second activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        cipher = findViewById(R.id.cipher);
        custom = findViewById(R.id.custom);

        cipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(cipher(input.getText().toString()));
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CipherCustom.class);
                intent.putExtra("shift_string", input.getText().toString());
                startActivity(intent);
            }
        });
    }

    public static StringBuffer cipher(String input){
        // shift is fixed in this activity, shift = 3
        int shift = 3;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < input.length(); i ++){
            char ch = (char)(((int)input.charAt(i) + shift - 97) % 26 + 97);
            result.append(ch);
        }

        return result;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        outState.putString("result", result.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        result.setText(savedInstanceState.getString("result"));
    }
}