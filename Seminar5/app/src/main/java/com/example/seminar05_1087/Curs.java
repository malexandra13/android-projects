package com.example.seminar05_1087;

import android.os.Parcel;
import android.os.Parcelable;

public class Curs implements Parcelable {
    private String denumire;
    private int nrCredite;
    private boolean examenOral;
    private int nrOreCurs;
    private int nrOreSeminar;

    public Curs(String denumire, int nrCredite, boolean examenOral, int nrOreCurs, int nrOreSeminar) {
        this.denumire = denumire;
        this.nrCredite = nrCredite;
        this.examenOral = examenOral;
        this.nrOreCurs = nrOreCurs;
        this.nrOreSeminar = nrOreSeminar;
    }

    protected Curs(Parcel in) {
        denumire = in.readString();
        nrCredite = in.readInt();
        examenOral = in.readByte() != 0;
        nrOreCurs = in.readInt();
        nrOreSeminar = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumire);
        dest.writeInt(nrCredite);
        dest.writeByte((byte) (examenOral ? 1 : 0));
        dest.writeInt(nrOreCurs);
        dest.writeInt(nrOreSeminar);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Curs> CREATOR = new Creator<Curs>() {
        @Override
        public Curs createFromParcel(Parcel in) {
            return new Curs(in);
        }

        @Override
        public Curs[] newArray(int size) {
            return new Curs[size];
        }
    };

    @Override
    public String toString() {
        return "Curs{" +
                "denumire='" + denumire + '\'' +
                ", nrCredite=" + nrCredite +
                ", examenOral=" + examenOral +
                ", nrOreCurs=" + nrOreCurs +
                ", nrOreSeminar=" + nrOreSeminar +
                '}';
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public boolean isExamenOral() {
        return examenOral;
    }

    public void setExamenOral(boolean examenOral) {
        this.examenOral = examenOral;
    }

    public int getNrOreCurs() {
        return nrOreCurs;
    }

    public void setNrOreCurs(int nrOreCurs) {
        this.nrOreCurs = nrOreCurs;
    }

    public int getNrOreSeminar() {
        return nrOreSeminar;
    }

    public void setNrOreSeminar(int nrOreSeminar) {
        this.nrOreSeminar = nrOreSeminar;
    }
}
