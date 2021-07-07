package com.example.bayraklarsoruuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OyunActivity extends AppCompatActivity {
    private Button buton_a,buton_b,buton_c,buton_d;
    private ImageView bayrak;
    private TextView dogruText,yanlisText;
    private Veritabani vt=new Veritabani(OyunActivity.this);
    private ArrayList<Bayrak> liste=null;
    private int dogru=0,yanlis=0;
    private int indctr=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        viewBagla();
        veritabaniKopyala();
        skorGuncelle();
        indctr=soru();

        buton_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indctr==0){
                    ++dogru;
                }
                else ++yanlis;
                if(yanlis<3){
                    skorGuncelle();
                }
                sonucSayfasiAktiflestirme();

            }
        });
        buton_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indctr==1){
                    ++dogru;
                }
                else ++yanlis;
                if(yanlis<3){
                    skorGuncelle();
                }
                sonucSayfasiAktiflestirme();
            }
        });
        buton_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indctr==2){
                    ++dogru;
                }
                else ++yanlis;
                if(yanlis<3){
                    skorGuncelle();
                }
                sonucSayfasiAktiflestirme();
            }
        });
        buton_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indctr==3){
                    ++dogru;
                }
                else ++yanlis;
                if(yanlis<3){
                    skorGuncelle();
                }
                sonucSayfasiAktiflestirme();
            }
        });
    }
    public void sonucSayfasiAktiflestirme(){
        if((yanlis>=3)){
            Intent intent=new Intent(OyunActivity.this,SonucActivity.class);
            intent.putExtra("puan",dogru);
            startActivity(intent);
            finish();
            return;
        }
        else{
            liste.clear();
            indctr=soru();
        }
    }
    public int soru(){
        ArrayList<Bayrak> tempList=new BayrakDAO().rastgeleBayraklar(vt);
        liste=tempList;
        int index=randSayi(4);
        buton_a.setText(liste.get(0).getBayrak_isim());
        buton_b.setText(liste.get(1).getBayrak_isim());
        buton_c.setText(liste.get(2).getBayrak_isim());
        buton_d.setText(liste.get(3).getBayrak_isim());
        bayrak.setImageResource(getResources().getIdentifier(liste.get(index).getBayrak_resim(),"drawable",getPackageName()));
        return index;
    }
    public void skorGuncelle(){
        dogruText.setText("DOĞRU : \n"+dogru);
        yanlisText.setText("YANLIŞ : \n"+yanlis);
    }
    public int randSayi(int bound){
        Random random=new Random();
        return random.nextInt(bound);
    }
    public void viewBagla(){
        buton_a=findViewById(R.id.button_a);
        buton_b=findViewById(R.id.button_b);
        buton_c=findViewById(R.id.button_c);
        buton_d=findViewById(R.id.button_d);
        bayrak=findViewById(R.id.imageView_bayrak);
        dogruText=findViewById(R.id.textView_dogru);
        yanlisText=findViewById(R.id.textView_yanlis);
    }
    public void veritabaniKopyala(){
        VeritabaniYardimci databaseCopyHelper=new VeritabaniYardimci(this);
        try {
            databaseCopyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        databaseCopyHelper.openDataBase();
    }
}