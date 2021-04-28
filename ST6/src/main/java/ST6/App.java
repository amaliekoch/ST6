
package ST6;

import ST6.controller.LoginCtrl;
import ST6.database.DatabaseManipulator;
import ST6.model.PatientProfileModel;
import ST6.handler.PatientProfileHandler;
import ST6.controller.SearchPatientCtrl;


//SKAL BRUGES TIL CONNECTION MED SCENEBUILDER 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {
    
    public static Stage primaryStage;
    // public BorderPane rootLayout;
 
     @Override
     public void start(Stage primaryStage) throws Exception{
         App.primaryStage = primaryStage;
         Parent root = FXMLLoader.load(getClass().getResource("/LoginView.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 900, 900));

        /*
        Parent secondView = FXMLLoader.load(getClass().getResource("/SearchPatientView1.fxml"));
        primaryStage.setTitle("Search Patient");
        primaryStage.setScene(new Scene(root, 300, 275));
*/


            
         //App.primaryStage.setTitle("UDecide - Ucon decision support");
        
         showLoginView();
     }
 
     public void showLoginView() {
        primaryStage.show();

         //try {
            
                

            //FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));


             /*
             // Load View()
             FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
             Parent firstPane = firstPaneLoader.load();
             Scene firstScene = new Scene(firstPane, 300, 275);

             FXMLLoader secondPaneLoader = new FXMLLoader(getClass().getResource("/SearchPatientView1.fxml"));
             Parent secondPane = secondPaneLoader.load();
             Scene secondScene = new Scene(secondPane, 300, 275);

             LoginCtrl firstPaneController = (LoginCtrl) firstPaneLoader.getController();
             firstPaneController.setSecondScene(secondScene);
             
             SearchPatientCtrl secondPaneController = (SearchPatientCtrl) secondPaneLoader.getController();
             secondPaneController.setFirstScene(firstScene);

             primaryStage.setScene(firstScene);
             primaryStage.show();
             

             loader.setLocation(App.class.getResource("/LoginView.fxml"));
             AnchorPane LoginView = (AnchorPane) loader.load();
             
            // Show the scene containing the root layout.
             Scene sceneLoginView = new Scene(LoginView);
             primaryStage.setScene(sceneLoginView);
             primaryStage.show();
             
                    
         } catch (IOException e) {
             
             e.printStackTrace();
         }  

         */
     }

 
     public static void closeWindow() {
         primaryStage.close();
     }
 
    public static void main(String[] args) {
        launch(args);

        DatabaseManipulator.getConnection();
        //PatientProfileModel.getPatientProfiledata("1002199902"); <-- Hanne Hansen
        PatientProfileModel.getPatientProfiledata("1304081203"); // <-- Viggo Viggosen 
        //System.out.println(PatientProfileHandler.patientCPR); // Test - printer cpr i terminalen
        //System.out.println(PatientProfileHandler.patientName); // Test - printer navn i terminalen
        //System.out.println(PatientProfileHandler.patientAge); //Test - printer alder i terminalen
        //System.out.println(PatientProfileHandler.patientGender); //Test - printer køn i terminalen
    }
}
