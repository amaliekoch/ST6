package ST6.controller;
import ST6.App;
import ST6.handler.PatientProfileHandler;
import ST6.model.PatientProfileModel;
import ST6.model.QuestionnaireModel;
import ST6.controller.SearchPatientCtrl;

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

    public String bladderCapacity = "default";
    public String detrusorOveractivity = "default";

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
    private TextField currentElectrode;

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
    private CheckBox bc200;

    @FXML
    private CheckBox bc300;

    @FXML
    private CheckBox bc400;

    @FXML
    private CheckBox bc500;

    @FXML
    private CheckBox bcOver500;

    @FXML
    private CheckBox bcUnknown;

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

    // Metode til at håndtere detrusor overaktivitet check-box
    @FXML
    void handleDOyes(ActionEvent event) throws IOException{
        if(DOyes.isSelected()){
            detrusorOveractivity = "Yes";
            DOno.setSelected(false);
            DOunknown.setSelected(false);
        }
    }

    // Metode til at håndtere detrusor overaktivitet check-box
    @FXML
    void handleDOno(ActionEvent event) throws IOException{
        if(DOno.isSelected()){
            detrusorOveractivity = "No";
            DOyes.setSelected(false);
            DOunknown.setSelected(false);
        }
    }

     // Metode til at håndtere detrusor overaktivitet check-box
     @FXML
     void handleDOunknown(ActionEvent event) throws IOException{
         if(DOunknown.isSelected()){
             detrusorOveractivity = "Unknown";
             DOyes.setSelected(false);
             DOno.setSelected(false);
         }
     }

    @FXML
    private Slider qolScale;


    @FXML
    void EstimateButtonPressed(ActionEvent event) throws IOException { //Når knappen "Estimate effectiveness scores" bliver trykket på:
        //gemmer de input, som er blevet givet til patient profilen
        PatientProfileHandler.patientAge = patientAge.getText();
        PatientProfileHandler.patientGender = patientGender.getText();
        PatientProfileHandler.patientName = patientName.getText();
        SearchPatientCtrl.registeredPatient = "yes"; 
        //savePatientProfileModel();

        // gemmer de input, som er blevet givet til questionnaire i "nyQuestionnaire"
        QuestionnaireModel nyQuestionnaire = new QuestionnaireModel(numberIEday.getText(), numberUrinationDay.getText(), numberNocturiaDay.getText(), numberUrgeDay.getText(), bladderCapacity, detrusorOveractivity, "5");

        //Loader og viser nyt view (recommended treatment): 
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
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-30)
    }


    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC200(ActionEvent event) throws IOException{
        if(bc200.isSelected()){
            bladderCapacity = "0-200 ml";
            bc300.setSelected(false);
            bc400.setSelected(false);
            bc500.setSelected(false);
            bcOver500.setSelected(false);
            bcUnknown.setSelected(false);
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC300(ActionEvent event) throws IOException{
        if(bc300.isSelected()){
            bladderCapacity = "200-300 ml";
            bc200.setSelected(false);
            bc400.setSelected(false);
            bc500.setSelected(false);
            bcOver500.setSelected(false);
            bcUnknown.setSelected(false);
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC400(ActionEvent event) throws IOException{
        if(bc400.isSelected()){
            bladderCapacity = "300-400 ml";
            bc200.setSelected(false);
            bc300.setSelected(false);
            bc500.setSelected(false);
            bcOver500.setSelected(false);
            bcUnknown.setSelected(false);
        }
    }

     // Metode til at håndtere bladder capacity check-boxes
    @FXML
     void handleBC500(ActionEvent event) throws IOException{
        if(bc500.isSelected()){
            bladderCapacity = "400-500 ml";
            bc200.setSelected(false);
            bc300.setSelected(false);
            bc400.setSelected(false);
            bcOver500.setSelected(false);
            bcUnknown.setSelected(false);
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBCover500(ActionEvent event) throws IOException{
        if(bcOver500.isSelected()){
            bladderCapacity = "+500 ml";
            bc200.setSelected(false);
            bc300.setSelected(false);
            bc400.setSelected(false);
            bc500.setSelected(false);
            bcUnknown.setSelected(false);
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBCunknown(ActionEvent event) throws IOException{
        if(bcUnknown.isSelected()){
            bladderCapacity = "Unknown";
            bc200.setSelected(false);
            bc300.setSelected(false);
            bc400.setSelected(false);
            bc500.setSelected(false);
            bcOver500.setSelected(false);
        }
    }

    @FXML
    void numberNocturiaDay_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-10)

    }

    @FXML
    void numberUrgeDay_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-30)

    }

    @FXML
    void numberUrinationDay_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-30)
    }

    @FXML
    void patientAge_enter(KeyEvent event) throws IOException {
        // her kan vi indsætte at der skal input skal tjekkes (eksempelvis at input skal være mellem 0-120)
    }

    @FXML
    void patientCPR_enter(KeyEvent event) throws IOException {
        // Den her skal vi nok ikke bruge alligevel 
    }

    @FXML
    void patientGender_enter(KeyEvent event)  throws IOException {
        // her kan vi indsætte at der skal input skal tjekkes (eksempelvis at input skal være enten "male" eller "female") 
    }

    @FXML
    void patientName_enter(KeyEvent event) throws IOException {
        // her kan vi indsætte at der skal input skal tjekkes
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
    void initialize() throws IOException {
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentIntensity != null : "fx:id=\"currentIntensity\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentDuration != null : "fx:id=\"currentDuration\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert currentElectrode != null : "fx:id=\"CurrentElectrode\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
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
        assert DOyes != null : "fx:id=\"DOyes\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bc200 != null : "fx:id=\"bc200\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bc300 != null : "fx:id=\"bc300\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bc400 != null : "fx:id=\"bc400\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bc500 != null : "fx:id=\"bc500\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bcOver500 != null : "fx:id=\"bcOver500\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        assert bcUnknown != null : "fx:id=\"bcUnknown\" was not injected: check your FXML file 'QuestionnaireView.fxml'.";
        
        updatePatientProfileFields(); //opdaterer patient information på interfacet   
        updateCurrentTreatmentFields();      
    }

    public void updatePatientProfileFields() throws IOException {   // hvis patienten allerede er i databasen 
        if (SearchPatientCtrl.registeredPatient.equals("yes")){
            patientName.setText(PatientProfileHandler.patientName); 
            patientCPR.setText(PatientProfileHandler.patientCPR);
            patientGender.setText(PatientProfileHandler.patientGender);
            patientAge.setText(PatientProfileHandler.patientAge);
            //savePatientProfileModel();
        }
        else { // hvis ikke patienten allerede er i databasen 
            patientCPR.setText(PatientProfileModel.getCprInput()); //indsætter det CPR nummer som er blevet givet som input til viewet: "Search patient"
            PatientProfileHandler.patientCPR = patientCPR.getText();
        }
    }

    public void updateCurrentTreatmentFields() throws IOException {   // hvis patienten allerede er i databasen 
        if (SearchPatientCtrl.registeredPatient.equals("yes")){
            currentParadigm.setText("On-Demand"); // 
            currentIntensity.setText("15 mA");
            currentDuration.setText("15 minutes");
            currentElectrode.setText("Surface");
        }
        else { // hvis ikke patienten allerede er i databasen 
            currentParadigm.setText("The patient has no current paradigm"); 
            currentIntensity.setText("No current intensity");
            currentDuration.setText("No current duration");
            currentElectrode.setText("No current electrode");
        }
    }

    //public void savePatientProfileModel(){ // så kan vi smide info det i databasen 
    //    PatientProfileModel nyPatient = new PatientProfileModel(PatientProfileHandler.patientCPR, PatientProfileHandler.patientName, PatientProfileHandler.patientGender, PatientProfileHandler.patientAge);
    //}

}


    