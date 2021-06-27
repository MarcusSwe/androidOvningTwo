package com.example.ovningtwo;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {

    String userName;
    String password;
    String forName;
    String surName;
    int age;
    String occupation;
    String hobbies;
    int arrayNumber;

    public UserInfo(String username, String passWord, int array){
        this.userName = username;
        this.password = passWord;
        this.arrayNumber = array;
    }

    protected UserInfo(Parcel in) {
        userName = in.readString();
        password = in.readString();
        forName = in.readString();
        surName = in.readString();
        age = in.readInt();
        occupation = in.readString();
        hobbies = in.readString();
        arrayNumber = in.readInt();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public int getArrayNumber() {
        return arrayNumber;
    }

    public void setArrayNumber(int arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(forName);
        dest.writeString(surName);
        dest.writeInt(age);
        dest.writeString(occupation);
        dest.writeString(hobbies);
        dest.writeInt(arrayNumber);
    }



}
