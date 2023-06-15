package com.example.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class EmployeControler {
    @FXML
    private BorderPane Parent;
    @FXML
    private Button clickBtn;

    @FXML
    private void sayHi(){
        System.out.println("Hello World !!");
    }
}
