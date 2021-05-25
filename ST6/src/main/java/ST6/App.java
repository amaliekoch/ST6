
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
        primaryStage.setScene(new Scene(root, 1000, 1000)); //definerer størrelsen på vinduet og sætter scenen (scenen = root = Login view) 
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
    }
}
