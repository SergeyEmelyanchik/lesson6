package ru.geekbrains.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private int index;

    public Menu(int i) {
        index = i;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public static Creator<Menu> getCREATOR() {
        return CREATOR;
    }

    private int Index;

    protected Menu(Parcel in) {
        Index = in.readInt();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Index);
    }
}

