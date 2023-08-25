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
    String direccion="";
    
    
    
    public String Escribir(String direccion,String texto,String comando){
        File files=new File(direccion);
        String text;
        comando=comando.toLowerCase();
        if(comando.contains("wr")){
            String direction;
           String palabraABorrar = "wr";
         direction = comando.replace(palabraABorrar, "");
        if (files.exists()) {
            if (files.isFile()) {
                try {

                    FileWriter escriba = new FileWriter(files);
                    escriba.write(texto);
                    escriba.flush();
                    text = "¡Completado!";
                } catch (IOException e) {
                 text="No se creo";
                }   
            } else {
                text = "Archivo no seleccionado";
                return text;
            }
        } else {
            text = "No existe el archivo";
        }
        return text;
        }
        return null;
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
        
        if(comando != null && !comando.isEmpty()){
            String ruta=System.getProperty("user.dir")+File.separator+comando;
            File nf=new File(ruta);
            if(nf.mkdir()){
                System.out.println("SE CREO CARPETA");
                return true;
            }else{
                System.out.println("NO SE PUDO CREAR");
            }
        }else{
            System.out.println("Funcion no valida");
        }  

        return false;
    }
    
    
    void cambio(String nombreCarpeta) {
        File nuevoD = new File(files, nombreCarpeta);
        if (nuevoD.isDirectory()) {
            files = nuevoD;
            System.out.println("CAMBIO: " + files.getAbsolutePath());
        } else {
            System.out.println("CARPETA NO ENCONTRADA.");
        }
    }
   
    private void regreso(String folderName) {
        String parentPath=files.getParent();
        if (parentPath != null) {
            files = new File(parentPath);
            System.out.println("REGRESANDO: " + files.getAbsolutePath());
        } else {
            System.out.println("ESTAS EN LA RAIZ");
        }
//         File volver = new File(files, folderName);
//        if (volver.isDirectory()) {
//            files=volver;
//            System.out.println("Vuelta: "+files.getAbsolutePath());
//        } else {
//            System.out.println("NO PUEDO VOLVER :l");
//        }
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
            System.out.println("COMANDO NO APTO");
        }
        System.out.println("NO SALE"+files.getAbsolutePath());
    }
    boolean Rm(String comando) {

        comando = comando.toLowerCase();
        String resultado;
        if (comando.contains("rm")) {
            String palabraABorrar = "rm";
            resultado = comando.replace(palabraABorrar, "");
            files = new File(resultado);
            if (files.exists()) {
                    eliminarcarp(files);
                    rmborrar(files);
                System.out.println(""+files);
                System.out.println(""+resultado);
            } else {

                System.out.println("no existe!");
            }

            return true;
        }
        return false;
    }
    boolean Mfile(String comando) throws IOException {
        comando = comando.toLowerCase();
        String resultado;
        if (comando.contains("mfile") && comando.contains(".txt")) {

            String palabraABorrar = "mfile";
            resultado = comando.replace(palabraABorrar, "");
            files = new File(resultado);
            System.out.println("se creo");
            System.out.println(resultado);
            return files.createNewFile();

        } else {

            System.out.println("Funcion no valida");

        }

        return false;

    }

    void eliminarcarp(File vaciar) {
        if (vaciar.isDirectory()) {
            for (File vacio : vaciar.listFiles()) {
                vacio.delete();
            }
        }

    }

    String rmborrar(File borrar) {
        if (borrar.isDirectory()) {
            for (File eliminar : borrar.listFiles()) {
                if (eliminar.isDirectory()) {
                    eliminarcarp(eliminar);
                    eliminar.delete();
                } else {
                    eliminar.delete();
                }
            }
            borrar.delete();
            return "Carpeta Eliminada";
        }else if(borrar.isFile()){
            borrar.delete();
            return "Archivo eliminado";
        }

        return "Error";
    }
    private void fecha() {
        Date dt = new Date();
        System.out.println("FECHA ACTUAL:\t" + dt);
    }
}
