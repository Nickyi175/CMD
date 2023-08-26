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
    private File dirAct;

    public CMD() {
        dirAct=new File(System.getProperty("user.dir"));
    }
    
    public String Escribir(String nombreArchivo, String txt) {
        File enArchivo=new File(dirAct, nombreArchivo);
        FileWriter escribir=null;
        try {
            escribir=new FileWriter(enArchivo);
            escribir.write(txt);
            return "TEXTO AÑADIDO";
        } catch (IOException e) {
            return "NO SE PUDO ESCRIBIR EN EL ARCHIVO";
        } finally {
            if (escribir!=null) {
                try {
                    escribir.close();
                } catch (IOException e) {
                    return "ERROR";
                }
            }
        }    
    }
    public String Leer(String nameArchivo) {
        File archivo = new File(dirAct, nameArchivo);
        BufferedReader lee = null;
        StringBuilder contenido = new StringBuilder();

        try {
            lee= new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea=lee.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            return "ERROR AL LEER ARCHIVO";
        } finally {
            if (lee!=null) {
                try {
                    lee.close();
                } catch (IOException e) {
                    return "ERROR";
                }
            }
        }
        return contenido.toString();
    }

    public String Time() {
        SimpleDateFormat tF=new SimpleDateFormat("HH:mm:ss");
        return "HORA ACTUAL: "+tF.format(new Date());
    }

    boolean Mkdir(String comando) {
        if(comando != null && !comando.isEmpty()){
            String ruta=System.getProperty("user.dir")+File.separator+comando;
            File nf=new File(ruta);
            if(nf.mkdir()){
                return true;
            }
        }  
        return false;
    }
    
    String cambio(String nameCarpeta) {
        File nuevoCarp = new File(dirAct, nameCarpeta);
        if (nuevoCarp.isDirectory()) {
            dirAct=nuevoCarp;
            return "CAMBIO: "+dirAct.getAbsolutePath();
        } else {
            return "CARPETA NO ENCONTRADA.";
        }
    }
   
    private String regreso(String folderName) {
        String parentPath=dirAct.getParent();
        if (parentPath != null) {
            dirAct=new File(parentPath);
            return "REGRESANDO: " + dirAct.getAbsolutePath();
        } else {
            return "ESTAS EN LA RAIZ";
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
        File[] lista = dirAct.listFiles();
        if (lista != null) {
            for (File a: lista) {//a es archivo
                String tipo;
                String bytes="";
                String nombre;
                if(a.isDirectory()){
                    tipo="<DIR>";
                }else{
                    tipo="     ";
                }
                if(a.isFile()){
                    bytes=String.valueOf(a.length());
                }
                nombre=a.getName();
                String fechaMod=new Date(a.lastModified()).toString();

                System.out.print(fechaMod+"\t"+tipo+"  "+bytes+"  "+nombre);
            }
        } else {
            System.out.println("NO SE LISTA");
        }
      
//        if(files.isDirectory()){
//            for (File c: files.listFiles()) {
//                System.out.print(new Date(c.lastModified()));
//                if(c.isDirectory()){
//                    System.out.print("\t<DIR>\t");
//                }
//                if(c.isFile()){
//                    System.out.print("\t     \t\n"+c.length());
//                }
//                System.out.println("."+c.getName());
//            }
//        }else{
//            System.out.println("COMANDO NO APTO");
//        }
        System.out.println("NO SALE");
    }
    String Rm(String eliminar) {
        File archDel=new File(dirAct,eliminar);
        if(archDel.exists()){
            if(archDel.isDirectory()){
                eliminar(archDel);
                return "CARPETA ELIMINADA";
            }else{
                archDel.delete();
                return "ARCHIVO ELIMINADO";
            }
        }
        return "ERROR";
    }
    private void eliminar(File carp){
        
    }
    boolean Mfile(String nameArch) throws IOException {
       // comando = comando.toLowerCase();
        File namArch=new File(dirAct,nameArch);
        try{
            return namArch.createNewFile();
        }catch(IOException e){
            return false;
        }
//         files = new File(nameArch);
//        return files.createNewFile();
//        if (comando.contains("mfile") && comando.contains(".txt")) {
//
//            String palabraABorrar = "mfile";
//            resultado = comando.replace(palabraABorrar, "");
//            files = new File(resultado);
//            System.out.println("se creo");
//            System.out.println(resultado);
//            return files.createNewFile();
//
//        } else {
//
//            System.out.println("Funcion no vasasasaasada");
//
//        }


    }

    void eliminarcarp(File vaciar) {
        if (vaciar.isDirectory()) {
            for (File vacio : vaciar.listFiles()) {
                vacio.delete();
            }
        }

    }

    String rmborrar(File borrar) {//preuba2
        if (borrar.isDirectory()) {
            for (File eliminar : borrar.listFiles()) {
                if (eliminar.isDirectory()) {
                    rmborrar(eliminar);
                } else {
                    eliminar.delete();
                }
            }
            borrar.delete(); 
            return "Carpeta Eliminada";
        } else if (borrar.isFile()) {
            borrar.delete();
            return "Archivo eliminado";
        }

        return "Error";
    }

    public String fecha() {
        Date dt = new Date();
        SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
        return "FECHA ACTUAL:\t"+df.format(dt);
    }
}
