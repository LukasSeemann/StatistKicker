/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
/**
 *
 * @author Lukas
 */
public class GUI implements Initializable{
    Spieldaten spieldaten;	
    public Spieldaten getSpieldaten() {
        return spieldaten;
    }

    public void setSpieldaten(Spieldaten spieldaten) {
	this.spieldaten = spieldaten;
    }
    
   
    int z = 0;
    
    @FXML Circle Ball;
    @FXML Text Time;
    @FXML Text S1;
    @FXML Text SG1;
    @FXML Text S2;
    @FXML Text SG2;
    @FXML Text Spielstand;
    @FXML Text Speed;
  
    
    @FXML
    protected void vorButtonPressed() {
        
        z++; 
        //Zustand aktuell = spieldaten.spielverlauf.get(z);
        updateStatistics();
        //updateBall(aktuell);
        Ball.setLayoutX(Ball.getLayoutX()+Math.random()*10);
        Ball.setLayoutY(Ball.getLayoutY()-Math.random()*10);
        Time.setText("Zeitpunkt: "+z);    
    }
    
    @FXML
    protected void zurückButtonPressed() {
        z--; 
        //Zustand aktuell = spieldaten.spielverlauf.get(z);
        updateStatistics();
        //updateBall(aktuell);
        Ball.setLayoutX(Ball.getLayoutX()-Math.random()*10);
        Ball.setLayoutY(Ball.getLayoutY()+Math.random()*10);
        Time.setText("Zeitpunkt: "+z);
        
    }

    
    @FXML
    public void updateBall(Zustand akt){
        Ball.setLayoutX(akt.ballPosition.getX());
        Ball.setLayoutY(akt.ballPosition.getY());
    }
    public void updateStatistics(){
         S1.setText(""+z);
         //S1.setText(""+spieldaten.statGen.getAnzahlSchuesse(false, z));
         SG1.setText(""+z);
         S2.setText(""+z);
         //S2.setText(""+spieldaten.statGen.getAnzahlSchuesse(true, z));
         SG2.setText(""+z);
         //Spielstand.setText(""+spieldaten.statGen.getSpielstand(z));
         Spielstand.setText("1 - 1");
         //Speed.setText(""+spieldaten.statGen.getBallgeschwindigkeit(z));
         Speed.setText("" + (z+3.24));
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}