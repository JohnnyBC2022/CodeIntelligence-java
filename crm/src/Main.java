package util;

import user.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Crear usuario");
            System.out.println("2. Leer usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Salir");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue; // Salta a la siguiente iteración del bucle
            }

            switch (opcion) {
                case 1:
                    userController.createUser();
                    break;
                case 2:
                    userController.readUsers();
                    break;
                case 3:
                    userController.deleteUser();
                    break;
                case 4:
                    userController.updateUser();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;                 default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
