package com.example.student_entering;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    protected void addStudent() {
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String address = addressField.getText();
        String birthday = birthdayField.getText();
        String mobilenumber = mobilenumberField.getText();
        String emailaddress = emailaddressField.getText();
        String holdername = holdernameField.getText();
        String holdersphonenumber = holdersphonenumberField.getText();

        if (firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || birthday.isEmpty() || mobilenumber.isEmpty() || emailaddress.isEmpty() || holdername.isEmpty() || holdersphonenumber.isEmpty()) {
            showAlert("Error", "All fields must be filled");
            return;
        }

        // Database connection
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
                stmt.setString(5, birthday);
                stmt.setString(6, emailaddress);
                stmt.setString(7, holdername);
                stmt.setString(8, holdersphonenumber);

                stmt.executeUpdate(); // Execute the query

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
        alert.show(); // This line ensures the alert is displayed
    }

    private void clearFields() {
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
