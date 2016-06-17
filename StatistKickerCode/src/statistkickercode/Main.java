/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lukas
 */
 
public class Main extends Application{
 
      public static void main(String[] args) {
             launch(args);
             
          }

    @Override
    public void start(Stage primaryStage) throws Exception {
         // +++++++++++++++++++++++++++++++++++++++++++++
        // Layout
        // +++++++++++++++++++++++++++++++++++++++++++++
              
        // FXML-Datei laden!
        Parent root = FXMLLoader.load(getClass().getResource("GUI_fxml.fxml"));
               
        // Szene
        Scene scene = new Scene(root);
             
        // +++++++++++++++++++++++++++++++++++++++++++++
        // Stage konfigurieren
        // +++++++++++++++++++++++++++++++++++++++++++++
 
        // Titel setzen
        primaryStage.setTitle("StatistKicker - Programm");
             
        // Szene setzen
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
             
        // Stage anzeigen
        primaryStage.show();
        
    }
    
          
}
