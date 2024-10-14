package user;

import user.model.UserDTO;
import util.CSVHandler;

import java.util.List;

public class UserService {
    private final CSVHandler csvHandler;

    public UserService() {
        this.csvHandler = new CSVHandler();
    }

    public void addUser(UserDTO userDTO) {

        csvHandler.writeNewUserLine(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getAge());
    }

    public void readUsers() {
        csvHandler.readFile();
    }

    public void deleteUserById(String id) {
        csvHandler.deleteUserById(id);
    }

    public void updateUserById(String id, String newName, String newEmail, int newAge) {

        csvHandler.updateUserById(id, newName, newEmail, newAge);
    }


}
