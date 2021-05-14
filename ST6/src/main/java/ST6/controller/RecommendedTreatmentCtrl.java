package ST6.controller;
import ST6.App;
import ST6.handler.PatientProfileHandler;
import ST6.model.PatientProfileModel;
import ST6.model.RecommendedTreatmentModel;
import ST6.controller.*;
import ST6.model.*;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.net.URL;
import java.util.ResourceBundle;

import org.w3c.dom.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class RecommendedTreatmentCtrl extends Algorithm{

    public String preferElectrode; // variabel der fortæller om der er valgt ønske til elektrode via checkbox
    public String chosenTreatment; // variabel der fortæller hvilken treatment der er valgt via checkbox
    public static String savedTreatment = "0"; 
    public static RecommendedTreatmentModel newChosenTreatment;

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
    private TextField stimulationParadigm3;

    @FXML
    private TextField stimulationParadigm2;

    @FXML
    private TextField stimulationParadigm1;

    @FXML
    private TextField eScore3;

    @FXML
    private TextField eScore2;

    @FXML
    private TextField eScore1;

    @FXML
    private Button goBackButton;

    @FXML
    private Button logOutButton;

    @FXML
    void goBackButtonPressed(ActionEvent event) throws IOException { //trukkes der på tilbage, vises questionnaire
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }

    @FXML
    void handleChooseTreatment1(ActionEvent event) throws IOException{ //håndterer checkbox til valg af treatment1
        if(chooseTreatment1.isSelected()){
            chosenTreatment = "Treatment1";
            chooseTreatment2.setSelected(false);
            chooseTreatment3.setSelected(false);
        }
        else {
            chosenTreatment = "default"; 
        }
    }

    @FXML
    void handleChooseTreatment2(ActionEvent event) throws IOException{ //håndterer checkbox til valg af treatment2
        if(chooseTreatment2.isSelected()){
            chosenTreatment = "Treatment2";
            chooseTreatment1.setSelected(false);
            chooseTreatment3.setSelected(false);
        }
        else {
            chosenTreatment = "default"; 
        }
    }

    @FXML
    void handleChooseTreatment3(ActionEvent event) throws IOException{ //håndterer checkbox til valg af treatment3
        if(chooseTreatment3.isSelected()){
            chosenTreatment = "Treatment3";
            chooseTreatment1.setSelected(false);
            chooseTreatment2.setSelected(false);
        }
        else {
            chosenTreatment = "default"; 
        }
    }

    @FXML
    void handlePreferPercutaneous(ActionEvent event) throws IOException{ //håndterer checkbox til valg af elektrode
        if(preferPercutaneous.isSelected()){
            preferElectrode = "Percutaneous";
            preferSurface.setSelected(false);
        }
        else {
            preferElectrode = "default"; 
        }
    }

    @FXML
    void handlePreferSurface(ActionEvent event) throws IOException{ //håndterer checkbox til valg af elektrode
        if(preferSurface.isSelected()){
            preferElectrode = "Surface";
            preferPercutaneous.setSelected(false);
        }
        else {
            preferElectrode = "default"; 
        }
    }

    @FXML
    void logOutButtonPressed(ActionEvent event)throws IOException { //trukkes der på log ud, vises login skærmen
        FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
        fxmlloader.setLocation(getClass().getResource("/LoginView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
        final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise
        
        LoginCtrl.stage.setScene(new Scene(root));//Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = RecommendedTreatment view)
        LoginCtrl.stage.show(); //Vi viser den nye stage
    }


    @FXML
    void reportEffectButtonPressed(ActionEvent event) {
        // ved ikke helt om den her knap skal være en mulighed når man står på recommended treatment page
    }

    @FXML
    void saveButtonPressed(ActionEvent event) throws IOException { //trukkes der på gem knappen, gemmes valgt treatment og questionnaire skærmen vises
        // Her mangler der kode, som gemmer den valgte treatment 
        // gem info i en "recommendedTreatmentModel"
        newChosenTreatment = saveChosenTreatment();
        showSaveWarning(); 
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
        assert currentElectrode != null : "fx:id=\"currentElectrode\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert reportEffectButton != null : "fx:id=\"reportEffectButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
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
        assert stimulationParadigm3 != null : "fx:id=\"stimulationParadigm3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert stimulationParadigm2 != null : "fx:id=\"stimulationParadigm2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert stimulationParadigm1 != null : "fx:id=\"stimulationParadigm1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert eScore3 != null : "fx:id=\"eScore3\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert eScore2 != null : "fx:id=\"eScore2\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert eScore1 != null : "fx:id=\"eScore1\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert goBackButton != null : "fx:id=\"goBackButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'RecommendedTreatmentView.fxml'.";

        //Metoder der kører algoritme på baggrund af input data til brugergrænsefladen:
        runAlgorithm(); //kører grupperings-algoritmen 
        recommendedTreatments(patientGroup); //kører recommended treatment algoritme med patientgruppe som input 

        //Metoder der opdaterer brugergrænsefladen med information
        updatePatientProfileFields(); // opdaterer felterne til patient profile 
        updateCurrentTreatmentFields(); // opdaterer felterne til current treatment 
        updateRecommendedTreatments(); // opdaterer felterne til recommended treatments
    }

    public String runAlgorithm() throws IOException {
        ageGroup = getAgeGroup(QuestionnaireCtrl.nyPatient.getAge()); 
        if (ageGroup.equals("old")){ 
            //getPatientGroupOld(numberIEday, numberUrinationDay, numberNocturiaDay) <-- input parametre 
            patientGroup = getPatientGroupOld(QuestionnaireCtrl.nyQuestionnaire.getNumberIEday(), QuestionnaireCtrl.nyQuestionnaire.getNumberUrinationDay(), QuestionnaireCtrl.nyQuestionnaire.getNumberNocturiaDay());
            return patientGroup; 
        }
        else { 
            patientGroup = getPatientGroupYoung(QuestionnaireCtrl.nyQuestionnaire.getNumberIEday(), QuestionnaireCtrl.nyQuestionnaire.getNumberUrinationDay(), QuestionnaireCtrl.nyQuestionnaire.getNumberNocturiaDay());
            return patientGroup; 
        }
    }
    
    public void updatePatientProfileFields() throws IOException {   
        patientName.setText(QuestionnaireCtrl.nyPatient.getName()); 
        patientCPR.setText(QuestionnaireCtrl.nyPatient.getCprNumber());
        patientGender.setText(QuestionnaireCtrl.nyPatient.getGender());
        patientAge.setText(QuestionnaireCtrl.nyPatient.getAge()); 
    }

      // Metode til at opdatere felterne under current treatment 
      public void updateCurrentTreatmentFields() throws IOException { 
      if (SearchPatientCtrl.registeredPatient.equals("yes")){ // hvis patienten allerede er i databasen 
          // Nedenstående information skal hentes fra databasen (lige nu indtastet manuelt)
          currentParadigm.setText("On-Demand"); // 
          currentIntensity.setText("15 mA");
          currentDuration.setText("15 minutes");
          currentElectrode.setText("Surface");
      }
      else { // hvis ikke patienten har en tidligere behandling i databasen
          currentParadigm.setText("The patient has no current paradigm"); 
          currentIntensity.setText("The patient has no current intensity");
          currentDuration.setText("The patient has no current duration");
          currentElectrode.setText("The patient has no current electrode");
        }
    }

    public void updateRecommendedTreatments() throws IOException {
        updateRecommendedTreatment1(); 
        updateRecommendedTreatment2(); 
        updateRecommendedTreatment3(); 
    }

    public void updateRecommendedTreatment1() throws IOException {
        stimulationParadigm1.setText(paradigm1 + " - " + electrodeType1);
        effectScore1.setProgress(effectivenessScore1/100);
        eScore1.setText("Effectiveness score: " + String.valueOf(effectivenessScore1)+"% ");
        treatmentInfo1.setWrapText(true);
        treatmentInfo1.setText(info1);
    }
    public void updateRecommendedTreatment2() throws IOException {
        stimulationParadigm2.setText(paradigm2 + " - " + electrodeType2);
        effectScore2.setProgress(effectivenessScore2/100);
        eScore2.setText("Effectiveness score: " + String.valueOf(effectivenessScore2)+"%  ");
        treatmentInfo2.setWrapText(true);
        treatmentInfo2.setText(info2);
    }
    public void updateRecommendedTreatment3() throws IOException {
        stimulationParadigm3.setText(paradigm3 + " - " + electrodeType3);
        effectScore3.setProgress(effectivenessScore3/100);
        eScore3.setText("Effectiveness score: " + String.valueOf(effectivenessScore3)+"%  ");
        treatmentInfo3.setWrapText(true);
        treatmentInfo3.setText(info3);
    }
    
    public RecommendedTreatmentModel saveChosenTreatment() throws IOException {
        if(chooseTreatment1.isSelected()){
            RecommendedTreatmentModel newChosenTreatment = new RecommendedTreatmentModel(paradigm1, duration1, electrodeType1, "No recommendation");
            savedTreatment = "1";
            return newChosenTreatment;
        }
        else if(chooseTreatment2.isSelected()){
            RecommendedTreatmentModel newChosenTreatment = new RecommendedTreatmentModel(paradigm2, duration2, electrodeType2, "No recommendation");
            savedTreatment = "1";
            return newChosenTreatment;
        } 
        else if(chooseTreatment1.isSelected()){
            RecommendedTreatmentModel newChosenTreatment = new RecommendedTreatmentModel(paradigm3, duration3, electrodeType3, "No recommendation");
            savedTreatment = "1";
            return newChosenTreatment;
        }
        else {
            // giv advarsel om at én behandling skal vælges 
            RecommendedTreatmentModel newChosenTreatment = new RecommendedTreatmentModel("No recommendation", "No recommendation", "No recommendation", "No recommendation");
            savedTreatment = "0";
            return newChosenTreatment;
        }
    }

    public void showSaveWarning() throws IOException {
        // Pop-op vidue med warning om at information er gemt og at man kommer tilbage til questionnaire
        Alert alert5 = new Alert(AlertType.CONFIRMATION);
        alert5.setTitle("UDecide - UCon decision support");
        alert5.setHeaderText("The chosen treatment have been saved for: " + QuestionnaireCtrl.nyPatient.getName());
        alert5.setContentText("When clicking 'Ok', you will return to the questionnaire screen.");
        ((Button) alert5.getDialogPane().lookupButton(ButtonType.OK)).setText("Ok");
        ((Button) alert5.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");

        Optional<ButtonType> result5 = alert5.showAndWait();
            if (result5.get() == ButtonType.OK) { // Hvis "ok" vælges
            //Loader og viser nyt view (questionnaire): 
            FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader instantieres - skal bruges til at hente viewet
            fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml")); // definerer stie til fxml filen som ligger under "Resources"
            final Parent root = fxmlloader.load(); // Loader (henter) fxml filen, som indeholdet det view vi gerne vil vise

            LoginCtrl.stage.setScene(new Scene(root)); //Sætter scenen "ovenpå" vores stage (stage = stage defineret i LoginCtrl) (scenen = root = Questionnaire view)
            LoginCtrl.stage.show(); // Vi viser den nye stage
            }
            else { 
                System.out.println("Do nothing");
            }
    }
    
}