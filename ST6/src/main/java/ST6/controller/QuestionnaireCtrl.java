package ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

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
    void initialize() {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
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
