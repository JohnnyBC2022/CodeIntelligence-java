package user;

import user.model.UserDTO;
import java.util.Scanner;

public class UserController {
    private final UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del usuario:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del usuario:");
        String name = scanner.nextLine();
        System.out.println("Ingrese el email del usuario:");
        String email = scanner.nextLine();
        System.out.println("Ingrese la edad del usuario:");
        int age = Integer.parseInt(scanner.nextLine());

        UserDTO userDTO = new UserDTO(id, name, email, age, null, null);
        userService.addUser(userDTO);
        System.out.println("Usuario añadido exitosamente.");
    }

    public void readUsers() {
        System.out.println("Lista de usuarios:");
        userService.readUsers();
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del usuario a eliminar:");
        String id = scanner.nextLine();
        userService.deleteUserById(id);
    }

    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del usuario a actualizar:");
        String id = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del usuario:");
        String newName = scanner.nextLine();

        System.out.println("Ingrese el nuevo email del usuario:");
        String newEmail = scanner.nextLine();

        System.out.println("Ingrese la nueva edad del usuario:");
        int newAge = Integer.parseInt(scanner.nextLine());

        userService.updateUserById(id, newName, newEmail, newAge);
    }
}
