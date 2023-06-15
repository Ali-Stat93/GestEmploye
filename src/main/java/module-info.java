module com.example {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example;
    opens com.example.controler to javafx.fxml;
    opens com.example.model to javafx.base;
}
