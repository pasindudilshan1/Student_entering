package com.example.student_entering;

public class Student {
    private String firstname;
    private String lastname;
    private String address;
    private String birthday;
    private String mobilenumber;
    private String emailaddress;
    private String holdername;
    private String holdersphonenumber;


    public Student(String firstname,String lastname,String address,String mobilenumber , String birthday, String emailaddress, String holdername , String holdersphonenumber ){
        this.firstname=firstname;
        this.lastname = lastname;
        this.address=address;
        this.birthday=birthday;
        this.mobilenumber=mobilenumber;
        this.emailaddress=emailaddress;
        this.holdername=holdername;
        this.holdersphonenumber=holdersphonenumber;

    }

    public String getFirstname (){
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHoldername() {
        return holdername;
    }

    public String getHoldersphonenumber() {
        return holdersphonenumber;
    }
}


