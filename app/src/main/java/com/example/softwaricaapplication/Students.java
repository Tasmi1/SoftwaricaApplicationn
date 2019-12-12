package com.example.softwaricaapplication;

public class Students
{

    private String name;
    private int age;
    private String address;
    private String gender;
    private int imggender;
    private int imgbtndelete;

    public Students(String name, int age, String address, String gender, int imggender, int imgbtndelete) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.imggender = imggender;
        this.imgbtndelete = imgbtndelete;
    }

    public Students(String fullname, int parseInt, String address, String gender) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getImggender() {
        return imggender;
    }

    public void setImggender(int imggender) {
        this.imggender = imggender;
    }

    public int getImgbtndelete() {
        return imgbtndelete;
    }

    public void setImgbtndelete(int imgbtndelete) {
        this.imgbtndelete = imgbtndelete;
    }
}
