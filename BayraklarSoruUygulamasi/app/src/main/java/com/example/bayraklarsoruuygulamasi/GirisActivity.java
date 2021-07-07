package com.example.bayraklarsoruuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GirisActivity extends AppCompatActivity {
    private Button baslat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baslat=findViewById(R.id.button_baslat);
        baslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GirisActivity.this,OyunActivity.class));
            }
        });
    }
}