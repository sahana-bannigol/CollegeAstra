package com.collegeastra.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Student implements Parcelable {
    private String USN;
    private String name;
    private String password;
    private String email;
    private String department;
    private List<String> markedbooks;

    public Student(){}


    public Student(String USN,String name,String password,String email,String department){
        this.USN = USN;
        this.name = name;
        this.password = password;
        this.email = email;
        this.department = department;
    }
    protected Student(Parcel in) {
        USN = in.readString();
        name = in.readString();
        password = in.readString();
        email = in.readString();
        department = in.readString();
        if (in.readByte() == 0x01) {
            markedbooks = new ArrayList<String>();
            in.readList(markedbooks, String.class.getClassLoader());
        } else {
            markedbooks = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(USN);
        dest.writeString(name);
        dest.writeString(password);
        dest.writeString(email);
        dest.writeString(department);
        if (markedbooks == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(markedbooks);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getMarkedbooks() {
        return markedbooks;
    }

    public void setMarkedbooks(List<String> markedbooks) {
        this.markedbooks = markedbooks;
    }
}