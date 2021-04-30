package ST6.controller;
import ST6.App;
import ST6.handler.PatientProfileHandler;
import ST6.controller.*;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
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

public class RecommendedTreatmentCtrl {

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
    private TextField patientAge;

    @FXML
    private TextField currentParadigm;

    @FXML
    private TextField currentIntensity;

    @FXML
    private TextField currentDuration;

    @FXML
    private TextField CurrentElectrode;

    @FXML
    private ProgressBar effectScore1;

    @FXML
    private CheckBox chooseTreatment1;

    @FXML
    private ProgressBar effectScore2;

    @FXML
    private ProgressBar effectScore3;

    @FXML
    private CheckBox chooseTreatment2;

    @FXML
    private CheckBox chooseTreatment3;

    @FXML
    private TextArea treatmentInfo1;

    @FXML
    private TextArea treatmentInfo2;

    @FXML
    private TextArea treatmentInfo3;

    @FXML
    private Button saveButton;

    @FXML
    private CheckBox preferPercutaneous;

    @FXML
    private CheckBox preferSurface;

    @FXML
    private Button goBackButton;

    @FXML
    private Button logOutButton;

    @FXML
    void chosenTreatment1_enter(KeyEvent event) {

    }

    @FXML
    void chosenTreatment2_enter(KeyEvent event) {

    }

    @FXML
    void chosenTreatment3_enter(KeyEvent event) {

    }
    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
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
    void preferPercutaneous_enter(KeyEvent event) {

    }

    @FXML
    void preferSurface_enter(KeyEvent event) {

    }

    @FXML
    void saveButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void initialize() throws IOException {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert currentIntensity != null : "fx:id=\"currentIntensity\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert currentDuration != null : "fx:id=\"currentDuration\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert CurrentElectrode != null : "fx:id=\"CurrentElectrode\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore1 != null : "fx:id=\"effectScore1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment1 != null : "fx:id=\"chooseTreatment1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore2 != null : "fx:id=\"effectScore2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore3 != null : "fx:id=\"effectScore3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment2 != null : "fx:id=\"chooseTreatment2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment3 != null : "fx:id=\"chooseTreatment3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo1 != null : "fx:id=\"treatmentInfo1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo2 != null : "fx:id=\"treatmentInfo2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo3 != null : "fx:id=\"treatmentInfo3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert preferPercutaneous != null : "fx:id=\"preferPercutaneous\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert preferSurface != null : "fx:id=\"preferSurface\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert goBackButton != null : "fx:id=\"goBackButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";

       updatePatientProfileFields();
    }

    public void updatePatientProfileFields() throws IOException {   
        patientName.setText(PatientProfileHandler.patientName + "    "); 
        patientCPR.setText(PatientProfileHandler.patientCPR);
        patientGender.setText(PatientProfileHandler.patientGender);
        patientAge.setText(PatientProfileHandler.patientAge); 
        }
}
