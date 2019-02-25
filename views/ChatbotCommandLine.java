/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.views;

import java.io.IOException;
import java.util.Scanner;
import proyectochatbot.controllers.ChatbotCore;

/**
 *
 * @author Nicolás Quintana
 */
public class ChatbotCommandLine {
    
    ChatbotCore chatbotCore = new ChatbotCore();
    static boolean conversacionFinalizada = false;
    
    
    
    public void run(String[] args) throws IOException{
        System.out.println("Bienvenido al organizador de matrimonio");
        System.out.println("Con este chat, usted podrá organizar de manera efectiva su gran día...");
        Scanner lectorTeclado = new Scanner(System.in);
        while(lectorTeclado.hasNext()){
            String input = lectorTeclado.nextLine();
            if(decodeInput(input) || conversacionFinalizada){
                break;
            }
        }
        lectorTeclado.close();
    }
    
    public static void mensajeEspontaneo(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void finalizarConversacion(){
        conversacionFinalizada = true;
    }
    
    
    public boolean decodeInput(String input) throws IOException{
        if(input.startsWith("!")){
            if(input.equals("!beginDialog")){
                if(chatbotCore.preguntarSiSeInicioBeginDialog()){
                    System.out.println("No se puede iniciar beginDialog más de 1 vez...");
                }
                else{
                    String response = chatbotCore.beginDialog(0);
                    
                    chatbotCore.cambiarInicioBeginDialog(true);
                    System.out.println(response);
                    chatbotCore.setUltimoMensajeChatbot(response);
                }
                
                return false;
            }
            else if(input.length() >= 14 && input.startsWith("!beginDialog ")){
                if(chatbotCore.preguntarSiSeInicioBeginDialog()){
                    System.out.println("No se puede iniciar beginDialog más de 1 vez...");
                }
                else{
                    String aux = input.substring(13,input.length());
                    String response = chatbotCore.beginDialog(Integer.parseInt(aux));
                    chatbotCore.cambiarInicioBeginDialog(true);
                    System.out.println(response);
                    chatbotCore.setUltimoMensajeChatbot(response);
                }
                return false;
            }
            else if(input.equals("!endDialog")){
                chatbotCore.cambiarInicioBeginDialog(false);
                String response = chatbotCore.endDialog();
                System.out.println(response);
                return true;
            }
            else if(input.equals("!saveLog")){
                //Guardar log en un archivo de texto
                String response = chatbotCore.saveLog();
                System.out.println(response);
                chatbotCore.setUltimoMensajeChatbot(response);
                return false;
            }
            else if(input.length() >= 10 && input.startsWith("!loadLog ")){
                String aux = input.substring(9, input.length());
                String response = chatbotCore.loadLog(aux);
                System.out.println(response);
                chatbotCore.setUltimoMensajeChatbot(response);
                chatbotCore.cambiarInicioBeginDialog(true);
                return false;
            }
            else if (input.equals("!rate")){
                //String response = chatbotCore.rate(int notaChatbot, int notaUsuario);
                System.out.println("response");
                return true;
            }
            else{
                String response = "Disculpa, no he entendido el comando ingresado";
                System.out.println(response);
                chatbotCore.setUltimoMensajeChatbot(response);
                return false;
            }
        }
        else{
            String response = chatbotCore.sendMessage(input);
            if(chatbotCore.preguntarSiSeInicioBeginDialog()){
                System.out.println(response);
            }
            else{
                System.out.println("Debe iniciar con beginDialog");
            }
            
            return false;
        }
    }
    
}
