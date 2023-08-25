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
    public static void main(String[] args) {
        CMD obj= new CMD();
        lea.delimiter();
        try{
//            obj.Escribir();
        }catch(InputMismatchException e){
            System.out.println("no valido");
        }catch(NullPointerException e){
            System.out.println("seleccioen");
        }
        
    }
}
