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
        //App.closeWindow(); <-- skal måske bruges senere 
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/RecommendedTreatmentView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        Stage stage = new Stage(); //Vi laver en ny stage
        stage.setScene(new Scene(root));//Sætter scenen på vores stage (scenen = root = RecommendedTreatment view)
        stage.show(); //Vi viser den nye stage
        stage.setTitle("UCon"); // Sætter titel på "vinduet" som vises
    }

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
