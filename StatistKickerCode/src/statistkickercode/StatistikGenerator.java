/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

/**
 *
 * @author Leonhard Applis
 */
public class StatistikGenerator {
    
    private Spieldaten daten;
    
    public StatistikGenerator(Spieldaten daten){
        this.daten=daten;
    }
    
    public int[][] generateHeatmap(){
        //eine Int Matrix wird erstellt, die das Feld in 20 auf 40 Felderzerteilt
        int [][] heatmap=new int[20][40];
        //die IntMatrix wird leer initialisiert
        for(int a=0; a<20;a++){
            for(int b=0; b<40 ; b++){
                heatmap[a][b]=0;
            }
        }
        //Die Zustandsliste wird ausgequetscht und geschaut, in welchem Bereich es liegt
        for(Zustand i : daten.spielverlauf){
            int merkeX=(int)(i.getBallPosition().getX()/40);
            int merkeY=(int)(i.getBallPosition().getY()/20);
            heatmap[merkeY][merkeX]=heatmap[merkeY][merkeX]+1;
        }
        
        return heatmap;
    }
    
    public void generateSchusslinie(){
        
    }
    
    //Die Geschwindigkeit wird daruch gemessen, dass wir den Punkt vor unserem Zeitpunkt und den Punkt nach unserem Zeitpunkt betrachten,
    //Die Distanz ausrechnen die er zurückgelegt hat und durch die anzahl der gemessenen Zeiteinheiten (2) teilen.
    public double geschwindigkeit(int zeitpunkt){
        if(zeitpunkt > 1 && zeitpunkt <daten.getSpielverlauf().size()){
            return (double)(daten.spielverlauf.get(zeitpunkt-1).getBallPosition().distanceSq(daten.spielverlauf.get(zeitpunkt).getBallPosition())/2);
        }
        return 0;
    }
    
    //Die Beschleunigung errechnet sich ebenfalls durch zwei Aufeinanderfolgende Punkte, es wird betrachtet wie sehr sich die
    //Geschwindigkeiten verändern. 
    public double beschleunigung(int zeitpunkt){
        double gesch1=geschwindigkeit(zeitpunkt-1);
        double gesch2=geschwindigkeit(zeitpunkt+1);
        
        //wir decken insgesamt 4 Sekunden ab, daher muss die Änderung der Geschwindigkeiten durch 4 geteilt werden. 
        return Math.abs(gesch2-gesch1)/4;       
    }
    
    // gibt die gesamte durchschnittliche Geschwindigkeit über das Spiel aus
    public double avgGeschwindigkeit(){
        double max=0;
        
        for(int i=0;i<daten.getSpielverlauf().size();i++){
            max+=geschwindigkeit(i);
        }
        return(max/daten.getSpielverlauf().size());       
    }
}
