/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nicolasquintana
 */
public class Fecha {
    
    
    private int dia;
    private int mes;
    private int año;
    
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setAño(int año){
        this.año = año;
    }
    
    public Fecha(int dia, int mes, int año){
        this.año = año;
        this.dia = dia;
        this.mes = mes;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    
    public static String fechaActual(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH.mm.ss dd/MM/yyyy");
        return "("+hourdateFormat.format(date)+")";
    }
    
    public static String fechaActualArchivo(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("(HH.mm.ss dd-MM-yyyy)");
        return hourdateFormat.format(date);
    }
     
    
    
}
