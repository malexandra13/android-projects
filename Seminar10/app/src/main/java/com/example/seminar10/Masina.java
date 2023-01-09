package com.example.seminar10;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Masini")

public class Masina {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "model")
    //atentie daca in ColumnInfo modificam numele, trebuie sa tinem cont mai
    //departe cand facem select-uri
    private String model;
    @ColumnInfo(name ="latime")
    private float latime;
    @ColumnInfo(name="culoare")
    private String culoare;
    @ColumnInfo(name="nrLocuri")
    private int nrLocuri;

    public Masina(String model, float latime, String culoare, int nrLocuri) {
        this.model = model;
        this.latime = latime;
        this.culoare = culoare;
        this.nrLocuri = nrLocuri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getLatime() {
        return latime;
    }

    public void setLatime(float latime) {
        this.latime = latime;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", latime=" + latime +
                ", culoare='" + culoare + '\'' +
                ", nrLocuri=" + nrLocuri +
                '}';
    }
}
