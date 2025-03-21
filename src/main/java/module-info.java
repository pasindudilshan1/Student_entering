module com.example.student_entering {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.student_entering to javafx.fxml;
    exports com.example.student_entering;
}