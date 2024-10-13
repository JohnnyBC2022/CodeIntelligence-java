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
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                userController.createUser();
            } else if (opcion == 2) {
                userController.leerUsuarios();
            } else if (opcion == 3) {
                userController.eliminarUsuario();
            } else if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
