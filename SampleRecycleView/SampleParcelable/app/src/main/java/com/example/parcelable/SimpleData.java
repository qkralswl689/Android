package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int num, String msg){
        number = num;
        message = msg;
    }

    // Parcel 객체에서 읽기
    protected SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    // CREATOR 상수 정의
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        // SimpleData 생성자를 호출해 Parcel 객체에서 읽기
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    // Parcel 객체로 쓰기 -> SimpleData 객체 안에 들어있는 데이터를 Parcel 객체로 만드는 역할
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
