package com.example.bayraklarsoruuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private TextView puan;
    private Button tekrarOyna;
    private int sonuc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        tekrarOyna=findViewById(R.id.button_tekrarOyna);
        puan=findViewById(R.id.textView_puan);
        sonuc=getIntent().getIntExtra("puan",0);
        puan.setText(String.valueOf(sonuc));
        tekrarOyna.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this,OyunActivity.class));
                finish();
            }
        });
    }
}