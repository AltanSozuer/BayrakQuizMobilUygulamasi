package com.example.bayraklarsoruuygulamasi;

public class Bayrak {
    private int id;
    private String bayrak_isim;
    private String bayrak_resim;
    Bayrak(){

    }

    public Bayrak(int id, String bayrak_isim, String bayrak_resim) {
        this.id = id;
        this.bayrak_isim = bayrak_isim;
        this.bayrak_resim = bayrak_resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBayrak_isim() {
        return bayrak_isim;
    }

    public void setBayrak_isim(String bayrak_isim) {
        this.bayrak_isim = bayrak_isim;
    }

    public String getBayrak_resim() {
        return bayrak_resim;
    }

    public void setBayrak_resim(String bayrak_resim) {
        this.bayrak_resim = bayrak_resim;
    }
}
