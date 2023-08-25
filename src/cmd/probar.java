/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tomea
 */
public class probar {
    static Scanner lea= new Scanner(System.in);
    static String direccion,mensaje;
    public static void main(String[] args) {
        CMD obj= new CMD();
//        lea.delimiter();
        try{
//            direccion=lea.nextLine();
            obj.Mkdir("user.txt");
            mensaje=lea.nextLine();
            obj.Escribir(mensaje, "si",mensaje);
        }catch(InputMismatchException e){
            System.out.println("no valido");
        }catch(NullPointerException e){
            System.out.println("seleccione");
        }finally{
            lea.close();
        }
                
        
    }
}
