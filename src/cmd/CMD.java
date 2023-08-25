package cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CMD {

    Scanner leer = new Scanner(System.in);
    File files;
    String direccion;
    
    public CMD() {
        this.files = new File(direccion);
    }
    
    public String Escribir(String direccion,String texto) throws IOException {
        File files=new File(direccion);
        String text;
        if (files.exists()) {
            if (files.isFile()) {
                try {

                    FileWriter fr = new FileWriter(files);
                    fr.write(texto);
                    fr.flush();
                } catch (IOException e) {
                 text="Error: no se pudo crear";
                }
                text = "Escritura completada";
                return text;
            } else {
                text = "Error: debe seleccionar un archivo";
                return text;
            }
        } else {
            text = "Error: Archivo inexistente";
        return text;
        }

//        if (files.exists()) {
//            System.out.println("No existe");
//            return;
//        }
////        FileWriter writer = new FileWriter(mifile, true);
//        String line;
//        while (true) {
//            line = leer.nextLine();
//            if (line.isEmpty()) {
//                break;
//            }
//            writer.write(line);
//            writer.write(System.lineSeparator());
//        }
//        writer.close();
//
    }
    public String Leer(String direccion,String comando) {
        comando=comando.toLowerCase();
        if(comando.contains("rd")){
         String direction;
         String palabraABorrar = "rd";
         direction = comando.replace(palabraABorrar, "");
        File files =new File(direction);
        String texto = "";
        if (files.exists()) {
            if (files.isFile()) {
                try {
                    FileReader lea = new FileReader(files);
                    String contenido = "";
                    for (int i = lea.read(); i != -1; i = lea.read()) {
                        contenido += (char) i;
                    }
                    return contenido;
                    
                } catch (IOException e) {
                    texto="Error";
                }
                texto = "¡Completado!";
                return texto;
            } else {
                texto = "Ningún archivo fue seleccionado";
                return texto;
            }
        } else {
            texto = "No existe el archivo";
            return texto;
        }
    }
        return null;
    }

    static void Time(String comando) {
        comando = comando.toLowerCase();
        
        if(comando.contains("Time")){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Current time: " + timeFormat.format(new Date()));
        } else{
          System.out.println("Funcion no valida");  
        }             
    }

    boolean Mkdir(String comando) {

        comando = comando.toLowerCase();
        String resultado;
        if (comando.contains("mkdir")) {

            String palabraABorrar = "mkdir";
            resultado = comando.replace(palabraABorrar, "");
            System.out.println("se creo");
            System.out.println(resultado);
            direccion=resultado;
            return files.mkdir();

        } else {

            System.out.println("Funcion no valida");

        }

        return false;
    }
    void CambiarDirectorio(String nombreCarpeta) {
        File nuevoDirectorio = new File(files, nombreCarpeta);
        if (nuevoDirectorio.isDirectory()) {
            files = nuevoDirectorio;
            System.out.println("Cambiado a: " + files.getAbsolutePath());
        } else {
            System.out.println("Carpeta no encontrada.");
        }
    }
    
    void RegresarDirectorio() {
        String parentPath = files.getParent();
        if (parentPath != null) {
            files = new File(parentPath);
            System.out.println("Regresando a: " + files.getAbsolutePath());
        } else {
            System.out.println("Ya estás en la raíz.");
        }
    }
   
    private void regreso(String folderName) {
        String parentPath=files.getParent();
        if (parentPath != null) {
            files = new File(parentPath);
            System.out.println("Regresando a la carpeta anterior: " + files.getAbsolutePath());
        } else {
            System.out.println("ESTAS EN LA RAIZ");
        }
         File volver = new File(files, folderName);
        if (volver.isDirectory()) {
            files=volver;
            System.out.println("Vuelta: "+files.getAbsolutePath());
        } else {
            System.out.println("NO PUEDO VOLVER :l");
        }
    }

    private void listar() {
        if(files.isDirectory()){
            for (File c: files.listFiles()) {
                System.out.print(new Date(c.lastModified()));
                if(c.isDirectory()){
                    System.out.print("\t<DIR>\t");
                }
                if(c.isFile()){
                    System.out.print("\t     \t\n"+c.length());
                }
                System.out.println("."+c.getName());
            }
        }else{
            System.out.println("Comando no apto");
        }
        System.out.println("NO SALE"+files.getAbsolutePath());
    }
    private void fecha() {
        Date dt = new Date();
        System.out.println("Fecha actual:\t" + dt);
    }
}
