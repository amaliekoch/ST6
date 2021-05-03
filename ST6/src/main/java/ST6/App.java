
package ST6;
import ST6.controller.LoginCtrl;
import ST6.controller.QuestionnaireCtrl;
import ST6.database.DatabaseManipulator;
import ST6.model.PatientProfileModel;
import ST6.handler.PatientProfileHandler;
import ST6.controller.SearchPatientCtrl;

//IMPORT DER BRUGES TIL SCENEBUILDER 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {
    
    public static Stage primaryStage; // definerer primaryStage
 
     @Override
     public void start(Stage primaryStage) throws Exception{
        App.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/LoginView.fxml")); // Loader Login view via fxml filen som ligger under "Resources"
        primaryStage.setTitle("UDecide - Ucon decision support - Login screen"); // Sætter titel på "vinduet" som vises
        primaryStage.setScene(new Scene(root, 900, 900)); //definerer størrelsen på vinduet og sætter scenen (scenen = root = Login view) 
        showLoginView(); //kalder metoder "showLoginView" som viser vinduet. 
        }
 
     public void showLoginView() { // metoden viser vinduet
        primaryStage.show(); 

     }

     public static void closeWindow() { // metoden lukker vinduet 
         primaryStage.close(); 
     }
 
    public static void main(String[] args) {
        launch(args);

        //DatabaseManipulator.getConnection(); 
        //PatientProfileModel.getPatientProfiledata("1002199902"); <-- Hanne Hansen
        //PatientProfileModel.getPatientProfiledata("1304081203"); // <-- Viggo Viggosen 
        //System.out.println(PatientProfileHandler.patientCPR); // Test - printer cpr i terminalen
        //System.out.println(PatientProfileHandler.patientName); // Test - printer navn i terminalen
        //System.out.println(PatientProfileHandler.patientAge); //Test - printer alder i terminalen
        //System.out.println(PatientProfileHandler.patientGender); //Test - printer køn i terminalen
    }
}
