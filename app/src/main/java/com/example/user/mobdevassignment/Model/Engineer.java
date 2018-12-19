package com.example.user.mobdevassignment.Model;

import android.graphics.Bitmap;

public class Engineer {
    private String username;
    private String email;
    private String mobileNum;
    private String address;
    private String gender;
    private int age;
    private String occupation;
    private String experience;
    private String password;
    private String idcard;
    private String idnum;
    private Bitmap idpic;

    public Engineer() {
    }

    public Engineer(String username, String email, String mobileNum, String address, String gender, int age, String occupation, String experience, String password, String idcard, String idnum, Bitmap idpic) {
        this.username = username;
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.experience = experience;
        this.password = password;
        this.idcard = idcard;
        this.idnum = idnum;
        this.idpic = idpic;
    }

    public Engineer(String username, String email, String mobileNum, String address, String gender, int age, String occupation, String experience, String password, String idcard, String idnum) {
        this.username = username;
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.experience = experience;
        this.password = password;
        this.idcard = idcard;
        this.idnum = idnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public Bitmap getIdpic() {
        return idpic;
    }

    public void setIdpic(Bitmap idpic) {
        this.idpic = idpic;
    }
}
