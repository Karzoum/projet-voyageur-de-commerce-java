package GestionnaireDeFichier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MonFichier {
    
    public void append(String filename, String text,boolean placement) {
        BufferedWriter bufWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename, placement);
            bufWriter = new BufferedWriter(fileWriter);
            //Ins�rer un saut de ligne
            bufWriter.newLine();
            bufWriter.write(text);
            bufWriter.close();
        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            try {
                bufWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
               ex.getStackTrace();
            }
        }
    }  
}
