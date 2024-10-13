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
        // Escribe el nuevo usuario en el archivo CSV
        csvHandler.writeNewUserLine(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getAge());
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        // Lógica para leer el CSV y agregar usuarios a la lista
        // Aquí podrías utilizar csvHandler.leerArchivo() y parsear cada línea a un UserDTO

        return users;
    }


}
