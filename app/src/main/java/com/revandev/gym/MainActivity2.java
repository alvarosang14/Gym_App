package com.revandev.gym;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText text1;
    private EditText text2;
    private TextView text_inser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Nos conecta con la parte grafica
        setContentView(R.layout.activity_main2);

        text1 = (EditText)findViewById(R.id.text_edit_1);
        text2 = (EditText)findViewById(R.id.text_edit_2);
        text_inser = (TextView) findViewById(R.id.resultt);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Con view creamos el componente
    public void PR(View view) {
        try {
            String value1 = text1.getText().toString();
            String value2 = text2.getText().toString();
            int num = Integer.parseInt(value1) * (1 + (Integer.parseInt(value2) / 30));
            text_inser.setText(String.valueOf(num));
        } catch (NumberFormatException e) {
            text_inser.setText("Error: Por favor, ingrese números válidos.");
        }
    }
}