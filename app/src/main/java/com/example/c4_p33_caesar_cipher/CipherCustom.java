package com.example.c4_p33_caesar_cipher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CipherCustom extends AppCompatActivity {

    TextView input2, result;
    Button cipher, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cipher_custom);

        Intent intent = getIntent();
        String shift_string = intent.getExtras().getString("shift_string");

        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);
        cipher = findViewById(R.id.cipher);
        back = findViewById(R.id.back);

        cipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                   int shift_val = Integer.parseInt(input2.getText().toString());
                   if (shift_val >= 1 && shift_val <= 25) {
                       result.setText(cipher_custom(shift_string, shift_val));
                   }
                   else {
                       Toast.makeText(CipherCustom.this, "Shift value must be between 1 and 25", Toast.LENGTH_SHORT).show();
                   }
               } catch (Exception e){
                   result.setText(cipher_custom(shift_string, 3));
               }
            }
        });

    }
    public void goBack(View view){
        this.finish();
    }

    public static StringBuffer cipher_custom(String str, int shift){
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < str.length(); i ++){
            char ch = (char)(((int)str.charAt(i) + shift - 97) % 26 + 97);
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