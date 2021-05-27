package ST6.controller;
import ST6.App;
import ST6.controller.SearchPatientCtrl;
import main.java.ST6.model.SpecialistModel; 
import ST6.handler.*;
import ST6.controller.*;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.security.KeyStore.SecretKeyEntry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

public class LoginCtrl {

    public static Stage stage;

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
    }


    void checkLogin() throws IOException {
        /*Tilføj specialister der skal kunne logge ind her*/
        List<SpecialistModel> listOfSpecialists = new ArrayList<>(); //Laver en array-liste hvor specialister kan smides ind i. 
        listOfSpecialists.add(new SpecialistModel("1234","9876")); // specialist 1
        listOfSpecialists.add(new SpecialistModel("2222","yes")); // specialist 2
             
         for (SpecialistModel SpecialistModel : listOfSpecialists){  //Loop der kører hele array-listen igennem
             if (username.getText().equals(SpecialistModel.getUsername())){ // Sammenligner brugernavn med det der der er indtastet i textfield
                 if (password.getText().equals(SpecialistModel.getPassword())){ //Sammenligner password med det der der er indtastet i passwordfield
                     loggedInUser = SpecialistModel; // sætter loggedInUser = SpecialistModel, hvis username og password er korrekt  
                     break;
                    }
                }
            } 
         
         if (loggedInUser!=null) { //hvis username og password er korrekt --> viser searchPatientView 
            App.closeWindow();
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/SearchPatientView1.fxml")); // Ny loader instantieres - skal bruges til at hente viewet via fxml-filen som ligger under "Resources"
            Parent root1 = (Parent) fxmlloader.load(); // Loader (henter) fxml-filen, som indeholdet det view vi gerne vil vise
            Stage stage = new Stage(); // Vi laver en ny stage
            LoginCtrl.stage = stage;
            stage.setScene(new Scene(root1)); // Sætter scenen på vores stage (scenen = root = SearchPatient view)
            stage.show(); // Viser den nye stage
            stage.setTitle("UDecide - UCon Decision support"); // Sætter titel på "vinduet" som vises   
        }
        else { //hvis username og password er forker --> viser fejl meddelelse
            Alert alert = new Alert(AlertType.ERROR); //Fejldiaglogboks loades 
            alert.setHeaderText("WARNING: You have entered wrong or invalid username and/or password"); // definerer fejl meddelelse 
            alert.showAndWait(); // Viser fejl meddelelse
        }
    }

    public static void resetInformation() throws IOException {
        PatientProfileHandler.patientCPR = "default"; 
        PatientProfileHandler.patientName = "fejl";
        PatientProfileHandler.patientGender = "default";
        PatientProfileHandler.patientAge = "default"; 
        SearchPatientCtrl.registeredPatient = "default"; 
    }

}
