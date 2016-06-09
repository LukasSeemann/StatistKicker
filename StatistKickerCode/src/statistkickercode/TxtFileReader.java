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
    int toreTeam1, toreTeam2;

    public TxtFileReader(){
        readTxtFile();
    }
    
    public File getFile() {
        this.file = new File("C:StatistKicker/StatistKicker.txt");
        return this.file;
    }
    
    public void leseMetaDaten(){
        
    }
    
    public void leseNormal(Zustand zustand, String daten){
        System.out.println("Lese Normal");
        String[] werte = daten.split(",");
        zustand.setBallPosition(new Point(Integer.parseInt(werte[0]), Integer.parseInt(werte[1])));
        System.out.println(zustand.getBallPosition());
        for(int i = 2; i <= werte.length; i++){
            if(i%2 == 0){
                
            }else{
                
            }
        }
    }
    
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
            Scanner scan = new Scanner(getFile());
            List<Zustand> zustaende = new ArrayList<Zustand>();
            for(int i = 0; scan.hasNext();i++){
                Zustand zustand = new Zustand();
                zustand.setZeitpunkt(i); // Hier wird beim Zeitpunkt 0 begonne !!
                String test = scan.next();
                if(test.startsWith("True") || test.startsWith("false")){
                    leseTor(zustand, test);
                }else if(test.startsWith("End")){
                    leseEnde();
                }else if(test.startsWith("Header")){
                    leseMetaDaten();
                }else if(test.startsWith("Werte")){
                    
                }else{
                    leseNormal(zustand, test);
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
    
    public boolean check(File file){
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
