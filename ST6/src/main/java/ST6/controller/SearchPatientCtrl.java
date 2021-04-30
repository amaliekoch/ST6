package ST6.controller;
import ST6.App;
import ST6.model.PatientProfileModel;
import ST6.handler.PatientProfileHandler;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.Optional;
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

    public static String registeredPatient;

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
    void enteredCPRnumber_enter(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER)) {
            // her kan vi indsætte at der skal input skal tjekkes 
            checkCPR();
       }
    }

    @FXML
    void SearchButtonPressed(ActionEvent event) throws IOException {
        // her kan vi indsætte at der skal input skal tjekkes 
        checkCPR();
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'SearchPatientView1.fxml'.";
        assert EnteredCprNumer != null : "fx:id=\"EnteredCprNumer\" was not injected: check your FXML file 'SearchPatientView1.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'SearchPatientView1.fxml'.";
    }

    public void checkCPR() throws IOException {
        PatientProfileModel.checkCprNumber(EnteredCprNumer.getText()); // det indtastede CPR nummer gemmes i patientProfileModel
        PatientProfileModel.getPatientProfiledata(EnteredCprNumer.getText()); // det tjekkes om CPR nummeret, der er indtastet findes i databasen
        if (!PatientProfileHandler.patientName.equals("fejl")) {   //Hvis det indtastede CPR nummer matcher et CPR nummer i databasen 
            registeredPatient = "yes";
            // Alert vindue der efterspørg consent: 
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("UDecide - UCon decision support");
            alert.setHeaderText("The next page will contain information about: " + PatientProfileHandler.patientName + "                                             ");
            alert.setContentText("If you click on 'Accept' you confirm, that it is the right patient and that you have consent from the patient to see patient information.");
            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Accept");
            ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ...If the user chose "accept" kommer man videre til "questionnaire"
                FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
                fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
                final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

                LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
                LoginCtrl.stage.show(); // Vi viser den nye stage
            }
            else {
                PatientProfileHandler.patientName = "fejl";
                EnteredCprNumer.clear(); // clear cpr nummeret hvis det er den forkerte patient
            }
        }
        else {
             // hvis ikke det indtastede CPR-nummer eksisterer i databasen
             // Alert vindue: 
             registeredPatient = "no";
             Alert alert2 = new Alert(AlertType.CONFIRMATION);
             alert2.setTitle("UDecide - UCon decision support");
             alert2.setHeaderText("The CPR-number does not match a patient in the system. Do you want to create a new patient?                     ");
             alert2.setContentText("On the next page you will be able to create a new patient by entering patient information about the patient with CPR-number: " + EnteredCprNumer.getText() + ". If you click on 'Accept' you confirm, that it is the right patient and that you have consent from the patient to use patient information.");
             ((Button) alert2.getDialogPane().lookupButton(ButtonType.OK)).setText("Accept");
             ((Button) alert2.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");
 
             Optional<ButtonType> result2 = alert2.showAndWait();
             if (result2.get() == ButtonType.OK) {
                 // ...If the user chose "accept" kommer man videre til "questionnaire"
                 FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
                 fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
                 final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
 
                 LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
                 LoginCtrl.stage.show(); // Vi viser den nye stage
             }
             else {
            EnteredCprNumer.clear(); // ... user chose CANCEL
            }
        } 
    }
}
        