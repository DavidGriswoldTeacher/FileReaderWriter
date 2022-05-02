/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filereaderwriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;


/**
 *
 * @author novac
 */
public class FileReaderWriter {
    
    String filename="list.txt";
    FileReaderWriterWindow window = new FileReaderWriterWindow();
    
    public void start() {
        window.setController(this);
        // try to open the file for reading
        refreshText();
        window.setVisible(true);
    }
    
    void refreshText() {
        String fileText = readFileToLines(filename);
        window.setTextValue(fileText);
    }
    
    void save(String text) {
        writeTextToFile(text, filename);
    }
    
    public String readFileToLines(String filename) {
        String result = "";
        try {
           Path p = Paths.get(filename);
           result = Files.readString(p);
        }catch(IOException e) {
            result = "File not found";
        }
        return result;
    }
    
    public void writeTextToFile(String text, String filename) {
        try {
          Path p = Paths.get(filename);
          Files.writeString(p, text);
        }catch(IOException e) {
            System.out.println("Error writing file");
        }
    }
    
    public static void main(String[] args) {
        FileReaderWriter controller = new FileReaderWriter();
        controller.start();
    }


    
}
