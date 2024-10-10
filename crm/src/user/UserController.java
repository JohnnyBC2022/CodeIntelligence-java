package user;

import user.model.UserDTO;

import java.util.List;

public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<UserDTO> findAll(){
        return this.userService.findAll();
    }
}
