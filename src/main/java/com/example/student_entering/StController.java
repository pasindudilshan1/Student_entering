package com.example.student_entering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


public class StController {
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField mobilenumberField;
    @FXML
    private TextField emailaddressField;
    @FXML
    private TextField holdernameField;
    @FXML
    private TextField holdersphonenumberField;


    @FXML
    protected void addStudent (){
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String addres = addressField.getText();
        String birthday = birthdayField.getText();
        String mobilenumber = mobilenumberField.getText();
        String emailaddress= emailaddressField.getText();
        String holdername = holdernameField.getText();
        String holdersphonenumber = holdersphonenumberField.getText();

        if (firstname.isEmpty() || lastname.isEmpty()  ||  addres.isEmpty()  ||  birthday.isEmpty()  ||  mobilenumber.isEmpty()  ||  emailaddress.isEmpty()  || holdername.isEmpty() ||  holdersphonenumber.isEmpty()){
            showAlert("error","all field must br field");
            return;
        }
        try {
            Student student = new Student(firstname,lastname,addres,birthday,mobilenumber,holdername,holdersphonenumber);
            showAlert ("Success","Student added" +  student.getFirstname() + student.getLastname());
            clearFields();

        } catch (NumberFormatException e){
            showAlert("Error","error" );
        }

    }

    private void showAlert (String title , String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
    }
    private void clearFields(){
        firstnameField.clear();
        lastnameField.clear();
        addressField.clear();
        birthdayField.clear();
        mobilenumberField.clear();
        emailaddressField.clear();
        holdernameField.clear();
        holdersphonenumberField.clear();
    }
}