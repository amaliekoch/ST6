package ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Button saveChosenTreatment;

    @FXML
    private CheckBox preferPercutaneous;

    @FXML
    private CheckBox preferSurface;

    @FXML
    void initialize() {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore1 != null : "fx:id=\"effectScore1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment1 != null : "fx:id=\"chooseTreatment1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore2 != null : "fx:id=\"effectScore2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert effectScore3 != null : "fx:id=\"effectScore3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment2 != null : "fx:id=\"chooseTreatment2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert chooseTreatment3 != null : "fx:id=\"chooseTreatment3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo1 != null : "fx:id=\"treatmentInfo1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo2 != null : "fx:id=\"treatmentInfo2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert treatmentInfo3 != null : "fx:id=\"treatmentInfo3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert saveChosenTreatment != null : "fx:id=\"saveChosenTreatment\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert preferPercutaneous != null : "fx:id=\"preferPercutaneous\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert preferSurface != null : "fx:id=\"preferSurface\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";

    }
}
