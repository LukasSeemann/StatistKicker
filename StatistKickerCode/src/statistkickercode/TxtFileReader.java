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

    public TxtFileReader(){
        readTxtFile();
    }
    
    public File getFile() {
        this.file = new File("C:StatistKicker/StatistKicker.txt");
        return this.file;
    }
    
    public void leseMetaDaten(){
        System.out.println("Lese MetaDaten");
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
            zustand.setToreTeam1(1);
        }else{
            zustand.setToreTeam2(1);
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
        }catch(FileNotFoundException fnoe){
                fnoe.printStackTrace();
        }
        return null;
    }
    
    public boolean check(){
        return true;
    }
    
}
