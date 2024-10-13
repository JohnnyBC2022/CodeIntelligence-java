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
        // Lógica para añadir el usuario (por ejemplo, escribir en el CSV)
        csvHandler.writeNewUserLine(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getAge());
    }

    public void leerUsuarios() {
        csvHandler.leerArchivo();
    }

    public void eliminarUsuarioPorId(String id) {
        csvHandler.eliminarUsuarioPorId(id);
    }



}
