package main.java.ST6.controller;

import java.net.URL;
import java.util.ResourceBundle;
import ST6.model.PatientProfileModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import main.java.ST6.handler.PatientProfileHandler;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class SearchPatientCtrl {

    private String cprNumber;
    private Stage dialogStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cprTextfield;

    @FXML
    private Button SearchButton;

    @FXML
    void MaxTextField(KeyEvent event) {

        final int maxLength = 10;

        cprTextfield.setOnKeyTyped(t -> {

            if (cprTextfield.getText().length() > maxLength) {
                int pos = cprTextfield.getCaretPosition();
                cprTextfield.setText(cprTextfield.getText(0, maxLength));
                cprTextfield.positionCaret(pos); // To reposition caret since setText sets it at the beginning by default
            }
        });
    }

    @FXML
    void SearchPressed(ActionEvent event) throws IOException {
            checkCPR();
    }

    @FXML
    void Search_enter(KeyEvent event) throws IOException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            checkCPR();
        }
    }

    @FXML
    void initialize() {
        assert cprTextfield != null : "fx:id=\"cprTextfield\" was not injected: check your FXML file 'SearchPatientView.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'SearchPatientView.fxml'.";

    }

    public void showSearchView() throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/LoginView1.fxml")); 
        Parent root1 = (Parent) fxmlloader.load(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setTitle("UCon");
    }

    void checkCPR() throws IOException {
        PatientProfileModel.setCprNumber(cprTextfield.getText());
        PatientProfileModel.getPatientProfiledata(cprNumber);
        if (!PatientProfileHandler.patientName.equals("fejl")) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("UDecide - Ucon decision support");
            alert.setHeaderText("Den kommende side viser oplysninger om: " + PatientProfileHandler.patientName + "                                             ");
            alert.setContentText("Ved at trykke 'Godkend' bekraefter du, at du har samtykke fra patienten, og at det er den rigtige patient.");
            ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Godkend");
            ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Annuller");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                FXMLLoader fxmlloader = new FXMLLoader(); // Ny loader som henter "QuestionnaireView"
                fxmlloader.setLocation(getClass().getResource("/QuestionnaireView.fxml"));
                // Parent root1 = (Parent) fxmlloader.load();
                final Parent root = fxmlloader.load();

                Stage stage = new Stage(); // Vi laver en ny stage
                stage.setScene(new Scene(root));
                stage.show(); // Vi viser den nye stage
                stage.setTitle("UDecide - Ucon decision support");

                cprTextfield.clear(); // Clear cpr nummeret efter der er klikket ok

            } else {
                // ... user chose CANCEL or closed the dialog
                PatientProfileHandler.patientName = "fejl";
                cprTextfield.clear(); // clear cpr nummeret hvis det er den forkerte patient
            }
        } else {
            // forkert format grundet tegn og/eller bogstaver
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Ugyldigt CPR-nummer");
            alert.setHeaderText("CPR-nummeret skal have 10 cifre.");
            alert.setContentText("CPR-nummeret skal have formatet 10 cifre.\nIngen bogstaver, tegn eller mellemrum. ");
            alert.showAndWait();

        }

    }
}
