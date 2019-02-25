package proyectochatbot.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Archivo {

    

    String ruta = "/home/nicolasquintanam/desktop/archivo.txt";
    
    public static void escribirArchivo(List<String> lista, String ruta) throws IOException{
        File archivo = new File(ruta);
        BufferedWriter bw;
        int i;
        bw = new BufferedWriter(new FileWriter(archivo));
        for(i = 0; i < lista.size(); i++){
            
            bw.write(lista.get(i));
            bw.write("\n\n");
            System.out.println(lista.get(i));
        } 
        bw.close();
        
    }
    
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null){
            System.out.println(cadena);
        }
        b.close();
    }
    
    public static String obtenerNombreUsuario(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String usuario = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
                //System.out.println(cadena);
                if(i == 2){
                    i++;
                    if(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario")){
                        usuario = cadena.substring(31,cadena.length());
                    }
                }
                if(i == 1){
                    i++;
                }
                if(cadena.length() >= 32 && cadena.substring(31,cadena.length()).equals("Hola, bienvenido ¿Me puedes indicar cómo te llamas?")){   
                    i++;
                }
        }
        return usuario;
    }
    
    public static String obtenerNombreFuturaEsposa(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String esposa = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
                
                if(i == 2){
                    i++;
                    
                    if(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario")){
                        esposa = cadena.substring(31,cadena.length());
                    }
                }
                if(i == 1){
                    i++;
                }
                if(cadena.length() >= 32 && cadena.substring(31,cadena.length()).equals("Para comenzar, ¿me podrías indicar el nombre de tu futuro/a esposo/a?")){   
                    i++;
                }
        }
        return esposa;
    }
    
    public static String obtenerAñoMatrimonio(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String año = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
                
                if(i == 2){
                    i++;
                    
                    if(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario")){
                        año = cadena.substring(31,cadena.length());
                    }
                }
                if(i == 1){
                    i++;
                }
                if(cadena.length() >= 41 && cadena.substring(cadena.length()-41,cadena.length()).equals("Me podrías indicar en qué año se casarán?")){   
                    i++;
                }
        }
        return año;
    }
    
    public static String obtenerMesMatrimonio(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String mes = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
                
                if(i == 2){
                    i++;
                    
                    if(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario")){
                        mes = cadena.substring(31,cadena.length());
                    }
                }
                if(i == 1){
                    i++;
                }
                if(cadena.length() >= 60 && cadena.substring(31,cadena.length()).equals("Bien, Qué mes será el matrimonio?")){   
                    i++;
                }
        }
        return mes;
    }
    
    public static String obtenerDiaMatrimonio(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String dia = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                if(i == 2){
                    i++;
                    
                    if(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario")){
                        dia = cadena.substring(31,cadena.length());
                    }
                }
                if(i == 1){
                    i++;
                }
                if(cadena.length() >= 50 && cadena.substring(31,cadena.length()).equals("Por ultimo, Que dia será?")){   
                    i++;
                }
        }
        return dia;
    }
    
    public static String obtenerTenenciaBanqueteria(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String tieneBanqueteria = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    tieneBanqueteria = cadena.substring(31,cadena.length());
                    
                }
                
                
                if(cadena.length() >= 54 && cadena.substring(31,55).equals("Excelente... Comencemos.")){   
                    i++;
                    
                }
        }
        return tieneBanqueteria;
    }
    
    public static String obtenerPreferenciaBanqueteria(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String preferenciaBanqueteria = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    preferenciaBanqueteria = cadena.substring(31,cadena.length());
                    
                }
                
                if(cadena.length() >= 79 && cadena.substring(31,79).equals("Aqui te presento algunas opciones de banquetería")){   
                    i++;
                }
        }
        return preferenciaBanqueteria;
    }
    
    public static String obtenerTenenciaTraje(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String tieneTraje = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    tieneTraje = cadena.substring(31,cadena.length());
                    
                }
                
                
                
                if(cadena.length() >= 74 && cadena.substring(31,74).equals("Que bien, ya tienes agregada la banqueteria")){   
                    i++;
                    
                }
        }
        return tieneTraje;
    }
    
    public static String obtenerPreferenciaTraje(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String preferenciaTraje = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    preferenciaTraje = cadena.substring(31,cadena.length());
                    
                }
                
                /*if(cadena.length() >= 102){
                    System.out.println(cadena.substring(31,102));
                }*/
                
                if(cadena.length() >= 102 && cadena.substring(31,102).equals("Aqui te presento algunas opciones donde puedes encontrar el traje ideal")){   
                    i++;
                }
        }
        return preferenciaTraje;
    }
    
    public static String obtenerTenenciaVestido(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String tieneVestido = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    tieneVestido = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 90){
                    System.out.println(cadena.substring(31,90));
                }*/
                
                
                if(cadena.length() >= 90 && cadena.substring(31,90).equals("Anotada en tus preferencias... ¿Compraron el traje de novia")){   
                    i++;
                    
                }
        }
        return tieneVestido;
    }
    
    public static String obtenerPreferenciaVestido(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String preferenciaVestido = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    preferenciaVestido = cadena.substring(31,cadena.length());
                    
                }
                
                if(cadena.length() >= 104){
                    //System.out.println(cadena.substring(31,104));
                }
                
                if(cadena.length() >= 104 && cadena.substring(31,104).equals("Aqui te presento algunas opciones donde puedes encontrar el vestido ideal")){   
                    i++;
                }
        }
        return preferenciaVestido;
    }
    
    public static String obtenerTenenciaFotografo(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String tieneFotografo = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    tieneFotografo = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 109){
                    System.out.println(cadena.substring(31,109));
                }*/
                
                
                if(cadena.length() >= 109 && cadena.substring(31,109).equals("Muy bien, lo agregué a tus preferencias, continuemos ¿Contrataron al fotógrafo")){   
                    i++;
                    
                }
        }
        return tieneFotografo;
    }
    
    public static String obtenerPreferenciaFotografo(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String preferenciaFotografo = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    preferenciaFotografo = cadena.substring(31,cadena.length());
                    
                }
               
                
                if(cadena.length() >= 72 && cadena.substring(31,72).equals("Te presento algunas opciones de fotografo")){   
                    i++;
                }
        }
        return preferenciaFotografo;
    }
    
    public static String obtenerSiSeCasaranPorIglesia(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String seCasanIglesia = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    seCasanIglesia = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 87){
                    System.out.println(cadena.substring(31,87));
                }*/
                
                
                if(cadena.length() >= 87 && cadena.substring(31,87).equals("Anotado en tus preferencias...¿Se casarán por la iglesia")){   
                    i++;
                    
                }
        }
        return seCasanIglesia;
    }
    
    public static String obtenerQueIglesia(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String queIglesia = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    queIglesia = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 82){
                    System.out.println(cadena.substring(31,82));
                }*/
                
                
                if(cadena.length() >= 82 && cadena.substring(31,82).equals("Que bien, se casarán por la iglesia... ¿Qué iglesia")){   
                    i++;
                    
                }
        }
        return queIglesia;
    }
    
    
    public static String obtenerEmpresaBanqueteraContratada(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String empresaBanquetera = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    empresaBanquetera = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 100){
                    System.out.println(cadena.substring(31,100));
                }*/
                
                
                if(cadena.length() >= 100 && cadena.substring(31,100).equals("Ok, entiendo... ¿me puedes indicar el nombre de la empresa banquetera")){   
                    i++;
                    
                }
        }
        return empresaBanquetera;
    }
    
    public static String obtenerEmpresaTrajeContratada(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String empresaTraje = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    empresaTraje = cadena.substring(31,cadena.length());
                    
                }
                /*if(cadena.length() >= 116){
                    System.out.println(cadena.substring(31,116));
                }*/
                
                
                if(cadena.length() >= 116 && cadena.substring(31,116).equals("Ok, entiendo... ¿me puedes indicar el nombre de la empresa donde contrataste el traje")){   
                    i++;
                    
                }
        }
        return empresaTraje;
    }
    
    public static String obtenerEmpresaVestidoContratada(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String empresaVestido = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    empresaVestido = cadena.substring(31,cadena.length());
                    
                }
                
                
                
                if(cadena.length() >= 118 && cadena.substring(31,118).equals("Ok, entiendo... ¿me puedes indicar el nombre de la empresa donde contrataron el vestido")){   
                    i++;
                    
                }
        }
        return empresaVestido;
    }
    
    public static String obtenerEmpresaFotografoContratada(String archivo) throws FileNotFoundException, IOException{
        File a = new File(archivo);
        String cadena;
        String empresaFotografo = "no se puede";
        int i = 0;
        FileReader f = new FileReader(a);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null){
            
                
                
                if(i == 1){
                    while(!(cadena.length() >= 30 && cadena.substring(22,29).equals("Usuario"))){
                        cadena = b.readLine();
                        i++;
                    }
                    empresaFotografo = cadena.substring(31,cadena.length());
                    
                }
                
                
                
                if(cadena.length() >= 100 && cadena.substring(31,100).equals("Ok, entiendo... ¿me puedes indicar el nombre la empresa de fotografia")){   
                    i++;
                    
                }
        }
        return empresaFotografo;
    }
    
    
    
    
    
}