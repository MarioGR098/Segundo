package Cifrado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cifrado1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombreArchivo = "contrasena.txt";

        boolean archivoExiste = new File(nombreArchivo).exists();

        try {
            if (!archivoExiste) {
                System.out.println("No se ha establecido una contraseña previamente.");
                System.out.print("Por favor, ingrese una contraseña: ");
                String nuevaContrasena = scanner.nextLine();

                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
                writer.write(nuevaContrasena);
                writer.close();

                System.out.println("Contraseña establecida con éxito.");
            }

            System.out.print("Ingrese la contraseña para acceder al archivo: ");
            String contraseñaIngresada = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String contraseñaAlmacenada = reader.readLine();
            reader.close();

            if (contraseñaIngresada.equals(contraseñaAlmacenada)) {
                System.out.println("Contraseña correcta. Acceso permitido al archivo.");
            } else {
                System.out.println("Contraseña incorrecta. Acceso denegado.");
            }
        } catch (IOException e) {
            System.out.println("Error en el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
