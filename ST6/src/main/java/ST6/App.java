
package ST6;

import ST6.database.DatabaseManipulator;
import ST6.model.PatientProfileModel;
import main.java.ST6.handler.PatientProfileHandler;


//SKAL BRUGES TIL CONNECTION MED SCENEBUILDER 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
//public class App {
   
    private static Stage primaryStage;
    // public BorderPane rootLayout;
 
     @Override
     public void start(Stage primaryStage) {
         App.primaryStage = primaryStage;
         App.primaryStage.setTitle("UDecide - Ucon decision support");
 
         showLoginView();
     
     }
 
     public void showLoginView() {
         try {
             
             // Load View
             FXMLLoader loader = new FXMLLoader();
             
             loader.setLocation(App.class.getResource("/LoginView.fxml"));
             AnchorPane LoginView = (AnchorPane) loader.load();
             
             // Show the scene containing the root layout.
             Scene sceneLoginView = new Scene(LoginView);
             primaryStage.setScene(sceneLoginView);
             primaryStage.show();
             
                       
         } catch (IOException e) {
             
             e.printStackTrace();
         }   
         
     }
 
     public static void closeWindow() {
         primaryStage.close();
     }
 
    public static void main(String[] args) {
        launch(args);
        DatabaseManipulator.getConnection();
        //PatientProfileModel.getPatientProfiledata("1002199902"); <-- Hanne Hansen
        PatientProfileModel.getPatientProfiledata("1304081203"); // <-- Viggo Viggosen 
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientCPR); // Test - printer cpr i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientName); // Test - printer navn i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientAge); //Test - printer alder i terminalen
        System.out.println(main.java.ST6.handler.PatientProfileHandler.patientGender); //Test - printer køn i terminalen
    }
}
