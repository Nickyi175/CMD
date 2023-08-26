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
     File dirAct;
    public CMD() {
        dirAct=new File(System.getProperty("user.dir"));
    }
    
    String cambio(String nameCarpeta) {//LSITO
        File nuevoCarp = new File(dirAct, nameCarpeta);
        if (nuevoCarp.isDirectory()) {
            dirAct=nuevoCarp;
            return "CAMBIO: "+dirAct.getAbsolutePath();
        } else {
            return "CARPETA NO ENCONTRADA.";
        }
    }
   
    public String regreso() {//regresa a todo nimodo LISTO
        String pP=dirAct.getParent();
        if (pP != null) {
            dirAct = new File(pP);
            return "REGRESANDO: "+dirAct.getAbsolutePath();
        } else {
            return "ESTAS EN LA RAIZ";
        }
    }

    public String Mfile(String filePath) {
        String mensaje = "";
        File archivo = new File(filePath);
        if (!archivo.exists()) {
             mensaje = "ARCH CREADO";
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                mensaje = "ERROR SELECCIONE CARPETA";
            }
            return mensaje;
            
        } else {
            mensaje = "YA EXISTE";
            return mensaje;
        }
    }

    public String Escribir(String nombreArchivo, String txt) {//LISTO
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
        File archivo=new File(dirAct, nameArchivo);
        BufferedReader lee=null;
        StringBuilder contenido=new StringBuilder();
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

    boolean Mkdir(String argss) {//LISTO
        if(argss != null && !argss.isEmpty()){
            String ruta=System.getProperty("user.dir")+File.separator+argss;
            File nf=new File(ruta);
            if(nf.mkdir()){
                return true;
            }
        }  
        return false;
    }

    public String listar() {
        String result = "";
        File[] lista = dirAct.listFiles();
        if (lista != null) {
            for (File a : lista) {
                String tipo = "";
                if (a.isDirectory()) {
                    tipo = "<DIR>";
                } else if (a.isFile()) {
                    tipo = "     ";
                }
                double bytes = 0;
                if (a.isFile()) {
                    bytes = a.length();
                }
                String nombre = a.getName();
                String fechaMod = new Date(a.lastModified()).toString();
                result+= fechaMod+"\t"+tipo+"\t"+bytes+"\t"+nombre+"\n";
            }
        } else {
            result = "NO SE LISTA\n";
        }
        return result;
    }

    String Rm(String eliminar) {
        File archDel = new File(dirAct, eliminar);
        if (archDel.exists()) {
            if (archDel.isDirectory()) {
                eliminarCarpeta(archDel); //llama eliminarCarpeta
                return "CARPETA ELIMINADA";
            } else {
                archDel.delete();
                return "ARCHIVO ELIMINADO";
            }
        }
        return "ARCHIVO O CARPETA NO EXISTE";
    }
    private void eliminarCarpeta(File carpeta) {//depende de rm
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    eliminarCarpeta(archivo);
                }
                archivo.delete();
            }
        }
        carpeta.delete();
    }

    public String fecha() {
        Date dt = new Date();
        SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
        return "FECHA ACTUAL:\t"+df.format(dt);
    }
}