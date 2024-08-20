module com.example.dr_projem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dr_projem to javafx.fxml;
    exports com.example.dr_projem;
}