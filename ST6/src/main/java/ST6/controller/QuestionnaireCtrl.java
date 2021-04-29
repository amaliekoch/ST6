package ST6.controller;
import ST6.App;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
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

public class QuestionnaireCtrl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField patientName;

    @FXML
    private TextField patientCPR;

    @FXML
    private TextField patientGender;

    @FXML
    private TextField currentParadigm;

    @FXML
    private TextField currentIntensity;

    @FXML
    private TextField currentDuration;

    @FXML
    private TextField CurrentElectrode;

    @FXML
    private Button reportEffectButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button estimateEffectivenessScores;

    @FXML
    private TextField numberIEday;

    @FXML
    private TextField numberUrinationDay;

    @FXML
    private TextField numberNocturiaDay;

    @FXML
    private TextField numberUrgeDay;

    @FXML
    private CheckBox DOyes;

    @FXML
    private CheckBox DOno;

    @FXML
    private CheckBox DOunknown;

    @FXML
    private Slider qolScale;


    @FXML
    void EstimateButtonPressed(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/RecommendedTreatmentView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/SearchPatientView1.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/LoginView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void numberIEday_enter(KeyEvent event) {

    }

    @FXML
    void numberNocturiaDay_enter(KeyEvent event) {

    }

    @FXML
    void numberUrgeDay_enter(KeyEvent event) {

    }

    @FXML
    void numberUrinationDay_enter(KeyEvent event) {

    }

    @FXML
    void patientAge_enter(KeyEvent event) {

    }

    @FXML
    void patientCPR_enter(KeyEvent event) {

    }

    @FXML
    void patientGender_enter(KeyEvent event) {

    }

    @FXML
    void patientName_enter(KeyEvent event) {

    }

    @FXML
    void reportEffectButtonPressed(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/ReportEffectView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void initialize() {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentIntensity != null : "fx:id=\"currentIntensity\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentDuration != null : "fx:id=\"currentDuration\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert CurrentElectrode != null : "fx:id=\"CurrentElectrode\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert reportEffectButton != null : "fx:id=\"reportEffectButton\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert goBackButton != null : "fx:id=\"goBackButton\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert estimateEffectivenessScores != null : "fx:id=\"estimateEffectivenessScores\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert numberIEday != null : "fx:id=\"numberIEday\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert numberUrinationDay != null : "fx:id=\"numberUrinationDay\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert numberNocturiaDay != null : "fx:id=\"numberNocturiaDay\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert numberUrgeDay != null : "fx:id=\"numberUrgeDay\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert DOyes != null : "fx:id=\"DOyes\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert DOno != null : "fx:id=\"DOno\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert DOunknown != null : "fx:id=\"DOunknown\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert qolScale != null : "fx:id=\"qolScale\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";

    }
}
