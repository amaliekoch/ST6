package ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class EffectCtrl {

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
    private Button viewTreatmentHistory;

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
    private Button treatmentNotFollowed;

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
    private Button save;

    @FXML
    private CheckBox skinIrritation;

    @FXML
    private CheckBox pain;

    @FXML
    private Button estimateNewEffectivenessScore;

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
    private CheckBox worseningSymptoms;

    @FXML
    private CheckBox DOunknownAfter;

    @FXML
    void initialize() {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert viewTreatmentHistory != null : "fx:id=\"viewTreatmentHistory\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentMaxIntensity != null : "fx:id=\"currentMaxIntensity\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentDurationOfStim != null : "fx:id=\"currentDurationOfStim\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert electrode != null : "fx:id=\"electrode\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert treatmentNotFollowed != null : "fx:id=\"treatmentNotFollowed\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberOfButtonPress != null : "fx:id=\"numberOfButtonPress\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert durationOfStimulation != null : "fx:id=\"durationOfStimulation\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert meanIntensityLevel != null : "fx:id=\"meanIntensityLevel\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert graphStimTimeDay != null : "fx:id=\"graphStimTimeDay\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert qolScaleAfter != null : "fx:id=\"qolScaleAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert skinIrritation != null : "fx:id=\"skinIrritation\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert pain != null : "fx:id=\"pain\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert estimateNewEffectivenessScore != null : "fx:id=\"estimateNewEffectivenessScore\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert adverseEventsScale != null : "fx:id=\"adverseEventsScale\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert otherAdverseEvents != null : "fx:id=\"otherAdverseEvents\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberIEdayAfter != null : "fx:id=\"numberIEdayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberUrinationDayAfter != null : "fx:id=\"numberUrinationDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberNocturiaDayAfter != null : "fx:id=\"numberNocturiaDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert numberUrgeDayAfter != null : "fx:id=\"numberUrgeDayAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOyesAfter != null : "fx:id=\"DOyesAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOnoAfter != null : "fx:id=\"DOnoAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert worseningSymptoms != null : "fx:id=\"worseningSymptoms\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert DOunknownAfter != null : "fx:id=\"DOunknownAfter\" was not injected: check your FXML file 'ReportEffectView.fxml'.";

    }
}
