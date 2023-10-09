package Cifrado;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CifradoSuperHacker {
    private static final String FILENAME = "password.txt";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Crear nueva contraseña");
        System.out.println("2. Acceder con contraseña");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                createPassword();
                break;
            case 2:
                if (checkPassword()) {
                    System.out.println("Acceso concedido.");
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
                break;
            case 3:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                break;
        }
    }

    private static void createPassword() throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la nueva contraseña: ");
        String password = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            writer.println(hashPassword(password));
            System.out.println("Contraseña almacenada con éxito.");
        }
    }

    private static boolean checkPassword() throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la contraseña: ");
        String enteredPassword = scanner.nextLine();

        String storedPassword;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            storedPassword = reader.readLine();
        }

        return storedPassword != null && storedPassword.equals(hashPassword(enteredPassword));
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
