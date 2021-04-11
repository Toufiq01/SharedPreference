package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("my preference", MODE_PRIVATE);
        String editValue = sp.getString("name", "No value Here");
        textView.setText(editValue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("my preference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", val);
                editor.apply();
                textView.setText(val);
            }
        });

    }
}