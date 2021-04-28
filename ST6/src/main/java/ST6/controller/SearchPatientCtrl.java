package ST6.controller;
import ST6.App;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class SearchPatientCtrl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField EnteredCprNumer;

    @FXML
    private Button SearchButton;

    @FXML
    void SearchButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
        
        /*//Flyt ovenstående tilbage til metoder der tjekker CPR

        //checkCPR();
    }


    @FXML
    void Search_enter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            checkCPR();
        }
        /*
    }


    @FXML
    public void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'SearchPatientView.fxml'.";
        assert EnteredCprNumer != null : "fx:id=\"cprNumer\" was not injected: check your FXML file 'SearchPatientView.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'SearchPatientView.fxml'.";
    }

    /*public void checkCPR() {
        if (PatientProfileHandler.patientCPR.equals(EnteredCprNumer.getText())) {
            System.out.println("Patient fundet - stil videre til systemet og find patient info");
           /*public void showSearchView() throws IOException {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/SearchPatientView.fxml")); 
                Parent root1 = (Parent) fxmlloader.load(); 
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                stage.setTitle("UCon");
            } 
        }
        else {
            System.out.println("Patient ikke fundet - stil videre til systemet og efterspørg patient info");
        }
        */
    }

}

