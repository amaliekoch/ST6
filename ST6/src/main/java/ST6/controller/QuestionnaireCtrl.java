package ST6.controller;
import ST6.App;
import ST6.handler.PatientProfileHandler;
import ST6.model.PatientProfileModel;
import ST6.model.QuestionnaireModel;
import ST6.controller.SearchPatientCtrl;
import ST6.controller.LoginCtrl;
import ST6.model.RecommendedTreatmentModel;
import ST6.controller.*;
import ST6.model.*;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    public static String bladderCapacity = "default";
    public static String detrusorOveractivity = "default";
    public static String qolValueEntered = "default";
    public static PatientProfileModel nyPatient; 
    public static QuestionnaireModel nyQuestionnaire;
    public static String savedQuestionnaire = "0";
    public static String savedPatient = "0";

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
        else {
            detrusorOveractivity = "default"; 
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
        else {
            detrusorOveractivity = "default"; 
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
         else {
            detrusorOveractivity = "default"; 
        }
     }

    @FXML
    private Slider qolScale;


    @FXML
    public void EstimateButtonPressed(ActionEvent event) throws IOException { //Når knappen "Estimate effectiveness scores" bliver trykket på:
        //gemmer de input, som er blevet givet til patient profilen
        qolValueEntered = String.valueOf(qolScale.getValue()); //værdi inputtet fra slider = double --> konverterer derfor inputtet i "qol-slideren" til en string

        //Tjek at alle felter er udfyldt    
        if(checkInputFields()) {
            PatientProfileHandler.patientAge = patientAge.getText();
            PatientProfileHandler.patientGender = patientGender.getText();
            PatientProfileHandler.patientName = patientName.getText();
            nyPatient = savePatientProfile(); 
            nyQuestionnaire = saveQuestionnaire();
            // Pop-op vidue med spørgsmål om man vil gemme og komme videre til recommended treatment 
            Alert alert3 = new Alert(AlertType.CONFIRMATION);
            alert3.setTitle("UDecide - UCon decision support");
            alert3.setHeaderText("Do you want to save the patient profile information and questionnaire answers?");
            alert3.setContentText("On the next page you will be able to see the recommended treatments estimated for " + savePatientProfile().getName()+ ".");
            ((Button) alert3.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
            ((Button) alert3.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

            Optional<ButtonType> result3 = alert3.showAndWait();
            if (result3.get() == ButtonType.OK) { // Hvis "yes" vælges
            //Loader og viser nyt view (recommended treatment): 
                FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
                fxmlloader.setLocation(getClass().getResource("/RecommendedTreatmentView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
                final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
                LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
                LoginCtrl.stage.show(); //Vi viser den nye stage

                // ALGORITME SKAL KALDES HER
            }
            else { // Hvis "No" vælges
                System.out.println("Do nothing");
            }
        } 
        else {
            // Pop-op vidue med warning om man vil gemme og komme videre til recommended treatment 
            Alert alert4 = new Alert(AlertType.WARNING);
            alert4.setTitle("UDecide - UCon decision support");
            alert4.setHeaderText("There are missing information. Please enter informaiton in all the fields?");
            alert4.setContentText("There are missing information in either the profile informaiton or in the questionnaire. Please enter the missing information to get to the next page.");
            ((Button) alert4.getDialogPane().lookupButton(ButtonType.OK)).setText("Ok");
            alert4.show();
        }
    }

    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException { 
        LoginCtrl.resetInformation();
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/SearchPatientView1.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) throws IOException { 
        LoginCtrl.resetInformation();
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
        else {
            bladderCapacity = "default"; 
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
        else {
            bladderCapacity = "default"; 
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
        else {
            bladderCapacity = "default"; 
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
        else {
            bladderCapacity = "default"; 
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
        else {
            bladderCapacity = "default"; 
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
        else {
            bladderCapacity = "default"; 
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
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være enten "male" eller "female") 
    }

    @FXML
    void patientName_enter(KeyEvent event) throws IOException {
        // her kan vi indsætte at input skal tjekkes
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
        updateCurrentTreatmentFields(); //opdaterer current treatment informationer på interfacet 
        updateQuestionnaire();   //opdaterer current treatment informationer på interfacet (tomme felter hvis ny patient, udfyldt hvis eksisterende patient)
    }

    // Metode til at opdatere felterne under patient profilen
    public void updatePatientProfileFields() throws IOException {   // hvis patienten allerede er i databasen 
        if (SearchPatientCtrl.registeredPatient.equals("yes") || savedPatient == "1"){
            patientName.setText(PatientProfileHandler.patientName); 
            patientCPR.setText(PatientProfileHandler.patientCPR);
            patientGender.setText(PatientProfileHandler.patientGender);
            patientAge.setText(PatientProfileHandler.patientAge);
        }
        else { // hvis ikke patienten allerede er i databasen 
            patientCPR.setText(PatientProfileModel.getCprInput()); //indsætter det CPR nummer som er blevet givet som input til viewet: "Search patient"
            PatientProfileHandler.patientCPR = patientCPR.getText();
        }
    }

    // Metode til at opdatere felterne under current treatment 
    public void updateCurrentTreatmentFields() throws IOException { 
        if (SearchPatientCtrl.registeredPatient.equals("yes") && (RecommendedTreatmentCtrl.savedTreatment == "0")){ // hvis patienten allerede er i databasen 
            // Nedenstående information skal hentes fra databasen
            currentParadigm.setText("On-Demand");
            currentIntensity.setText("15 mA");
            currentDuration.setText("15 minutes");
            currentElectrode.setText("Surface");
        }
        else if ((SearchPatientCtrl.registeredPatient.equals("yes")) && (RecommendedTreatmentCtrl.savedTreatment == "1")) {
            // Nedenstående skal hentes fra gemte variable
            currentParadigm.setText(RecommendedTreatmentCtrl.newChosenTreatment.getParadigm()); // 
            currentIntensity.setText(RecommendedTreatmentCtrl.newChosenTreatment.getIntensity());
            currentDuration.setText(RecommendedTreatmentCtrl.newChosenTreatment.getDuration());
            currentElectrode.setText(RecommendedTreatmentCtrl.newChosenTreatment.getElectrode());
        }
        else if ((SearchPatientCtrl.registeredPatient.equals("no")) && (RecommendedTreatmentCtrl.savedTreatment == "1")) {
            // Nedenstående skal hentes fra gemte variable
            System.out.println(RecommendedTreatmentCtrl.newChosenTreatment.getParadigm());
            currentParadigm.setText(RecommendedTreatmentCtrl.newChosenTreatment.getParadigm()); // 
            currentIntensity.setText(RecommendedTreatmentCtrl.newChosenTreatment.getIntensity());
            currentDuration.setText(RecommendedTreatmentCtrl.newChosenTreatment.getDuration());
            currentElectrode.setText(RecommendedTreatmentCtrl.newChosenTreatment.getElectrode());
        }
        else { // hvis ikke patienten allerede er i databasen og hvis ikke der er valg en treatment under recommended treatment
            currentParadigm.setText("The patient has no current paradigm"); 
            currentIntensity.setText("The patient has no current intensity");
            currentDuration.setText("The patient has no current duration");
            currentElectrode.setText("The patient has no current electrode");
        }
    }

    // Metode til at opdatere felterne under patient profilen
    public PatientProfileModel savePatientProfile() throws IOException {  // hvis patienten allerede er i databasen 
        PatientProfileModel newPatient = new PatientProfileModel(PatientProfileHandler.patientCPR, PatientProfileHandler.patientName, PatientProfileHandler.patientGender, PatientProfileHandler.patientAge);
        if (SearchPatientCtrl.registeredPatient.equals("yes")){
            System.out.println("Do nothing");
        }
        else { // hvis ikke patienten allerede er i databasen, så gemmes informationerne der er blevet indtastet  
            System.out.println("Save new patient profile in the UDecide database");
            // HER MANGLER DER KODE, SOM KALDER METODE, DER GEMMER "newPatient" I DATABASEN
            PatientProfileModel.insertPatientProfiledata();
        }
        savedPatient = "1";
        return newPatient;
    }

    public QuestionnaireModel saveQuestionnaire() throws IOException { 
        // gemmer de input, som er blevet givet til questionnaire i "nyQuestionnaire"
        QuestionnaireModel nyQuestionnaire = new QuestionnaireModel(numberIEday.getText(), numberUrinationDay.getText(), numberNocturiaDay.getText(), numberUrgeDay.getText(), bladderCapacity, detrusorOveractivity, qolValueEntered);
        // HER MANGLER DER KODE, SOM KALDER METODE, DER GEMMER "nyQuestionnaire" I DATABASEN
        savedQuestionnaire = "1"; 
        return nyQuestionnaire; 
    }

    public boolean checkInputFields() throws IOException { //tjekker at der er udfyldt noget i alle felterne inden der kan fortsættes
    //Felter der skal tjekkes: 
    //patientName, patientCPR, patientGender, patientAge,numberIEday, numberUrinationDay, numberNocturiaDay, numberUrgeDay, DO, BC, qolValueEntered
        if (!patientName.getText().isEmpty() && !patientAge.getText().isEmpty() && !patientGender.getText().isEmpty() && !numberIEday.getText().isEmpty() && !numberUrinationDay.getText().isEmpty() && !numberNocturiaDay.getText().isEmpty() && !numberUrgeDay.getText().isEmpty() && detrusorOveractivity != "default" && bladderCapacity != "default" && qolValueEntered != "default") {
            System.out.println("Do nothing");
            return true;
        }
        else {
            System.out.println("error");
            return false; 
        }
    }

    public void updateQuestionnaire() throws IOException { //opdaterer questionnaire med det gemte information
        if (savedQuestionnaire == "1") {
            numberIEday.setText(nyQuestionnaire.getNumberIEday());
            numberUrinationDay.setText(nyQuestionnaire.getNumberUrinationDay());
            numberUrgeDay.setText(nyQuestionnaire.getNumberUrgeDay());
            numberNocturiaDay.setText(nyQuestionnaire.getNumberNocturiaDay());
            updateBC(); // opdaterer bladder capacity checkbox 
            updateDO(); // opdaterer detrusor overaktivitet checkbox 
            updateQol(); // opdaterer quality of life checkbox 
        }
        else {
            System.out.println("Do nothing");
        }
    }

    public void updateBC() throws IOException {
        if(bladderCapacity == "0-200 ml"){
            bc200.setSelected(true);            
        }
        else if(bladderCapacity == "200-300 ml"){
            bc300.setSelected(true);            
        }
        else if(bladderCapacity == "300-400 ml"){
            bc400.setSelected(true);            
        }
        else if(bladderCapacity == "400-500 ml"){
            bc500.setSelected(true);            
        }
        else if(bladderCapacity == "+500 ml"){
            bcOver500.setSelected(true);            
        }
        else {
            bcUnknown.setSelected(true);
        }
    }

    public void updateDO() throws IOException {
        if(detrusorOveractivity == "Yes"){
            DOyes.setSelected(true);            
        }
        else if(detrusorOveractivity == "No"){
            DOno.setSelected(true);            
        }
        else {
            DOunknown.setSelected(true);
        }
    }

    public void updateQol() throws IOException {
        qolScale.setValue(Double.valueOf(qolValueEntered));
    }
}


    