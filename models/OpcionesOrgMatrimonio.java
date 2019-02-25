/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectochatbot.models;

/**
 *
 * @author nicolasquintanam
 */
public class OpcionesOrgMatrimonio {
    
    public String preguntarSiQuiereAyudaOrganizacion(){
        return "¿Quieres que te ayude a organizar tu matrimonio?";
    }
    
    public String preguntarPorBanqueteria(){
        return "Excelente... Comencemos.\nA través de este chat te ayudaré con lo básico que necesitas para tu matrimonio..." + 
                    "\nIremos verificando si tienes todo lo necesario, si no es así, te daremos opciones...\n" + 
                    "¿Tienes contratada la banqueteria y el lugar de evento?";
    }
    
    public String preguntarPorTraje(){
        return "¿Tienes comprado o reservado tu traje de novio, o bien tu futuro esposo ya lo tiene comprado?\n";
    }
    
    public String preguntarPorVestidoNovia(){
        return "¿Compraron el traje de novia o lo reservaron?\n";
    }
    
    public String preguntarPorFotografo(){
        return "¿Contrataron al fotógrafo que los acompañará ese día?\n";
    }
    
    public String preguntarSiSeCasaranPorIglesia(){
        return "¿Se casarán por la iglesia\n?";
    }
    
    
    public String preguntarPorIglesia(){
        return "¿Qué iglesia será donde se casarán?\n";
    }
    
    public String opcionesBanqueteria(){
        return "Aqui te presento algunas opciones de banquetería junto con lugares de evento\n\n"+
                "Opcion 1: Empresa Millenium\n"+
                "Ofrece un pack completo para tu matrimonio donde se incluye el lungar de evento llamado 'Millenium'\n"+
                "Además se incluye banquetería completa, con Dj, y todo para la decoración\n"+
                "Su precio es $26.000 por persona\n"+
                "Nro contacto: +56912345678\n\n"+
                "Opcion 2: Empresa Los Naranjos\n"+
                "Ofrece un pack completo para tu matrimonio donde se incluye el lungar de evento llamado 'Los Naranjos'\n"+
                "Además se incluye banquetería completa, con Dj, bebidas y música\n"+
                "Su precio es $28.000 por persona\n"+
                "Nro contacto: +56998765432 \n\n";
    }
    
    public String opcionesTraje(){
        return "Aqui te presento algunas opciones donde puedes encontrar el traje ideal\n\n"+
                "Opcion 1: La Casa Blanca\n"+
                "La Casa Blanca es una prestigiosa empresa dedicada a la venta de vestidos de novia y trajes de novio\n"+
                "Además puedes encontrar diferentes accesorios, para que el novio se vea excelente...\n"+
                "Nro contacto: +56223579876\n\n"+
                "Opcion 2: Arrow\n"+
                "Arrow es una empresa dedicada a la venta de trajes de novio, al igual que accesorios de éste...\n"+
                "Tiene diferentes ofertas y promociones, si llamas indicando el código 'MATRIMONIO2018'\n"+
                "Nro contacto: +56229876787\n\n";
    }
    
    public String opcionesVestido(){
        return "Aqui te presento algunas opciones donde puedes encontrar el vestido ideal\n\n"+
                "Opcion 1: La Casa Blanca\n"+
                "La Casa Blanca es una prestigiosa empresa dedicada a la venta de vestidos de novia y trajes de novio\n"+
                "Además puedes encontrar diferentes accesorios, para que el novio o la novia se vean excelentes...\n"+
                "Nro contacto: +56223579876\n\n"+
                "Opcion 2: Santo Encanto\n"+
                "Santo Encanto es una tienda dedicada a la venta exclusivamente de vestidos de novia...\n"+
                "Puedes encontrar diseños exclusivos y grandes promociones\n"+
                "Nro contacto: +5698872859\n\n";
    }
    
    public String opcionesFotografo(){
        return "Te presento algunas opciones de fotografo que puedes considerar\n\n"+
                "Opcion 1: FotoEventos\n"+
                "FotoEventos es un grupo de fotografos que se dedica a tomar fotos en eventos, pero especialmente en matrimonios...\n"+
                "Si contratas con ellos, te puedes llevar un photobook de regalo...\n"+
                "Nro contacto: +56998872399\n\n"+
                "Opcion 2: Gran Dia\n"+
                "Gran Dia es una empresa de fotografia dedicada a como lo dice su nombre al Gran Dia...\n"+
                "Obten descuentos exclusivos y grandes promociones...\n"+
                "Nro contacto: +56988772345\n\n";
    }
    
    public String queOpcionElegir(){
        return "¿Que opción te gustaría añadir a tus preferencias?";
    }
    
    public String obtenerOpcionBanquetera(String mensaje){
        switch(mensaje){
            case "La 1": return "Millenium";
            case "1": return "Millenium";
            case "Opcion 1": return "Millenium";
            case "Opción 1": return "Millenium";
            case "Empresa Millenium": return "Millenium";
            case "Millenium": return "Millenium";
            case "La opción 1": return "Millenium";
            case "La opcion 1": return "Millenium";
            case "la 1": return "Millenium";
            case "opcion 1": return "Millenium";
            case "opción 1": return "Millenium";
            case "empresa Millenium": return "Millenium";
            case "empresa millenium": return "Millenium";
            case "millenium": return "Millenium";
            case "la opcion 1": return "Millenium";
            case "la opción 1": return "Millenium";
            
            case "La 2": return "Los Naranjos";
            case "2": return "Los Naranjos";
            case "Opcion 2": return "Los Naranjos";
            case "Opción 2": return "Los Naranjos";
            case "Empresa Los Naranjos": return "Los Naranjos";
            case "Empresa Los naranjos": return "Los Naranjos";
            case "Los Naranjos": return "Los Naranjos";
            case "Los naranjos": return "Los Naranjos";
            case "La opción 2": return "Los Naranjos";
            case "La opcion 2": return "Los Naranjos";
            case "la 2": return "Los Naranjos";
            case "opcion 2": return "Los Naranjos";
            case "opción 2": return "Los Naranjos";
            case "empresa Los Naranjos": return "Los Naranjos";
            case "empresa los naranjos": return "Los Naranjos";
            case "empresa Los naranjos": return "Los Naranjos";
            case "los naranjos": return "Los Naranjos";
            case "la opcion 2": return "Los Naranjos";
            case "la opción 2": return "Los Naranjos";
            
            default: return mensaje;
        }
    }
    
    public String obtenerOpcionEmpresaTraje(String mensaje){
        switch(mensaje){
            case "La 1": return "La Casa Blanca";
            case "1": return "La Casa Blanca";
            case "Opcion 1": return "La Casa Blanca";
            case "Opción 1": return "La Casa Blanca";
            case "La Casa Blanca": return "La Casa Blanca";
            
            case "La 2": return "Arrow";
            case "2": return "Arrow";
            case "Opcion 2": return "Arrow";
            case "Opción 2": return "Arrow";
            case "Arrow": return "Arrow";
            
            default: return mensaje;
        }
    }
    
    public String obtenerOpcionEmpresaVestido(String mensaje){
        switch(mensaje){
            case "La 1": return "La Casa Blanca";
            case "1": return "La Casa Blanca";
            case "Opcion 1": return "La Casa Blanca";
            case "Opción 1": return "La Casa Blanca";
            case "La Casa Blanca": return "La Casa Blanca";
            
            case "La 2": return "Santo Encanto";
            case "2": return "Santo Encanto";
            case "Opcion 2": return "Santo Encanto";
            case "Opción 2": return "Santo Encanto";
            case "Santo Encanto": return "Santo Encanto";
            case "santo encanto": return "Santo Encanto";
            case "Santo encanto": return "Santo Encanto";
            
            default: return mensaje;
        }
    }
    
    public String obtenerOpcionEmpresaFotografia(String mensaje){
        switch(mensaje){
            case "La 1": return "FotoEventos";
            case "1": return "FotoEventos";
            case "Opcion 1": return "FotoEventos";
            case "Opción 1": return "FotoEventos";
            case "FotoEventos": return "FotoEventos";
            case "fotoeventos": return "FotoEventos";
            case "Fotoeventos": return "FotoEventos";
            case "foto eventos": return "FotoEventos";
            
            case "La 2": return "Gran dia";
            case "2": return "Gran dia";
            case "Opcion 2": return "Gran dia";
            case "Opción 2": return "Gran dia";
            case "Gran Dia": return "Gran dia";
            case "gran dia": return "Gran dia";
            case "Gran dia": return "Gran dia";
            case "Gran día": return "Gran dia";
            case "Gran Día": return "Gran dia";
            
            default: return mensaje;
        }
    }
    
    
    
    
    
    
}


