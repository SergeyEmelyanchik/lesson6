package ru.geekbrains.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private int index;

    public Menu(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static Creator<Menu> getCREATOR() {
        return CREATOR;
    }


    protected Menu(Parcel in) {
        index = in.readInt();
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
        parcel.writeInt(index);
    }
}

