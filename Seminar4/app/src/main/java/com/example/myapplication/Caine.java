package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Caine implements Parcelable {
    private String rasa;
    private float varsta;

    public Caine(){
        this.rasa="Husky";
        this.varsta=0.1f;
    }


    protected Caine(Parcel in) {
        rasa = in.readString();
        varsta = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rasa);
        dest.writeFloat(varsta);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Caine> CREATOR = new Creator<Caine>() {
        @Override
        public Caine createFromParcel(Parcel in) {
            return new Caine(in);
        }

        @Override
        public Caine[] newArray(int size) {
            return new Caine[size];
        }
    };
}
