/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lukas, Torben
 */
public class TxtFileReader {
    int toreTeam1, toreTeam2;
    Stange[] stangePosition;
    Point ballPosition;

    public TxtFileReader(){
        readTxtFile();
    }
    
    /**
     * Liest die Datei Zeile für Zeile ein und ruft andere Methoden auf um ein Spielstandsobjekt zu erstellen
     * @return 
     */
    public Spieldaten readTxtFile(){
        try{
            Scanner scan = new Scanner(new File("C:StatistKicker/StatistKicker.txt"));
            List<Zustand> zustaende = new ArrayList<>();
            for(int i = 0; scan.hasNext();i++){
                String line = scan.next();
                // Prüfung Zeile ok?
                if(!(checkLineOk(line))){
                    System.out.println("Datei nicht in Ordnung");
                    break;
                }
                // Unterscheidung der einzelnen Fälle
                if(line.startsWith("True") || line.startsWith("False")){
                    leseTor(line);
                }else if(line.startsWith("End")){
                    leseEnde();
                    continue;
                }else if(line.startsWith("Header")){
                    leseMetaDaten();
                    continue;
                }else if(line.startsWith("Werte")){
                    System.out.println("Nun werden die Zustände eingelesen");
                    continue;
                }else{
                    leseNormal(line);
                }
                Zustand zustand = new Zustand();
                zustand.setZeitpunkt(i);
                zustand.setBallPosition(getBallPosition());
                zustand.setStangePosition(getStangePosition());
                zustand.setToreTeam1(getToreTeam1());
                zustand.setToreTeam2(getToreTeam2());
                zustaende.add(zustand);
            }
            // Testlauf
            for(int i = 0; i<zustaende.size(); i++){
                System.out.println(
                "Ballposition: " + zustaende.get(i).getStangePosition() +" Tore Team 1: "+
                zustaende.get(i).getToreTeam1()+" Tore Team 2: "+
                zustaende.get(i).getToreTeam2()+" Zeitpunkt: "+
                zustaende.get(i).getZeitpunkt()+" Stangenpositionen: "+
                zustaende.get(i).getStangePosition()
                );    
            }
            Spieldaten spieldaten = new Spieldaten();
            spieldaten.setSpielverlauf(zustaende);
        }catch(FileNotFoundException fnoe){
                fnoe.printStackTrace();
        }
        return null;
    }
    
    /**
     * Diese Methode soll in Zukunft Daten wie die Zeitabstände der Ballpositionen annehmen können
     */
    public void leseMetaDaten(){
        System.out.println("Lese Metadaten");
    }
    
    /**
     * Diese Methode liest eine Zeile ein und speichert sowohl Ball- als auch Stangenposition in einen Zustand
     * @param zustand
     * @param daten 
     */
    public void leseNormal(String daten){
        daten = daten.replace(";", "");
        String[] werte = daten.split(",");
        // Einlesen der Ballposition
        setBallPosition(new Point(Integer.parseInt(werte[0]), Integer.parseInt(werte[1])));
        
        // Einlesen der Stangenposition
        Stange[] stangen = new Stange[8];
        int stangenCounter = 0;
        for(int i = 2; i < werte.length; i = i+2){
            stangen[stangenCounter] = new Stange();
            stangen[stangenCounter].setPosition(Integer.parseInt(werte[i]));
            stangen[stangenCounter].setWinkel(Float.parseFloat(werte[i+1]));
            stangenCounter++;
        }
        setStangePosition(stangen);
    }
    
    /**
     * Diese Methode trägt in einen Zustand ein, wann ein Tor gefallen ist
     * @param zustand der zustand in den eingetragen werden soll
     * @param daten entweder True oder False, je nachdem welches Team ein Tor geschossen hat
     */
    public void leseTor(String daten){
        if(daten.startsWith("True")){
            setToreTeam1();    
        }else{
            setToreTeam2();
        }
    }
    
    public void leseEnde(){
        System.out.println("Lese Ende");
    }
    
    /**
     * Methode liefert True zurück, wenn die Zeile Fehlerwerte enthält
     * @param line
     * @return 
     */
    public boolean checkLineOk(String line){
        if(line.startsWith("-1")){
            return false;
        }
        return true;
    }
    
    // Getter und Setter
    public int getToreTeam1() {
        return toreTeam1;
    }

    public void setToreTeam1() {
        this.toreTeam1++;
    }

    public int getToreTeam2() {
        return toreTeam2;
    }

    public void setToreTeam2() {
        this.toreTeam2++;
    }
    
    public Stange[] getStangePosition() {
        return stangePosition;
    }

    public void setStangePosition(Stange[] stangePosition) {
        this.stangePosition = stangePosition;
    }

    public Point getBallPosition() {
        return ballPosition;
    }

    public void setBallPosition(Point ballPosition) {
        this.ballPosition = ballPosition;
    }

}
