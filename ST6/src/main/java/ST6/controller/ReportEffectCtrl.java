package ST6.controller;
import ST6.controller.*;
import ST6.model.*;
import ST6.model.TreatmentEffectModel;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import ST6.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
public class ReportEffectCtrl {

    public static String bladderCapacityAfter = "default";
    public static String detrusorOveractivityAfter = "default";
    public static String qolValueEnteredAfter = "default";
    public static String painAfter = "default";
    public static String skinIrritationAfter = "default";
    public static String worseningSymptomsAfter = "default";
    public static String adverseEventsScaleEnteredAfter = "default";
    public static TreatmentEffectModel nyTreatmentEffectReport;
    public static String savedTreatmentEffect = "0";
    public static String durationString = "default"; 
    public static double stimDuration; 
    public static double UConButtonPresses; 
    public static Double effectOfTreatment; 
    public static Double IEmax = 100.0; 
    public static Double noctMax = 30.0;
    public static Double urgeMax = 100.0;
    public static Double freqMax = 50.0;
    public static Double QOLmax = 10.0;


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

    // Metode til at håndtere hvis knap: "Estimate new" trykkes på
    @FXML
    void estimateNewButtonPressed(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    // Metode til at håndtere hvis knap: "go back" trykkes på
    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

        LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
        LoginCtrl.stage.show(); // Vi viser den nye stage
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC200After(ActionEvent event) throws IOException{
        if(bc200After.isSelected()){
            bladderCapacityAfter = "0-200 ml";
            bc300After.setSelected(false);
            bc400After.setSelected(false);
            bc500After.setSelected(false);
            bcOver500After.setSelected(false);
            bcUnknownAfter.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC300After(ActionEvent event) throws IOException{
        if(bc300After.isSelected()){
            bladderCapacityAfter = "200-300 ml";
            bc200After.setSelected(false);
            bc400After.setSelected(false);
            bc500After.setSelected(false);
            bcOver500After.setSelected(false);
            bcUnknownAfter.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC400After(ActionEvent event) throws IOException{
        if(bc400After.isSelected()){
            bladderCapacityAfter = "300-400 ml";
            bc200After.setSelected(false);
            bc300After.setSelected(false);
            bc500After.setSelected(false);
            bcOver500After.setSelected(false);
            bcUnknownAfter.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBC500After(ActionEvent event)throws IOException{
        if(bc500After.isSelected()){
            bladderCapacityAfter = "400-500 ml";
            bc200After.setSelected(false);
            bc300After.setSelected(false);
            bc400After.setSelected(false);
            bcOver500After.setSelected(false);
            bcUnknownAfter.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBCover500After(ActionEvent event) throws IOException{
        if(bcOver500After.isSelected()){
            bladderCapacityAfter = "+500 ml";
            bc200After.setSelected(false);
            bc300After.setSelected(false);
            bc400After.setSelected(false);
            bc500After.setSelected(false);
            bcUnknownAfter.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere bladder capacity check-boxes
    @FXML
    void handleBCunknownAfter(ActionEvent event) throws IOException{
        if(bcUnknownAfter.isSelected()){
            bladderCapacityAfter = "Unknown";
            bc200After.setSelected(false);
            bc300After.setSelected(false);
            bc400After.setSelected(false);
            bc500After.setSelected(false);
            bcOver500After.setSelected(false);
        }
        else {
            bladderCapacityAfter = "default"; 
        }
    }

    // Metode til at håndtere detrusor overaktivitet check-box
    @FXML
    void handleDOnoAfter(ActionEvent event) throws IOException{
        if(DOnoAfter.isSelected()){
            detrusorOveractivityAfter = "No";
            DOyesAfter.setSelected(false);
            DOunknownAfter.setSelected(false);
        }
        else {
            detrusorOveractivityAfter = "default"; 
        }
    }

    // Metode til at håndtere detrusor overaktivitet check-box
    @FXML
    void handleDOunknownAfter(ActionEvent event) throws IOException{
        if(DOunknownAfter.isSelected()){
            detrusorOveractivityAfter = "Unknown";
            DOyesAfter.setSelected(false);
            DOnoAfter.setSelected(false);
        }
        else {
           detrusorOveractivityAfter = "default"; 
       }
    }

    // Metode til at håndtere detrusor overaktivitet check-box
    @FXML
    void handleDOyesAfter(ActionEvent event) throws IOException{
        if(DOyesAfter.isSelected()){
            detrusorOveractivityAfter = "Yes";
            DOnoAfter.setSelected(false);
            DOunknownAfter.setSelected(false);
        }
        else {
            detrusorOveractivityAfter = "default"; 
        }
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
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-30)
    }

    @FXML
    void numberNocturiaDayAfter_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-50)
    }

    @FXML
    void numberUrgeDayAfter_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-100)
    }

    @FXML
    void numberUrinationDayAfter_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes (eksempelvis at input skal være mellem 0-30)
    }

    // Metode til at håndtere adverse event check-box
    @FXML
    void handlePain(ActionEvent event) throws IOException{
        if(painCheckbox.isSelected()){
            painAfter = "Yes";
        }
        else {
            painAfter = "default"; 
        }
    }

     // Metode til at håndtere adverse event check-box
     @FXML
     void handleSkinIrritation(ActionEvent event) throws IOException{
         if(skinIrritationCheckbox.isSelected()){
            skinIrritationAfter = "Yes";
         }
         else {
            skinIrritationAfter = "default"; 
         }
     }

      // Metode til at håndtere adverse event check-box
    @FXML
    void HandleWorseningSymptoms(ActionEvent event) throws IOException{
        if(worseningSymptomsCheckbox.isSelected()){
            worseningSymptomsAfter = "Yes";
        }
        else {
            worseningSymptomsAfter = "default"; 
        }
    }

    @FXML
    void otherAdverseEvents_enter(KeyEvent event) {
        // her kan vi indsætte at input skal tjekkes 
    }


    @FXML
    void patientAge_enter(KeyEvent event) {
        // den her metode kan slettes, hvis vi sætter begrænsning på at man kun kan kommer til denne side, hvis man har oprettet en profil 
    }

    @FXML
    void patientCPR_enter(KeyEvent event) {
        //den her metode kan slettes (se "patientAge_enter")
    }

    @FXML
    void patientGender_enter(KeyEvent event) {
        //den her metode kan slettes (se "patientAge_enter")
    }

    @FXML
    void patientName_enter(KeyEvent event) {
        //den her metode kan slettes (se "patientAge_enter")
    }

    @FXML
    void qolScaleAfter_enter(KeyEvent event) {

    }

    @FXML
    void saveReportButtonPressed(ActionEvent event) throws IOException{
        qolValueEnteredAfter = String.valueOf(qolScaleAfter.getValue());
        adverseEventsScaleEnteredAfter = String.valueOf(adverseEventsScale);
        if(checkInputtedFields()) { //Tjekker at alle felter er udfyldt  
            // hvis alle felter er udfyldt: 
            nyTreatmentEffectReport = saveTreatmentReport(); // gemmer de indtastede informationer
            calculateEffectOfTreatment(); //beregner patientens effectiveness score
            showSavedReportWarning(); // warning der fortæller at informationen er gemt og at man ved at trykkr "ok" kommer tilbage til questionnaire skærmen
             
        }
        else { // Hvis ikke alle felter er udfyldt
            Alert alert7 = new Alert(AlertType.WARNING);
            alert7.setTitle("UDecide - UCon decision support");
            alert7.setHeaderText("There are missing information in the report of treatment effect. Please enter information in all the fields?");
            alert7.setContentText("Please enter the missing information to save the effect report of the treatment.");
            ((Button) alert7.getDialogPane().lookupButton(ButtonType.OK)).setText("Ok");
            alert7.show();
        }
    }

    @FXML
    void viewTreatmentHistoryButtonPressed(ActionEvent event) {
        //Ikke implementeret. 
        //Ved tryk på denne knap, skal en historik over alle tidligere behandlinger vises 
    }


    @FXML
    void initialize()throws IOException {
        assert viewTreatmentHistoryButton != null : "fx:id=\"viewTreatmentHistoryButton\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientName != null : "fx:id=\"patientName\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientCPR != null : "fx:id=\"patientCPR\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientGender != null : "fx:id=\"patientGender\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert patientAge != null : "fx:id=\"patientAge\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentParadigm != null : "fx:id=\"currentParadigm\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentIntensity != null : "fx:id=\"currentIntensity\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentDuration != null : "fx:id=\"currentDuration\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
        assert currentElectrode != null : "fx:id=\"currentElectrode\" was not injected: check your FXML file 'ReportEffectView.fxml'.";
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
        
        //Metoder der opdaterer brugergrænsefladen med information
        updatePatientProfileFields(); // opdaterer felterne til patient profile 
        updateCurrentTreatmentFields(); //opdaterer current treatment informationer på interfacet 
        updateUConData(); 
    }

     // Metode til at opdatere felterne under patient profilen
     public void updatePatientProfileFields() throws IOException {   // hvis patienten allerede er i databasen 
        if (RecommendedTreatmentCtrl.savedTreatment == "1"){
            patientName.setText(QuestionnaireCtrl.nyPatient.getName()); 
            patientCPR.setText(QuestionnaireCtrl.nyPatient.getCprNumber());
            patientGender.setText(QuestionnaireCtrl.nyPatient.getGender());
            patientAge.setText(QuestionnaireCtrl.nyPatient.getAge());
        }
        else { // hvis ikke patienten allerede er i databasen 
            // Hvis vi implementerer at man kun kan komme til denne side, hvis en patient profilen er oprettet, skal der ikke være noget her
        }
    }

    // Metode til at opdatere felterne under current treatment 
    public void updateCurrentTreatmentFields() throws IOException { 
        if (SearchPatientCtrl.registeredPatient.equals("yes") && (RecommendedTreatmentCtrl.savedTreatment == "0")){ // hvis patienten allerede er i databasen 
            // Nedenstående information skal hentes fra databasen (indtastet manuelt lige nu)
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
            //Hvis vi implementerer at det ikke er muligt at komme hertil uden en patient profil som har en eksisterende behandling, så er nedenstående overflødigt
            currentParadigm.setText("The patient has no current paradigm"); 
            currentIntensity.setText("The patient has no current intensity");
            currentDuration.setText("The patient has no current duration");
            currentElectrode.setText("The patient has no current electrode");
        }
    }

    public TreatmentEffectModel saveTreatmentReport() throws IOException { 
        // gemmer de input, som er blevet givet til report effect
        
        TreatmentEffectModel nyTreatmentEffectReport = new TreatmentEffectModel(numberIEdayAfter.getText(), numberUrinationDayAfter.getText(), numberNocturiaDayAfter.getText(), numberUrgeDayAfter.getText(), bladderCapacityAfter, detrusorOveractivityAfter, qolValueEnteredAfter, painAfter, skinIrritationAfter, worseningSymptomsAfter, adverseEventsScaleEnteredAfter, otherAdverseEvents.getText());

        // HER MANGLER DER KODE, SOM KALDER METODE, DER GEMMER "nyTreatmentReport" I DATABASEN
        
        savedTreatmentEffect = "1"; 
        return nyTreatmentEffectReport; 
    }

    public void showSavedReportWarning() throws IOException {
        // Pop-op vidue med warning om at information er gemt og at man kommer tilbage til questionnaire
        Alert alert6 = new Alert(AlertType.CONFIRMATION);
        alert6.setTitle("UDecide - UCon decision support");
        alert6.setHeaderText("The reported effect of the treatment has been saved for: " + QuestionnaireCtrl.nyPatient.getName());
        alert6.setContentText("The effect of the treatment has been estimated to an overall improvement of: " + String.format("%.1f", effectOfTreatment) + "%. When clicking 'Ok', you will return to the questionnaire screen."); 
        ((Button) alert6.getDialogPane().lookupButton(ButtonType.OK)).setText("Ok");
        ((Button) alert6.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");

        Optional<ButtonType> result6 = alert6.showAndWait();
        if (result6.get() == ButtonType.OK) { // Hvis "ok" vælges 
            //Kommer tilbage til Questionnaire screen
            FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
            fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
            final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

            LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
            LoginCtrl.stage.show(); // Vi viser den nye stage
            }
        else { // Hvis "cancel" vælges -> bliver på report effect screen
            System.out.println("Do nothing");
        }
    }

    public boolean checkInputtedFields() throws IOException { //tjekker at der er udfyldt noget i alle felterne inden der kan fortsættes
        if (!numberIEdayAfter.getText().isEmpty() && !numberUrinationDayAfter.getText().isEmpty() && !numberNocturiaDayAfter.getText().isEmpty() && !numberUrgeDayAfter.getText().isEmpty() && bladderCapacityAfter != "default" && detrusorOveractivityAfter != "default" && qolValueEnteredAfter != "default" && adverseEventsScaleEnteredAfter != "default") {
                return true;
            }
            else {
                return false; 
            }
        }

    public void updateUConData() throws IOException {//DENNE METODE MANGLER AT BLIVE TESTET
        //alt nedenstående data, skal hentes fra databasen. 
        UConButtonPresses = 130; 
        numberOfButtonPress.setText(String.valueOf(UConButtonPresses));
        calculateDuration(); //beregner den samlede duration of stimulation & opdaterer brugergrænsefladen 
        meanIntensityLevel.setText("12" + " mA");  
        //graphStimTimeDay; //mangler at skrive kode til opdatering af grafen 
    } 

    public void calculateDuration() throws IOException { 
        durationString = RecommendedTreatmentCtrl.newChosenTreatment.getDuration();

        if(durationString == "60 seconds") {
            stimDuration = 1.0; 
        }
        else if(durationString == "15 minutes") {
            stimDuration = 15.0; 
        }
        else if(durationString == "30 minutes") {
            stimDuration = 30.0;
        }
        else if(durationString == "4 hours") {
            stimDuration = 240.0;
        }
        else {
            stimDuration = 1440.0;
        }

        stimDuration = ((stimDuration*UConButtonPresses)/60);
        //durationString = String.valueOf(stimDuration);
        durationOfStimulation.setText(String.valueOf(stimDuration) + " hours");
        //durationOfStimulation.setText(String.format("%.2f",durationString)+" hours") // + " hours");

        //String.format("%.2f",d))
    }

    public double calculateEffectOfTreatment() throws IOException { 
        effectOfTreatment = (((((Double.valueOf(QuestionnaireCtrl.nyQuestionnaire.getNumberIEday())/IEmax)*1.5)+((Double.valueOf(QuestionnaireCtrl.nyQuestionnaire.getNumberNocturiaDay())/noctMax)*1.3)+((Double.valueOf(QuestionnaireCtrl.nyQuestionnaire.getNumberUrgeDay())/urgeMax)*1.2)+((Double.valueOf(QuestionnaireCtrl.nyQuestionnaire.getNumberUrinationDay())/freqMax))-((Double.valueOf(QuestionnaireCtrl.nyQuestionnaire.getQolscale())/QOLmax)))*100)/6)-(((((Double.valueOf(nyTreatmentEffectReport.getNumberIEdayAfter())/IEmax)*1.5)+((Double.valueOf(nyTreatmentEffectReport.getNumberNocturiaDayAfter())/noctMax)*1.3)+((Double.valueOf(nyTreatmentEffectReport.getNumberUrgeDayAfter())/urgeMax)*1.2)+((Double.valueOf(nyTreatmentEffectReport.getNumberUrinationDayAfter())/freqMax))-((Double.valueOf(nyTreatmentEffectReport.getQolscaleAfter())/QOLmax)))*100)/6);
        System.out.println("The treatment effect is: " + effectOfTreatment);
        return effectOfTreatment;
    }
}
