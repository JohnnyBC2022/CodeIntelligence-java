package user;

import user.model.UserDTO;
import java.util.Scanner;

public class UserController {
    private final UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void createUser(UserDTO userDto) {
        userService.addUser(userDto);
    }

    public void readUsers() {
        userService.readUsers();
    }

    public void deleteUser(String id) {
        userService.deleteUserById(id);
    }

    public void updateUser(UserDTO userDto) {
        userService.updateUserById(userDto);
    }
}
