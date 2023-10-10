package Cifrado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cifrado2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombreArchivo = "password.txt";

        boolean archivoExiste = new File(nombreArchivo).exists();

        try {
            if (!archivoExiste) {
                System.out.println("No se ha establecido una contraseña previamente.");
                System.out.print("Por favor, ingrese una contraseña: ");
                String nuevaContrasena = scanner.nextLine();

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(nuevaContrasena.getBytes());

                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
                for (byte b : hash) {
                    writer.write(String.format("%02x", b));
                }
                writer.close();

                System.out.println("Contraseña establecida con éxito.");
            }

            System.out.print("Ingrese la contraseña para acceder al archivo: ");
            String contraseñaIngresada = scanner.nextLine();

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashIngresado = md.digest(contraseñaIngresada.getBytes());

            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String hashAlmacenado = reader.readLine();
            reader.close();

            String hashIngresadoStr = bytesToHex(hashIngresado);
            if (hashIngresadoStr.equals(hashAlmacenado)) {
                System.out.println("Contraseña correcta. Acceso permitido al archivo.");

            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println("Error en el hash: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
