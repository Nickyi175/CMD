/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tomea
 */
public class probar {
    static Scanner lea= new Scanner(System.in);
    static String direccion,mensaje;
    public static void main(String[] args) throws IOException {
        CMD obj= new CMD();
//        lea.delimiter();
        try{
//            direccion=lea.nextLine()
String dir="ok1";
String arch="us.txt";
            obj.Mkdir(dir);
            obj.Mfile(arch);
            obj.Escribir(dir, arch,"mimamamemima");
        }catch(InputMismatchException e){
            System.out.println("no valido");
        }catch(NullPointerException e){
            System.out.println("seleccione");
        }finally{
            lea.close();
        }
                
        
    }
}
