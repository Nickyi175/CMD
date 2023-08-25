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
   Scanner leer = new Scanner(System.in).useDelimiter("\n"); 
   File mifile;
   String direccion;

    public CMD() {
        this.mifile = new File(direccion);
    }
void Escribir(File mifile) throws IOException{
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


 void Leer(File mifile){
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
 
 static void Time(){
//     if(.equalsIgnoreCase("Time")){
     SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
     System.out.println("Current time: " + timeFormat.format(new Date()));
// }              
 }
//    
    
}
