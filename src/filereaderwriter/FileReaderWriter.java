/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filereaderwriter;

import java.io.*;
import java.nio.file.*;

public class FileReaderWriter {
    
    String filename="list.txt";
    FileReaderWriterWindow window = new FileReaderWriterWindow();
    
    /**
     * This is basically my model - a simple array of lines
     */
    String [] allLines;
    
    /**
     * Initializes the program
     */
    public void start() {
        window.setController(this);
        refreshText();
        window.setVisible(true);
    }
    
    /**
     * Reads the text from the file and updates the view
     */
    void refreshText() {
        String fileText = readFileToString(filename);
        // Create an array by splitting the string at every new line
        allLines = fileText.split("\n");
        window.setTextValue(fileText);
    }
    
    /**
     * Saves the text typed by the user into the array
     * and then updates the model
     * @param text 
     */
    void save(String text) {
        allLines = text.split("\n");
        writeTextToFile(text, filename);
    }
    
    /**
     * Read the file and return an array of strings that represents the lines
     * @param filename
     * @return 
     */
    public String readFileToString(String filename) {
        String s;
        try {
           // create a Path object from the filename
           Path p = Paths.get(filename);
           // the readString method reads in the whole file as one string
           s = Files.readString(p);

        }catch(IOException e) {
            s = "File not found";
        }
        return s;
    }
    
    /**
     * Writes a string to a file, overwriting whatever was there
     * @param text
     * @param filename 
     */
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
