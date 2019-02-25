/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.models;

/**
 *
 * @author Nicolás Quintana
 */
public class Usuario {
    
    private String nombreUsuario = null;
    private String nombreConyuge;
    Fecha fechaMatrimonio;
    int año;
    int mes;
    int dia;
    boolean banqueteriaLugar = false;
    boolean traje = false;
    boolean vestido = false;
    boolean fotografia = false;
    boolean iglesia = false;
    int rateUsuario = 0;
    
    String opcionBanqueteria = "Default"; //Si es que el usuario dice que ya tiene
    String opcionTraje;
    String opcionVestido;
    String opcionFotografia;
    String opcionIglesia;
    
    
    public int getRateUsuario(){
        return this.rateUsuario;
    }
    
    public void setRateUsuario(int rateUsuario){
        this.rateUsuario = rateUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public void setNombreConjuge(String nombreConyuge){
        this.nombreConyuge = nombreConyuge;
    }
    
    public String getNombreConyuge(){
        return this.nombreConyuge;
    }
    
    public void setAño(int año){
        this.año = año;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public int getAño(){
        return this.año;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public String getOpcionBanquetera(){
        return this.opcionBanqueteria;
    }
    
    public String getOpcionTraje(){
        return this.opcionTraje;
    }
    
    public String getOpcionVestido(){
        return this.opcionVestido;
    }
    
    public String getOpcionFotografo(){
        return this.opcionFotografia;
    }
    
    public String getOpcionIglesia(){
        return this.opcionIglesia;
    }
    
    public void setFecha(int dia, int mes, int año){
        fechaMatrimonio = new Fecha(dia, mes, año);
    }
    
    public void setOpcionBanqueteria(String nombreEmpresa){
        this.opcionBanqueteria = nombreEmpresa;
    }
    
    public void setOpcionTraje(String nombreEmpresa){
        this.opcionTraje = nombreEmpresa;
    }
    
    public void setOpcionVestido(String nombreEmpresa){
        this.opcionVestido = nombreEmpresa;
    }
    
    public void setOpcionFotografia(String nombreEmpresa){
        this.opcionFotografia = nombreEmpresa;
    }
    
    public void setOpcionIglesia(String nombreIglesia){
        this.opcionIglesia = nombreIglesia;
    }
    
    
    
    
    
    
}



