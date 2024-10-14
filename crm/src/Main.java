package util;

import user.UserController;
import user.model.UserDTO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        UserDTO user = new UserDTO("25", "Juan", "juan@mail.com", 27, null, null);

//        userController.readUsers();
//        userController.createUser(user);
//        userController.updateUser(user);
//        userController.deleteUser(user.getId());
    }
}
