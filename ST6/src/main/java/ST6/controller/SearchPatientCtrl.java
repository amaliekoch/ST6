package main.java.ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SearchPatientCtrl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cprTextfield;

    @FXML
    private Button SearchButton;

    @FXML
    void MaxTextField(KeyEvent event) {

    }

    @FXML
    void SearchPressed(ActionEvent event) {

    }

    @FXML
    void Search_enter(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert cprTextfield != null : "fx:id=\"cprTextfield\" was not injected: check your FXML file 'SearchPatientView.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'SearchPatientView.fxml'.";

    }
}
