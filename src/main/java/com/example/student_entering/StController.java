package com.example.student_entering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}