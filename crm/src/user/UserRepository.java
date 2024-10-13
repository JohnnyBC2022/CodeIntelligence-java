package user;

import user.model.UserDTO;
import util.CSVHandler;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private CSVHandler csvHandler;

    public UserRepository() {
        this.csvHandler = new CSVHandler();
    }

    public void addUser(UserDTO userDTO) {
        csvHandler.writeNewUserLine(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getAge());
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        return users;
    }

    public void deleteUserById(String id) {
        csvHandler.deleteUserById(id);
    }

    public void updateUserById(String id, String newName, String newEmail, int newAge) {
        csvHandler.updateUserById(id, newName, newEmail, newAge);
    }
}
