package cmd;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class probar {
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        CMD obj = new CMD();

        try {
            String dir = "yes";
            String arch = "UFO.txt";
            obj.Mkdir(dir);
            String filePath = dir+File.separator+arch;
            obj.Mfile(filePath);
            obj.Escribir(filePath, "CHEESE");

            String contenido = obj.Leer(filePath);
            System.out.println("Contenido del archivo:");
            System.out.println(contenido);

            System.out.println(obj.Time());
            System.out.println(obj.fecha());
            System.out.println(obj.listar());

            System.out.println(obj.cambio("ok"));
            System.out.println(obj.listar());
            System.out.println(obj.regreso());

            String eliminar = "ok";
            String resultadoEliminar = obj.Rm(eliminar);
            System.out.println(resultadoEliminar);

            System.out.println("Despues de eliminar:");
            System.out.println(obj.listar());
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida");
        } catch (NullPointerException e) {
            System.out.println("Seleccion nula");
        } finally {
            lea.close();
        }
    }
}