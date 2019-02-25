/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.controllers;

import java.io.IOException;
import proyectochatbot.models.Chatbot;
import proyectochatbot.models.Log;
import proyectochatbot.models.OpcionesOrgMatrimonio;
import proyectochatbot.models.Usuario;
import proyectochatbot.models.Archivo;
import proyectochatbot.models.Fecha;
import proyectochatbot.views.ChatbotCommandLine;

/**
 *
 * @author Nicolás Quintana
 */
public class ChatbotCore {
    
    // Constantes
    
    static final long CONSTANTE_A = 1103515245L;
    static final long CONSTANTE_C = 12345L;
    static final long CONSTANTE_M = 2147483648L;
    
    
    
    private boolean inicioBeginDialog = false;
    private String ultimoMensaje = "";
    Usuario user = new Usuario();
    Chatbot chatbot = new Chatbot();
    OpcionesOrgMatrimonio organizacion = new OpcionesOrgMatrimonio();
     
    
    
    
    public long getRandom(int seed){
        return (CONSTANTE_C + (CONSTANTE_A * seed)) % CONSTANTE_M;
        
    }
    
    public String chatbotPersonalidad(long random){
        if(random % 2 == 0){
            return "agresivo";
        }
        else{
            return "formal";
        }
    }
    
    public Usuario accederUser(){
        return this.user;
    }
    
    public Boolean preguntarSiSeInicioBeginDialog(){
        return this.inicioBeginDialog;
    }
    
    public void cambiarInicioBeginDialog(Boolean inicioBeginDialog){
        this.inicioBeginDialog = inicioBeginDialog;
    }
    
    public String getUltimoMensajeChatbot(){
        return this.ultimoMensaje;
    }
    
    public void setUltimoMensajeChatbot(String msg){
        this.ultimoMensaje = msg;
    }
    
    public String sendMessage(String msg) throws IOException{
        String respuesta = "";
        
        
        Log.agregarMensaje(Fecha.fechaActual() +" "+ "Usuario: " + msg);
        if(this.ultimoMensaje.equals(chatbot.bienvenida() + chatbot.preguntarNombre())){
            user.setNombreUsuario(chatbot.obtenerNombreUsuario(msg));
            respuesta = user.getNombreUsuario() + ", " + organizacion.preguntarSiQuiereAyudaOrganizacion();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarSiQuiereAyudaOrganizacion().length() && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarSiQuiereAyudaOrganizacion().length()).equals(organizacion.preguntarSiQuiereAyudaOrganizacion())){
            if(chatbot.preguntarSiRespuestaEsPositiva(msg)){
                respuesta = chatbot.pedirNombreConjuge();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNegativa(msg)){
                respuesta = chatbot.preguntarSalirContinuar();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            
        }
        else if(this.ultimoMensaje.equals(chatbot.preguntarSalirContinuar())){
            if(chatbot.preguntarSiRespuestaContinuar(msg)){
                respuesta = chatbot.pedirNombreConjuge();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaSalir(msg)){
                respuesta = chatbot.mensajeDespedida();
                this.ultimoMensaje = respuesta;
                ChatbotCommandLine.finalizarConversacion();
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
        }
        else if(this.ultimoMensaje.equals(chatbot.pedirNombreConjuge())){
            user.setNombreConjuge(chatbot.obtenerNombreConyuge(msg));
            respuesta = "Ok, " + user.getNombreConyuge() + chatbot.reconocerNombre() + chatbot.preguntarAñoMatrimonio();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarAñoMatrimonio().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarAñoMatrimonio().length()).equals(chatbot.preguntarAñoMatrimonio())){
            user.setAño(chatbot.obtenerAñoMensaje(msg));
            respuesta = "Bien, " + chatbot.preguntarMesMatrimonio();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarMesMatrimonio().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarMesMatrimonio().length()).equals(chatbot.preguntarMesMatrimonio())){
            user.setMes(chatbot.obtenerMesMensaje(msg));
            respuesta = "Por ultimo, " + chatbot.preguntarDiaMatrimonio();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarDiaMatrimonio().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarDiaMatrimonio().length()).equals(chatbot.preguntarDiaMatrimonio())){
            user.setDia(chatbot.obtenerDiaMensaje(msg));
            respuesta = organizacion.preguntarPorBanqueteria();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.equals(organizacion.preguntarPorBanqueteria())){
            if(chatbot.preguntarSiRespuestaEsSi(msg)){
                respuesta = "Ok, entiendo... " +  chatbot.preguntarNombreEmpresaBanquetera();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNo(msg)){
                respuesta = organizacion.opcionesBanqueteria() + organizacion.queOpcionElegir();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarNombreEmpresaBanquetera().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarNombreEmpresaBanquetera().length()).equals(chatbot.preguntarNombreEmpresaBanquetera())){
            user.setOpcionBanqueteria(chatbot.obtenerNombreEmpresaBanquetera(msg));
            respuesta = "Muy bien, felicidades... continuemos " + organizacion.preguntarPorTraje();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        
        else if(this.ultimoMensaje.equals(organizacion.opcionesBanqueteria() + organizacion.queOpcionElegir())){
            user.setOpcionBanqueteria(organizacion.obtenerOpcionBanquetera(msg));
            respuesta = "Que bien, ya tienes agregada la banqueteria a tus preferencias, continuemos\n" + organizacion.preguntarPorTraje();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
            
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarPorTraje().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarPorTraje().length()).equals(organizacion.preguntarPorTraje())){
            if(chatbot.preguntarSiRespuestaEsSi(msg)){
                respuesta = "Ok, entiendo... "+ chatbot.preguntarNombreEmpresaTraje();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNo(msg)){
                respuesta = organizacion.opcionesTraje() + organizacion.queOpcionElegir();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
        }
        else if(this.ultimoMensaje.equals(organizacion.opcionesTraje() + organizacion.queOpcionElegir())){
            user.setOpcionTraje(organizacion.obtenerOpcionEmpresaTraje(msg));
            respuesta = "Anotada en tus preferencias... " + organizacion.preguntarPorVestidoNovia();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarNombreEmpresaTraje().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarNombreEmpresaTraje().length()).equals(chatbot.preguntarNombreEmpresaTraje())){
            user.setOpcionTraje(chatbot.obtenerNombreEmpresaTraje(msg));
            respuesta = "Muy bien, felicidades, continuemos " + organizacion.preguntarPorVestidoNovia();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarPorVestidoNovia().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarPorVestidoNovia().length()).equals(organizacion.preguntarPorVestidoNovia())){
            if(chatbot.preguntarSiRespuestaEsSi(msg)){
                respuesta = "Ok, entiendo... " + chatbot.preguntarNombreEmpresaVestido();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNo(msg)){
                respuesta = organizacion.opcionesVestido() + organizacion.queOpcionElegir();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            
        }
        else if(this.ultimoMensaje.equals(organizacion.opcionesVestido() + organizacion.queOpcionElegir())){
            user.setOpcionVestido(organizacion.obtenerOpcionEmpresaVestido(msg));
            respuesta = "Anotada en tus preferencias..." + organizacion.preguntarPorFotografo();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarNombreEmpresaVestido().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarNombreEmpresaVestido().length()).equals(chatbot.preguntarNombreEmpresaVestido())){
            user.setOpcionVestido(chatbot.obtenerNombreEmpresaVestido(msg));
            respuesta = "Muy bien, lo agregué a tus preferencias, continuemos " + organizacion.preguntarPorFotografo();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarPorFotografo().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarPorFotografo().length()).equals(organizacion.preguntarPorFotografo())){
            if(chatbot.preguntarSiRespuestaEsSi(msg)){
                respuesta = "Ok, entiendo... " + chatbot.preguntarNombreEmpresaFotografia();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNo(msg)){
                respuesta = organizacion.opcionesFotografo() + organizacion.queOpcionElegir();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
        }
        else if(this.ultimoMensaje.equals(organizacion.opcionesFotografo() + organizacion.queOpcionElegir())){
            user.setOpcionFotografia(organizacion.obtenerOpcionEmpresaFotografia(msg));
            respuesta = "Anotado en tus preferencias..." + organizacion.preguntarSiSeCasaranPorIglesia();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= chatbot.preguntarNombreEmpresaFotografia().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-chatbot.preguntarNombreEmpresaFotografia().length()).equals(chatbot.preguntarNombreEmpresaFotografia())){
            user.setOpcionFotografia(chatbot.obtenerNombreEmpresaFotografia(msg));
            respuesta = "Muy bien, lo agregué a tus preferencias, continuemos " + organizacion.preguntarSiSeCasaranPorIglesia();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarSiSeCasaranPorIglesia().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarSiSeCasaranPorIglesia().length()).equals(organizacion.preguntarSiSeCasaranPorIglesia())){
            if(chatbot.preguntarSiRespuestaEsSi(msg)){
                respuesta = "Que bien, se casarán por la iglesia... " + organizacion.preguntarPorIglesia();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else if(chatbot.preguntarSiRespuestaEsNo(msg)){
                respuesta = "Muy bien, lo he guardado a tus preferencias...\n" + "Hemos finalizado... " + chatbot.quieresMasAyuda();
                this.ultimoMensaje = respuesta;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                user.setOpcionIglesia("No se casaran por la iglesia");
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
        }
        else if(this.ultimoMensaje.length() >= organizacion.preguntarPorIglesia().length()  && this.ultimoMensaje.substring(this.ultimoMensaje.length()-organizacion.preguntarPorIglesia().length()).equals(organizacion.preguntarPorIglesia())){
            user.setOpcionIglesia(chatbot.obtenerNombreIglesia(msg));
            respuesta = "Muy bien, lo he guardado a tus preferencias...\n" + "Hemos finalizado... " + chatbot.quieresMasAyuda();
            this.ultimoMensaje = respuesta;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
        else if(this.ultimoMensaje.equals("Muy bien, lo he guardado a tus preferencias...\n" + "Hemos finalizado... " + chatbot.quieresMasAyuda())){
            if(chatbot.preguntarSiRespuestaEsNegativa(msg)){
                respuesta = "Ok, que tengas un buen día...";
                this.ultimoMensaje = respuesta;
                ChatbotCommandLine.finalizarConversacion();
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
                
            }
            else if(chatbot.preguntarSiRespuestaEsPositiva(msg)){
                respuesta = "Nombre usuario: "+user.getNombreUsuario()+"\nNombre conyuge: "+user.getNombreConyuge()+"\nAño matrimonio: "+
                        user.getAño()+"\nMes matrimonio: "+user.getMes()+"\nDia matrimonio: "+user.getDia()+"\nBanqueteria: "+
                        user.getOpcionBanquetera()+"\nTraje: "+user.getOpcionTraje()+"\nVestido: "+user.getOpcionVestido()+
                        "\nFotografo: "+user.getOpcionFotografo()+"Iglesia: "+user.getOpcionIglesia();
                this.ultimoMensaje = respuesta;
                ChatbotCommandLine.finalizarConversacion();
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+this.ultimoMensaje;
                Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
                return respuesta;
            }
            
        }
        else{
            respuesta = "Lo siento, no entendí tu mensaje... repito\n"+this.ultimoMensaje;
            Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
            return respuesta;
        }
    }
    
    public String beginDialog(int seed){
        String respuesta;
        
        Log.agregarMensaje("--- INICIO CONVERSACIÓN ---");
        if(seed == 0){
            chatbot.setPersonalidad("estandar");
            
        }
        else{
            chatbot.setPersonalidad(chatbotPersonalidad(getRandom(seed)));
            
        }
        respuesta = chatbot.bienvenida() + chatbot.preguntarNombre();
        Log.agregarMensaje(Fecha.fechaActual() + " " + "Chatbot: " + respuesta);
        return respuesta;
    }
    
    public String endDialog(){
        String respuesta;
        
        respuesta = "Adios";
        Log.agregarMensaje(respuesta);
        Log.agregarMensaje("--- FIN CONVERSACIÓN ---");
        
        return respuesta;
    }
    
    public String saveLog() throws IOException{
        String respuesta;        
        Archivo.escribirArchivo(Log.getLog(), "/Users/nicolasquintanam/desktop/ChatbotGuardado"+Fecha.fechaActualArchivo()+".txt");
        respuesta = "Mensaje guardado en archivo\n\nContinuando...\n"+this.ultimoMensaje;
        return respuesta;
    }
    
    public String loadLog(String nombreArchivo) throws IOException{
        String respuesta = "Lo siento, no pude reconocer tu archivo...";
        if(!Archivo.obtenerNombreUsuario(nombreArchivo).equals("no se puede")){
            user.setNombreUsuario(chatbot.obtenerNombreUsuario(Archivo.obtenerNombreUsuario(nombreArchivo)));
        }
        else{
            respuesta = chatbot.bienvenida() + chatbot.preguntarNombre();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerNombreFuturaEsposa(nombreArchivo).equals("no se puede")){
            user.setNombreConjuge(chatbot.obtenerNombreConyuge(Archivo.obtenerNombreFuturaEsposa(nombreArchivo)));
        }
        else{
            respuesta = chatbot.pedirNombreConjuge();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerAñoMatrimonio(nombreArchivo).equals("no se puede")){
            user.setAño(chatbot.obtenerAñoMensaje(Archivo.obtenerAñoMatrimonio(nombreArchivo)));
        }
        else{
            respuesta = "Ok, " + user.getNombreConyuge() + chatbot.reconocerNombre() + chatbot.preguntarAñoMatrimonio();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerMesMatrimonio(nombreArchivo).equals("no se puede")){
            user.setMes(chatbot.obtenerMesMensaje(Archivo.obtenerMesMatrimonio(nombreArchivo)));
        }
        else{
            respuesta = "Bien, " + chatbot.preguntarMesMatrimonio();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerDiaMatrimonio(nombreArchivo).equals("no se puede")){
            user.setDia(chatbot.obtenerDiaMensaje(Archivo.obtenerDiaMatrimonio(nombreArchivo)));
        }
        else{
            respuesta = "Por ultimo, " + chatbot.preguntarDiaMatrimonio();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerTenenciaBanqueteria(nombreArchivo).equals("no se puede")){
            if(chatbot.preguntarSiRespuestaEsSi(Archivo.obtenerTenenciaBanqueteria(nombreArchivo))){
                if(!Archivo.obtenerEmpresaBanqueteraContratada(nombreArchivo).equals("no se puede")){
                    user.setOpcionBanqueteria(chatbot.obtenerNombreEmpresaBanquetera(Archivo.obtenerEmpresaBanqueteraContratada(nombreArchivo)));
                }
                else{
                    respuesta = "Ok, entiendo... " +  chatbot.preguntarNombreEmpresaBanquetera();
                    this.ultimoMensaje = respuesta;
                }
            }
            else if(chatbot.preguntarSiRespuestaEsNo(Archivo.obtenerTenenciaBanqueteria(nombreArchivo))){
                if(!Archivo.obtenerPreferenciaBanqueteria(nombreArchivo).equals("no se puede")){
                    user.setOpcionBanqueteria(organizacion.obtenerOpcionBanquetera(Archivo.obtenerPreferenciaBanqueteria(nombreArchivo)));
                }
                else{
                    respuesta = organizacion.opcionesBanqueteria() + organizacion.queOpcionElegir();
                    this.ultimoMensaje = respuesta;
                }
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+organizacion.preguntarPorBanqueteria();
            }
        }
        else{
            respuesta = organizacion.preguntarPorBanqueteria();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerTenenciaTraje(nombreArchivo).equals("no se puede")){
            if(chatbot.preguntarSiRespuestaEsSi(Archivo.obtenerTenenciaTraje(nombreArchivo))){
                if(!Archivo.obtenerEmpresaTrajeContratada(nombreArchivo).equals("no se puede")){
                    user.setOpcionTraje(chatbot.obtenerNombreEmpresaTraje(Archivo.obtenerEmpresaTrajeContratada(nombreArchivo)));
                }
                else{
                    respuesta = "Ok, entiendo... "+ chatbot.preguntarNombreEmpresaTraje();
                    this.ultimoMensaje = respuesta;
                }
            }
            else if(chatbot.preguntarSiRespuestaEsNo(Archivo.obtenerTenenciaTraje(nombreArchivo))){
                if(!Archivo.obtenerPreferenciaTraje(nombreArchivo).equals("no se puede")){
                    user.setOpcionTraje(organizacion.obtenerOpcionEmpresaTraje(Archivo.obtenerPreferenciaTraje(nombreArchivo)));
                }
                else{
                    respuesta = organizacion.opcionesTraje() + organizacion.queOpcionElegir();
                    this.ultimoMensaje = respuesta;
                }
            }  
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+organizacion.preguntarPorTraje();
            }
        }
        else{
            respuesta = organizacion.preguntarPorTraje();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerTenenciaVestido(nombreArchivo).equals("no se puede")){
            if(chatbot.preguntarSiRespuestaEsSi(Archivo.obtenerTenenciaVestido(nombreArchivo))){
                if(!Archivo.obtenerEmpresaVestidoContratada(nombreArchivo).equals("no se puede")){
                    user.setOpcionTraje(chatbot.obtenerNombreEmpresaVestido(Archivo.obtenerEmpresaVestidoContratada(nombreArchivo)));
                }
                else{
                    respuesta = "Ok, entiendo... " + chatbot.preguntarNombreEmpresaVestido();
                    this.ultimoMensaje = respuesta;
                }
            }
            else if(chatbot.preguntarSiRespuestaEsNo(Archivo.obtenerTenenciaVestido(nombreArchivo))){
                if(!Archivo.obtenerPreferenciaVestido(nombreArchivo).equals("no se puede")){
                    user.setOpcionVestido(organizacion.obtenerOpcionEmpresaVestido(Archivo.obtenerPreferenciaVestido(nombreArchivo)));
                }
                else{
                    respuesta = organizacion.opcionesVestido() + organizacion.queOpcionElegir();
                    this.ultimoMensaje = respuesta;
                }
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+organizacion.preguntarPorVestidoNovia();
            }
        }
        else{
            respuesta = organizacion.preguntarPorVestidoNovia();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerTenenciaFotografo(nombreArchivo).equals("no se puede")){
            if(chatbot.preguntarSiRespuestaEsSi(Archivo.obtenerTenenciaFotografo(nombreArchivo))){
                if(!Archivo.obtenerEmpresaFotografoContratada(nombreArchivo).equals("no se puede")){
                    user.setOpcionFotografia(chatbot.obtenerNombreEmpresaFotografia(Archivo.obtenerEmpresaFotografoContratada(nombreArchivo)));
                }
                else{
                    respuesta = "Ok, entiendo... " + chatbot.preguntarNombreEmpresaFotografia();
                    this.ultimoMensaje = respuesta;
                }
            }
            else if(chatbot.preguntarSiRespuestaEsNo(Archivo.obtenerTenenciaFotografo(nombreArchivo))){
                if(!Archivo.obtenerPreferenciaFotografo(nombreArchivo).equals("no se puede")){
                    user.setOpcionFotografia(organizacion.obtenerOpcionEmpresaFotografia(Archivo.obtenerEmpresaFotografoContratada(nombreArchivo)));
                }
                else{
                    respuesta = organizacion.opcionesFotografo() + organizacion.queOpcionElegir();
                    this.ultimoMensaje = respuesta;
                }
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+organizacion.preguntarPorFotografo();
            }
        }
        else{
            respuesta = organizacion.preguntarPorFotografo();
            this.ultimoMensaje = respuesta;
        }
        if(!Archivo.obtenerSiSeCasaranPorIglesia(nombreArchivo).equals("no se puede")){
            if(chatbot.preguntarSiRespuestaEsSi(Archivo.obtenerSiSeCasaranPorIglesia(nombreArchivo))){
                if(!Archivo.obtenerQueIglesia(nombreArchivo).equals("no se puede")){
                    user.setOpcionIglesia(chatbot.obtenerNombreIglesia(Archivo.obtenerQueIglesia(nombreArchivo)));
                }
                else{
                    respuesta = "Que bien, se casarán por la iglesia... " + organizacion.preguntarPorIglesia();
                    this.ultimoMensaje = respuesta;
                }
            }
            else if(chatbot.preguntarSiRespuestaEsNo(Archivo.obtenerSiSeCasaranPorIglesia(nombreArchivo))){
                user.setOpcionIglesia("No se casarán por la iglesia");
                respuesta = "Muy bien, lo he guardado a tus preferencias...\n" + "Hemos finalizado... " + chatbot.quieresMasAyuda();
                this.ultimoMensaje = respuesta;
            }
            else{
                respuesta = "Lo siento, no entendí tu mensaje, ¿me puedes responder de una manera similar?... repito\n"+organizacion.preguntarSiSeCasaranPorIglesia();
                this.ultimoMensaje = organizacion.preguntarSiSeCasaranPorIglesia();
            }
        }
        else{
            respuesta = organizacion.preguntarSiSeCasaranPorIglesia();
            this.ultimoMensaje = respuesta;
        }
        if(respuesta.equals("Lo siento, no pude reconocer tu archivo...")){
            
        }
        return respuesta;
    }
    
    public String rate(int notaChatbot, int notaUsuario){
        String respuesta;
        user.setRateUsuario(notaUsuario);
        chatbot.setRateChatbot(notaChatbot);
        respuesta = "Le has puesto nota "+chatbot.getRateChatbot()+" al Chatbot y nota "+user.getRateUsuario()+" al usuario";
        return respuesta;
    }
    
    
    
    
}
