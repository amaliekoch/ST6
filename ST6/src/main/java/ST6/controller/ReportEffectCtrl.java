package ST6.controller;

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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.io.IOException;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ST6.App;

public class ReportEffectCtrl {

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
    private Button viewTreatmentHistoryButton;

    @FXML
    private TextField currentParadigm;

    @FXML
    private TextField currentMaxIntensity;

    @FXML
    private TextField currentDurationOfStim;

    @FXML
    private TextField electrode;

    @FXML
    private TextField patientAge;

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
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader som henter "DatacategoryView"
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml"));
       // Parent root1 = (Parent) fxmlloader.load(); 
        final Parent root = fxmlloader.load();
        Stage stage = new Stage(); //Vi laver en ny stage
        stage.setScene(new Scene(root));
        stage.show(); //Vi viser den nye stage
        stage.setTitle("UCon");
    }

    @FXML
    void adverseEventsScale_enter(KeyEvent event) { 

    }

    @FXML
    void estimateNewButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader som henter "DatacategoryView"
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml"));
       // Parent root1 = (Parent) fxmlloader.load(); 
        final Parent root = fxmlloader.load();
        Stage stage = new Stage(); //Vi laver en ny stage
        stage.setScene(new Scene(root));
        stage.show(); //Vi viser den nye stage
        stage.setTitle("UCon");
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
    void qolScaleAfter_enter(KeyEvent event) {

    }

    @FXML
    void saveReportButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader som henter "DatacategoryView"
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml"));
       // Parent root1 = (Parent) fxmlloader.load(); 
        final Parent root = fxmlloader.load();
        Stage stage = new Stage(); //Vi laver en ny stage
        stage.setScene(new Scene(root));
        stage.show(); //Vi viser den nye stage
        stage.setTitle("UCon");
    }

    @FXML
    void skinIrritationCheckbox_enter(KeyEvent event) {

    }

    @FXML
    void viewTreatmentHistoryButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader som henter "DatacategoryView"
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml"));
       // Parent root1 = (Parent) fxmlloader.load(); 
        final Parent root = fxmlloader.load();
        Stage stage = new Stage(); //Vi laver en ny stage
        stage.setScene(new Scene(root));
        stage.show(); //Vi viser den nye stage
        stage.setTitle("UCon");
    }

    @FXML
    void worseningSymptomsCheckbox_enter(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert viewTreatmentHistoryButton != null : "fx:id=\"viewTreatmentHistoryButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentMaxIntensity != null : "fx:id=\"currentMaxIntensity\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentDurationOfStim != null : "fx:id=\"currentDurationOfStim\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert electrode != null : "fx:id=\"electrode\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
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

    }
}
