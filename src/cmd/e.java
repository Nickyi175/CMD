/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;
import java.util.*;
import java.io.*;

public class e {
    /*
Consola de comandos: consola de comandos que imite el funcionamiento de CMD de Windows, mostrando la carpeta actual y teniendo las funciones siguientes:

Mkdir <nombre>: Nueva carpeta
Mfile <nombre.ext>:Nuevo archivo
Rm <nombre>: Eliminar carpeta y archivo.
Cd <nombre carpeta>: Cambiar de carpeta actual
<...>  Regresar de Carpeta
Dir: Listar todas las carpetas y archivos en la carpeta actual
Date: Ver fecha actual
Time: Ver hora actual
Escribir<wr >: Debe ingresar un texto al archivo seleccionado.
Leer<rd >: Debe seleccionar un archivo para mostrar lo que contiene.

    */
    private void regreso(String folderName){
//        String parentPath = mifile.getParent();
//        if (parentPath != null) {
//            mifile = new File(parentPath);
//            System.out.println("Regresando a la carpeta anterior: " + mifile.getAbsolutePath());
//        } else {
//            System.out.println("Ya estás en la raíz del sistema.");
//        }
//op 2
//         File volver = new File(dirActual, folderName);
//        if (volver.isDirectory()) {
//            dirActual=volver;
//            System.out.println("Back to: "+dirActual.getAbsolutePath());
//        } else {
//            System.out.println("NO PUEDO VOLVER :l");
//        }
    
    }
    private void listar(){
        /*
        if(mifile.isDirectory()){
            for (File c: mifile.listFiles()) {
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
    
        */
        System.out.println("NO SALE");//+f.getAbsolutePath()+"\nBytes: "+mifile.length());
    }
    private void fecha(){
        Date dt=new Date();
        System.out.println("Fecha actual:\t"+dt);
    }
}
