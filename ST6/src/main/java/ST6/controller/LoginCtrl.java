package ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import main.java.ST6.controller.SearchPatientCtrl;
import main.java.ST6.model.SpecialistModel;
import java.io.IOException;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import ST6.App;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

public class LoginCtrl {

    // test start

    
    @FXML
        private AnchorPane rootPane;
    
    @FXML
        private TextField EnteredCprNumer;
    
    @FXML
        private Button SearchButton;
    
    @FXML
    void SearchButtonPressed(ActionEvent event) {
    
        }
    
    @FXML
    void Search_enter(KeyEvent event) {
    }
    // test slut 

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    SpecialistModel loggedInUser = null; 

    @FXML
    void loginPressed(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    void password_enter(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER)) {
            checkLogin();
       }
    }

    @FXML
    void username_enter(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER)) {
            checkLogin();
       }
    }

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert EnteredCprNumer != null : "fx:id=\"EnteredCprNumer\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert SearchButton != null: "fx:id=\"SearchButton\" was not injected: check your FXML file 'LoginView.fxml'.";
    }
    

    void checkLogin() throws IOException {
        /*Tilføj specialister der skal kunne logge ind her*/
        List<SpecialistModel> listOfSpecialists = new ArrayList<>(); //Laver en array liste hvor specialister kan smides ind i. 
        listOfSpecialists.add(new SpecialistModel("1234","9876"));
        listOfSpecialists.add(new SpecialistModel("2222","yes"));
             
         for (SpecialistModel SpecialistModel : listOfSpecialists){  //Loop der kører hele listen igennem
             if (username.getText().equals(SpecialistModel.getUsername())){ // Sammenligner brugernavn med det der står i textfield
                 if (password.getText().equals(SpecialistModel.getPassword())){ //Sammenligner password med det der står i passwordfield
                     loggedInUser = SpecialistModel;
                     break;
                    }
                }
            } 
         
         if (loggedInUser!=null) {
                App.closeWindow(); //Lukker login vindue
                //SearchPatientCtrl searchView = new SearchPatientCtrl();
                //searchView.showSearchView();
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/SearchView.fxml")); 
                Parent root1 = (Parent) fxmlloader.load(); 
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                stage.setTitle("UCon");
             }
             else
             {
         
             Alert alert = new Alert(AlertType.ERROR); //Fejldiaglogboks loades hvis loginoplysningerne er forkerte.
               alert.setHeaderText("WARNING: You have entered wrong or invalid username and/or password"); 
               alert.showAndWait();
             }
        }

}
