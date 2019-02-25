/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nicolás Quintana
 */
public class Log {
    
    static List<String> log = new ArrayList<String>();
    
    public static void agregarMensaje(String mensaje){
        log.add(mensaje);
    }
    public static void mostrarLog(){
        int i;
        for(i=0;i<log.size();i++){
            System.out.println(log.get(i));
        }
    }
    
    public static List<String> getLog(){
        return log;
    }
    
    
    
}
