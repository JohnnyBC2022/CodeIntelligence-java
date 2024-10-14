package user;

import user.model.UserDTO;
import util.CSVHandler;

import java.util.List;

public class UserService {
    public UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void addUser(UserDTO userDTO) {
        this.userRepository.addUser(userDTO);
    }

    public List<UserDTO> readUsers() {
        return this.userRepository.getAllUsers();
    }

    public void deleteUserById(String id) {
        this.userRepository.deleteUserById(id);
    }

    public void updateUserById(UserDTO user) {
        this.userRepository.updateUserById(user);
    }


}
