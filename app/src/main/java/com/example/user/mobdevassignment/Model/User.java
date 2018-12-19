package com.example.user.mobdevassignment.Model;

public class User {

    private String username;
    private String email;
    private String password;
    private String mobileNum;
    private String age;
    private String gender;
    private String occupation;

    public User() {
    }

    public User(String username, String email, String password, String mobileNum, String age, String gender, String occupation) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNum = mobileNum;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nickname) {
        this.username = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
