package ST6.controller;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import ST6.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
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
public class ReportEffectCtrl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button viewTreatmentHistoryButton;

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
    private Button goBackButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button treatmentNotFollowedButton;

    @FXML
    private TextField numberOfButtonPress;

    @FXML
    private TextField durationOfStimulation;

    @FXML
    private TextField meanIntensityLevel;

    @FXML
    private BarChart<?, ?> graphStimTimeDay;

    @FXML
    private Slider qolScaleAfter;

    @FXML
    private Button saveReportButton;

    @FXML
    private CheckBox skinIrritationCheckbox;

    @FXML
    private CheckBox painCheckbox;

    @FXML
    private Button estimateNewButton;

    @FXML
    private Slider adverseEventsScale;

    @FXML
    private TextField otherAdverseEvents;

    @FXML
    private TextField numberIEdayAfter;

    @FXML
    private TextField numberUrinationDayAfter;

    @FXML
    private TextField numberNocturiaDayAfter;

    @FXML
    private TextField numberUrgeDayAfter;

    @FXML
    private CheckBox DOyesAfter;

    @FXML
    private CheckBox DOnoAfter;

    @FXML
    private CheckBox worseningSymptomsCheckbox;

    @FXML
    private CheckBox DOunknownAfter;

    @FXML
    private CheckBox bc200After;

    @FXML
    private CheckBox bcOver500After;

    @FXML
    private CheckBox bc400After;

    @FXML
    private CheckBox bc300After;

    @FXML
    private CheckBox bc500After;

    @FXML
    private CheckBox bcUnknownAfter;

    @FXML
    void DOnoAfter_enter(KeyEvent event) {

    }

    @FXML
    void DOunknownAfter_enter(KeyEvent event) {

    }

    @FXML
    void DOyesAfter_enter(KeyEvent event) {

    }

    @FXML
    void TreatmentNotFollowedButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void adverseEventsScale_enter(KeyEvent event) {

    }

    @FXML
    void estimateNewButtonPressed(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void handleBC200After(ActionEvent event) {

    }

    @FXML
    void handleBC300After(ActionEvent event) {

    }

    @FXML
    void handleBC400After(ActionEvent event) {

    }

    @FXML
    void handleBC500After(ActionEvent event) {

    }

    @FXML
    void handleBCover500After(ActionEvent event) {

    }

    @FXML
    void handleBCunknownAfter(ActionEvent event) {

    }

    @FXML
    void handleDOnoAfter(ActionEvent event) {

    }

    @FXML
    void handleDOunknownAfter(ActionEvent event) {

    }

    @FXML
    void handleDOyesAfter(ActionEvent event) {

    }

    @FXML
    void logOutButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/LoginView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void numberIEdayAfter_enter(KeyEvent event) {

    }

    @FXML
    void numberNocturiaDayAfter_enter(KeyEvent event) {

    }

    @FXML
    void numberUrgeDayAfter_enter(KeyEvent event) {

    }

    @FXML
    void numberUrinationDayAfter_enter(KeyEvent event) {

    }

    @FXML
    void otherAdverseEvents_enter(KeyEvent event) {

    }

    @FXML
    void painCheckbox_enter(KeyEvent event) {

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
    void qolScaleAfter_enter(KeyEvent event) {

    }

    @FXML
    void saveReportButtonPressed(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void skinIrritationCheckbox_enter(KeyEvent event) {

    }

    @FXML
    void viewTreatmentHistoryButtonPressed(ActionEvent event) {

    }

    @FXML
    void worseningSymptomsCheckbox_enter(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert viewTreatmentHistoryButton != null : "fx:id=\"viewTreatmentHistoryButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentIntensity != null : "fx:id=\"currentIntensity\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentDuration != null : "fx:id=\"currentDuration\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert CurrentElectrode != null : "fx:id=\"CurrentElectrode\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert goBackButton != null : "fx:id=\"goBackButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert treatmentNotFollowedButton != null : "fx:id=\"treatmentNotFollowedButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberOfButtonPress != null : "fx:id=\"numberOfButtonPress\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert durationOfStimulation != null : "fx:id=\"durationOfStimulation\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert meanIntensityLevel != null : "fx:id=\"meanIntensityLevel\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert graphStimTimeDay != null : "fx:id=\"graphStimTimeDay\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert qolScaleAfter != null : "fx:id=\"qolScaleAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert saveReportButton != null : "fx:id=\"saveReportButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert skinIrritationCheckbox != null : "fx:id=\"skinIrritationCheckbox\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert painCheckbox != null : "fx:id=\"painCheckbox\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert estimateNewButton != null : "fx:id=\"estimateNewButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert adverseEventsScale != null : "fx:id=\"adverseEventsScale\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert otherAdverseEvents != null : "fx:id=\"otherAdverseEvents\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberIEdayAfter != null : "fx:id=\"numberIEdayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberUrinationDayAfter != null : "fx:id=\"numberUrinationDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberNocturiaDayAfter != null : "fx:id=\"numberNocturiaDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberUrgeDayAfter != null : "fx:id=\"numberUrgeDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOyesAfter != null : "fx:id=\"DOyesAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOnoAfter != null : "fx:id=\"DOnoAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert worseningSymptomsCheckbox != null : "fx:id=\"worseningSymptomsCheckbox\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOunknownAfter != null : "fx:id=\"DOunknownAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bc200After != null : "fx:id=\"bc200After\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bcOver500After != null : "fx:id=\"bcOver500After\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bc400After != null : "fx:id=\"bc400After\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bc300After != null : "fx:id=\"bc300After\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bc500After != null : "fx:id=\"bc500After\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert bcUnknownAfter != null : "fx:id=\"bcUnknownAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
    }
}


/*
public class ReportEffectCtrl {

    @FXML
    void TreatmentNotFollowedButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void estimateNewButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/LoginView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    @FXML
    void saveReportButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

*/