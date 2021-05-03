package com.example.android.a108590061_hw8_part_2;
import android.os.Parcel;
import android.os.Parcelable;

class Sport implements Parcelable {

    private String main_sport_title;
    private String sports_detail;
    private String sports_info;
    private final int rsc_img;


    Sport(String title, String info, int imageResource, String details) {
        this.main_sport_title = title;
        this.sports_info = info;
        this.rsc_img = imageResource;
        this.sports_detail = details;
    }

    private Sport(Parcel in) {
        main_sport_title = in.readString();
        sports_info = in.readString();
        sports_detail = in.readString();
        rsc_img = in.readInt();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }
        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };


    public int getImageResource() {

        return rsc_img;
    }

    String getTitle() {

        return main_sport_title;
    }

    String getDetails() {

        return sports_detail;
    }

    String getInfo() {

        return sports_info;
    }

    @Override
    public void writeToParcel(Parcel theparcel, int flags) {
        theparcel.writeString(main_sport_title);
        theparcel.writeString(sports_detail);
        theparcel.writeString(sports_info);
        theparcel.writeInt(rsc_img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}