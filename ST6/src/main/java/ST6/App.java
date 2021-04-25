
package ST6;

import ST6.database.DatabaseManipulator;
import ST6.model.PatientProfileModel;
import main.java.ST6.handler.PatientProfileHandler;

/*
SKAL BRUGES TIL CONNECTION MED SCENEBUILDER 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
*/

//public class App extends Application {
public class App {

    public static void main(String[] args) {
        //launch(args);
        DatabaseManipulator.getConnection();
        //PatientProfileModel.getPatientProfiledata("1002199902"); <-- Hanne Hansen
        PatientProfileModel.getPatientProfiledata("1304081203"); // <-- Viggo Viggosen 
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientCPR); // Test - printer cpr i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientName); // Test - printer navn i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientAge); //Test - printer alder i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientGender); //Test - printer køn i terminalen
    }
}
