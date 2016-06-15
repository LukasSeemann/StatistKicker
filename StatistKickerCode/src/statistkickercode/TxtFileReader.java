/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class TxtFileReader {
        
    File file;
    Scanner scan;
    int toreTeam1, toreTeam2;

    public TxtFileReader(){
        readTxtFile();
    }
    
    public File getFile() {
        this.file = new File("C:StatistKicker/StatistKicker.txt");
        return this.file;
    }
    
    public void leseMetaDaten(){
        System.out.println("Lese Metadaten");
    }
    
    public void leseNormal(Zustand zustand, String daten){
        System.out.println("Lese Normal");
        String[] werte = daten.split(",");
        zustand.setBallPosition(new Point(Integer.parseInt(werte[0]), Integer.parseInt(werte[1])));
        System.out.println(zustand.getBallPosition());
        /*
        Point[] stangen = new Point[8];
        for(int i = 0; i <= werte.length; i=i+2){
            stangen[i] = new Point(Integer.parseInt(werte[i+2]), Integer.parseInt(werte[i+3]));
        }
        zustand.setStangePosition(stangen);
        */
    }
    
    /**
     * Diese Methode trägt in einen Zustand ein, wann ein Tor gefallen ist
     * @param zustand der zustand in den eingetragen werden soll
     * @param daten entweder True oder False, je nachdem welches Team ein Tor geschossen hat
     */
    public void leseTor(Zustand zustand, String daten){
        System.out.println("Lese Tor");
        if(daten.startsWith("True")){
            setToreTeam1();
            zustand.setToreTeam1(getToreTeam1());
        }else{
            setToreTeam2();
            zustand.setToreTeam2(getToreTeam2());
        }
    }
    
    public void leseEnde(){
        System.out.println("Lese Ende");
    }
    
    public Spieldaten readTxtFile(){
        try{
            scan = new Scanner(getFile());
            List<Zustand> zustaende = new ArrayList<Zustand>();
            for(int i = 0; scan.hasNext();i++){
                Zustand zustand = new Zustand();
                zustand.setZeitpunkt(i); 
                String line = scan.next();
                if(!(checkLineOk(line))){
                    System.out.println("Datei nicht in Ordnung");
                    break;
                }
                if(line.startsWith("True") || line.startsWith("False")){
                    leseTor(zustand, line);
                }else if(line.startsWith("End")){
                    leseEnde();
                }else if(line.startsWith("Header")){
                    leseMetaDaten();
                }else if(line.startsWith("Werte")){
                    System.out.println("Nun werden die Zustände eingelesen");
                }else{
                    leseNormal(zustand, line);
                }
                zustaende.add(zustand);
            }
            Spieldaten spieldaten = new Spieldaten();
            spieldaten.setSpielverlauf(zustaende);
        }catch(FileNotFoundException fnoe){
                fnoe.printStackTrace();
        }
        return null;
    }
    
    /**
     * Methode liefert True zurück, wenn die Zeile Fehlerwerte enthält
     * @param file
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

}
