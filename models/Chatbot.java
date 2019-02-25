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
public class Chatbot {
    
    String personalidad = "estandar"; //Default
    int rateChatbot = 0;
    
    public void setRateChatbot(int rateChatbot){
        this.rateChatbot = rateChatbot;
    }
    
    public int getRateChatbot(){
        return this.rateChatbot;
    }
    
    public String getPersonalidad(){
        return this.personalidad;
    }
    
    public void setPersonalidad(String personalidad){
        this.personalidad = personalidad;
    }
    
    public static List<String> variacionesMeLlamo = Arrays.asList("Me llamo ", "Mi nombre es ", "Hola, me llamo ", "Hola, mi nombre es ", 
                                                                    "Hola, gracias mi nombre es ", "Gracias, mi nombre es ", "Gracias, me llamo ");
    
    public static List<String> variacionesSeLlama = Arrays.asList("Se llama ", "Su nombre es ");
    
    public static List<String> variacionesNombrarAño = Arrays.asList("El año es ", "Año ", "Nos casamos en el año ");
    
    public static List<String> variacionesNombrarMes = Arrays.asList("El mes es ", "Mes ", "Nos casamos en el mes ");
    
    public static List<String> variacionesNombrarDia = Arrays.asList("El dia es ", "Dia ", "Nos casamos en el dia ");
    
    public static List<String> variacionesNombreEmpresaBanquetera = Arrays.asList("La empresa es ", "El nombre de la empresa es ", "El nombre es ", "La empresa banquetera se llama ",
                                                                        "Se llama ", "El nombre de la empresa banquetera es ", "el nombre es ", "la empresa es ", "el nombre de la empresa es ",
                                                                        "la empresa banquetera se llama ", "se llama ");
    
    public static List<String> variacionesNombreEmpresaTraje = Arrays.asList("La empresa es ", "El nombre de la empresa es ", "El nombre es ", "La empresa de traje se llama ",
                                                                        "Se llama ", "El nombre de la empresa de traje es ", "el nombre es ", "la empresa es ", "el nombre de la empresa es ",
                                                                        "la empresa de traje se llama ", "se llama ");
    
    public static List<String> variacionesNombreEmpresaVestido = Arrays.asList("La empresa es ", "El nombre de la empresa es ", "El nombre es ", "La empresa del vestido se llama ",
                                                                        "Se llama ", "El nombre de la empresa del vestido es ", "el nombre es ", "la empresa es ", "el nombre de la empresa es ",
                                                                        "la empresa del vestido se llama ", "se llama ");
    
    public static List<String> variacionesNombreEmpresaFotografia = Arrays.asList("La empresa es ", "El nombre de la empresa es ", "El nombre es ", "La empresa de fotografia se llama ",
                                                                        "Se llama ", "El nombre de la empresa de fotografia es ", "el nombre es ", "la empresa es ", "el nombre de la empresa es ",
                                                                        "la empresa de fotografia se llama ", "se llama ");
    
    public static List<String> variacionesNombreIglesia = Arrays.asList("La iglesia es ", "El nombre de la iglesia es ", "El nombre es ", "La iglesia donde nos casaremos se llama ",
                                                                        "Se llama ", "El nombre de la iglesia que nos casaremos se llama ", "el nombre es ", "la iglesia es ", "el nombre de la iglesia es ",
                                                                        "la iglesia donde nos casaremos se llama ", "se llama ");
    
    
     
    public String obtenerNombreUsuario(String mensaje){
        int i;
        for(i = 0 ; i < variacionesMeLlamo.size() ; i++){
            if(mensaje.startsWith(variacionesMeLlamo.get(i))){
                return mensaje.substring(variacionesMeLlamo.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String bienvenida(){
        
        if("formal".equals(this.personalidad)){
            return "Hola, bienvenido ";  //FORMAL
        }
        else if("agresivo".equals(this.personalidad)){
            return "Holaa, bienvenido "; //AGRESIVO
        }
        else{
            return "Hola, bienvenido "; //ESTANDAR
        }
        
    }
    
    public String preguntarNombre(){
        if("formal".equals(this.personalidad)){
            return "¿Cómo te llamas?"; //FORMAL
        }
        else if("agresivo".equals(this.personalidad)){
            return "¿Cuál es tu nombre?"; //AGRESIVO
        }
        else{
            return "¿Me puedes indicar cómo te llamas?"; //ESTANDAR
        }
    }
    
    public boolean preguntarSiRespuestaEsPositiva(String msg){
        switch(msg){
            case "si": return true;
            case "sí": return true;
            case "sii": return true;
            case "Si": return true;
            case "Sii": return true;
            case "Sí": return true;
            case "Ok": return true;
            case "ok": return true;
            case "Ya": return true;
            case "ya": return true;
            case "okey": return true;
            case "Okey": return true;
            case "si por favor": return true;
            case "si, por favor": return true;
            case "si, gracias": return true;
            case "Si gracias": return true;
            default: return false;
        }
    }
    
    public boolean preguntarSiRespuestaEsNegativa(String msg){
        switch(msg){
            case "no": return true;
            case "No": return true;
            case "noo": return true;
            case "Noo": return true;
            case "No, gracias": return true;
            case "no, gracias": return true;
            case "No gracias": return true;
            case "no gracias": return true;
            default: return false;
        }
    }
    
    public boolean preguntarSiRespuestaEsSi(String msg){
        switch(msg){
            case "si": return true;
            case "Si": return true;
            case "Sí": return true;
            case "sí": return true;
            case "sii": return true;
            case "Sii": return true;
            default: return false;
        }
    }
    
    public boolean preguntarSiRespuestaEsNo(String msg){
        switch(msg){
            case "no": return true;
            case "No": return true;
            case "Noo": return true;
            case "noo": return true;
            default: return false;
        }
    }
    
    public String preguntarNombreEmpresaBanquetera(){
        return "¿me puedes indicar el nombre de la empresa banquetera para agregarlo a tus preferencias?";
    }
    
    public String preguntarSalirContinuar(){
        return "¿Quieres salir o quieres continuar con la organización?";
    }
    
    public boolean preguntarSiRespuestaSalir(String msg){
        switch(msg){
            case "si, quiero salir": return true;
            case "Si, quiero salir": return true;
            case "No, quiero salir": return true;
            case "no, quiero salir": return true;
            case "quiero salir": return true;
            case "Quiero salir": return true;
            case "salir": return true;
            case "Salir": return true;
            default: return false;
        }
    }
    
    public boolean preguntarSiRespuestaContinuar(String msg){
        switch(msg){
            case "si, quiero continuar": return true;
            case "Si, quiero continuar": return true;
            case "no, quiero continuar": return true;
            case "No, quiero continuar": return true;
            case "quiero continuar": return true;
            case "Quiero continuar": return true;
            case "Continuar": return true;
            case "continuar": return true;
            default: return false;
        }
    }
    
    public String mensajeDespedida(){
        return "Que tengas un buen día, adios";
    }
    
    public String noSeEntiendeMensaje(){
        return "Lo siento, no entiendo tu mensaje, adios";
    }
    
    public String reconocerNombre(){
        return " es un lindo nombre...\n";
    }
    
    public String preguntarAñoMatrimonio(){
        return "Me podrías indicar en qué año se casarán?";
    }
    
    public String preguntarMesMatrimonio(){
        return "Qué mes será el matrimonio?";
    }
    
    public String preguntarDiaMatrimonio(){
        return "Que dia será?";
    }
    
    public String preguntarNombreEmpresaFotografia(){
        return "¿me puedes indicar el nombre la empresa de fotografia, para agregarlo a tus preferencias?";
    }
    
    public String obtenerNombreConyuge(String mensaje){
        int i;
        for(i = 0 ; i < variacionesSeLlama.size() ; i++){
            if(mensaje.startsWith(variacionesSeLlama.get(i))){
                return mensaje.substring(variacionesSeLlama.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String obtenerNombreEmpresaBanquetera(String mensaje){
        int i;
        for(i = 0 ; i < variacionesNombreEmpresaBanquetera.size() ; i++){
            if(mensaje.startsWith(variacionesNombreEmpresaBanquetera.get(i))){
                return mensaje.substring(variacionesNombreEmpresaBanquetera.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String obtenerNombreEmpresaFotografia(String mensaje){
        int i;
        for(i = 0 ; i < variacionesNombreEmpresaFotografia.size() ; i++){
            if(mensaje.startsWith(variacionesNombreEmpresaFotografia.get(i))){
                return mensaje.substring(variacionesNombreEmpresaFotografia.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String obtenerNombreIglesia(String mensaje){
        int i;
        for(i = 0 ; i < variacionesNombreIglesia.size() ; i++){
            if(mensaje.startsWith(variacionesNombreIglesia.get(i))){
                return mensaje.substring(variacionesNombreIglesia.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String preguntarNombreEmpresaVestido(){
        return "¿me puedes indicar el nombre de la empresa donde contrataron el vestido de novia, para agregarlo a tus preferencias?";
    }
    
    public String obtenerNombreEmpresaVestido(String mensaje){
        int i;
        for(i = 0 ; i < variacionesNombreEmpresaVestido.size() ; i++){
            if(mensaje.startsWith(variacionesNombreEmpresaVestido.get(i))){
                return mensaje.substring(variacionesNombreEmpresaVestido.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String obtenerNombreEmpresaTraje(String mensaje){
        int i;
        for(i = 0 ; i < variacionesNombreEmpresaTraje.size() ; i++){
            if(mensaje.startsWith(variacionesNombreEmpresaTraje.get(i))){
                return mensaje.substring(variacionesNombreEmpresaTraje.get(i).length());
            }
        }
        return mensaje;
    }
    
    public String preguntarNombreEmpresaTraje(){
        return "¿me puedes indicar el nombre de la empresa donde contrataste el traje para agregarlo a tus preferencias?";
    }
     
    public String pedirNombreConjuge(){
        return "Para comenzar, ¿me podrías indicar el nombre de tu futuro/a esposo/a?";
    }
    
    public int obtenerAñoMensaje(String mensaje){
        int año;
        String añoString;
        int i;
        for(i = 0 ; i < variacionesNombrarAño.size() ; i++){
            if(mensaje.startsWith(variacionesNombrarAño.get(i))){
                añoString =  mensaje.substring(variacionesNombrarAño.get(i).length());
                return Integer.parseInt(añoString);
            }
        }

        return Integer.parseInt(mensaje);
    }
    
    public int obtenerMesMensaje(String mensaje){
        int mes;
        String mesString;
        int i;
        for(i = 0 ; i < variacionesNombrarMes.size() ; i++){
            if(mensaje.startsWith(variacionesNombrarMes.get(i))){
                mesString =  mensaje.substring(variacionesNombrarMes.get(i).length());
                
                if(isNumeric(mesString)){
                    return Integer.parseInt(mesString);
                }
                else{
                    switch(mesString){
                        
                        case "Enero": return 1;
                        case "Febrero": return 2;
                        case "Marzo": return 3;
                        case "Abril": return 4;
                        case "Mayo": return 5;
                        case "Junio": return 6;
                        case "Julio": return 7;
                        case "Agosto": return 8;
                        case "Septiembre": return 9;
                        case "Octubre": return 10;
                        case "Noviembre": return 11;
                        case "Diciembre": return 12;
                        default: return 0;
                        
                    }
                }

            }
        }
        if(isNumeric(mensaje)){
                    return Integer.parseInt(mensaje);
                }
                else{
                    switch(mensaje){
                        
                        case "Enero": return 1;
                        case "enero": return 1;
                        case "Febrero": return 2;
                        case "febrero": return 2;
                        case "Marzo": return 3;
                        case "marzo": return 3;
                        case "Abril": return 4;
                        case "abril": return 4;
                        case "Mayo": return 5;
                        case "mayo": return 5;
                        case "Junio": return 6;
                        case "junio": return 6;
                        case "Julio": return 7;
                        case "julio": return 7;
                        case "Agosto": return 8;
                        case "agosto": return 8;
                        case "Septiembre": return 9;
                        case "septiembre": return 9;
                        case "Octubre": return 10;
                        case "octubre": return 10;
                        case "Noviembre": return 11;
                        case "noviembre": return 11;
                        case "Diciembre": return 12;
                        case "diciembre": return 12;
                        
                        default: return 0;
                        
                    }
                }

        
    }
    
    public String quieresMasAyuda(){
        return "¿Quieres que te ayude en algo más?";
    }
    
    public int obtenerDiaMensaje(String mensaje){
        int dia;
        String diaString;
        int i;
        for(i = 0 ; i < variacionesNombrarDia.size() ; i++){
            if(mensaje.startsWith(variacionesNombrarDia.get(i))){
                diaString =  mensaje.substring(variacionesNombrarDia.get(i).length());
                return Integer.parseInt(diaString);
            }
        }

        return Integer.parseInt(mensaje);
    }
    
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
}
