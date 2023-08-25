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
    
    void Escribir(File mifile) throws IOException {
//    if(.equalsIgnoreCase("Escribir<wr>")){
        if (!mifile.isDirectory()) {
            System.out.println("No existe");
            return;
        }
        FileWriter writer = new FileWriter(mifile, true);
        String line;
        while (true) {
            line = leer.nextLine();
            if (line.isEmpty()) {
                break;
            }
            writer.write(line);
            writer.write(System.lineSeparator());
        }
        writer.close();
//}
    }
    void Leer(File mifile) {
        try {
//        if(.equalsIgnoreCase("Leer<rd>")){
            if (!mifile.exists()) {
                System.out.println("Archivo no encontrado");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(mifile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
//    }
        } catch (IOException ex) {
            Logger.getLogger(CMD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void Time() {
//     if(.equalsIgnoreCase("Time")){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Current time: " + timeFormat.format(new Date()));
// }              
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
