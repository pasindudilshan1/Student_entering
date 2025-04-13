package com.example.student_entering;
import javafx.scene.control.DatePicker;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StController {
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField addressField;
    @FXML
    private DatePicker birthdayPicker;
    @FXML
    private TextField mobilenumberField;
    @FXML
    private TextField emailaddressField;
    @FXML
    private TextField holdernameField;
    @FXML
    private TextField holdersphonenumberField;

    @FXML
    protected void addStudent() {
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String address = addressField.getText();

        String mobilenumber = mobilenumberField.getText();
        String emailaddress = emailaddressField.getText();
        String holdername = holdernameField.getText();
        String holdersphonenumber = holdersphonenumberField.getText();

        LocalDate birthday = birthdayPicker.getValue();
        if (birthday == null) {
            showAlert("Error", "Please select a valid birthday.");
            return;
        }
        if (firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || birthday == null || mobilenumber.isEmpty() || emailaddress.isEmpty() || holdername.isEmpty() || holdersphonenumber.isEmpty()) {
            showAlert("Error", "All fields must be filled");
            return;
        }



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = birthday.format(formatter);





        try (Connection conn = student_db.connect()) {
            if (conn == null) {
                showAlert("Error", "Database connection failed.");
                return;
            }

            String sql = "INSERT INTO student (firstname, lastname, address, mobilenumber, birthday, emailaddress, holdername, holdersphonenumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.setString(3, address);
                stmt.setString(4, mobilenumber);
                stmt.setDate(5, java.sql.Date.valueOf(birthday));
                stmt.setString(6, emailaddress);
                stmt.setString(7, holdername);
                stmt.setString(8, holdersphonenumber);

                stmt.executeUpdate();
                showAlert("Success", "Student added successfully!");
                clearFields();
            }
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    private void clearFields() {
        firstnameField.clear();
        lastnameField.clear();
        addressField.clear();
        birthdayPicker.setValue(null);
        mobilenumberField.clear();
        emailaddressField.clear();
        holdernameField.clear();
        holdersphonenumberField.clear();
    }
}
