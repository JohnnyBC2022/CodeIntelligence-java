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

    public void leerUsuarios() {
        System.out.println("Lista de usuarios:");
        userService.leerUsuarios();
    }
}
