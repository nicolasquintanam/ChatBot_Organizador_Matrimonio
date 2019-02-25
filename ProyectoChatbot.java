/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import proyectochatbot.views.ChatbotCommandLine;

/**
 *
 * @author Nicolás Quintana
 */
public class ProyectoChatbot {

    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String[] args) throws IOException {
        //muestraContenido("/Users/nicolasquintanam/desktop/ChatbotGuardado(18.00.41 10-08-2018).txt");
        
        
        System.out.println("Hello World!");
        
        ChatbotCommandLine vista = new ChatbotCommandLine();
        vista.run(args);
    }
    
}
