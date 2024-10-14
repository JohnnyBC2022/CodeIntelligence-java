package user;

import user.model.UserDTO;
import util.CSVHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final String path="C:\\Users\\migue\\Documents\\developer\\CodeIntelligence-java\\crm\\src\\resources\\users.csv";


    public UserRepository() {}

    public void addUser(UserDTO userDTO) {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(userDTO.getId() + "," + userDTO.getName() + "," + userDTO.getEmail() + "," + userDTO.getAge() + "\n");
            System.out.println("Usuario escrito en el archivo: " + userDTO.getId() + "," + userDTO.getName() + "," + userDTO.getEmail() + "," + userDTO.getAge());
        } catch (IOException e) {
            System.out.println("Se ha producido un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 4) {
                    String id = datos[0].trim();
                    String name = datos[1].trim();
                    String email = datos[2].trim();
                    int age = Integer.parseInt(datos[3].trim());

                    UserDTO userDTO = new UserDTO(id, name, email, age, null, null);
                    users.add(userDTO);
                }
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        return users;
    }

    public void deleteUserById(String id) {
        File tempFile = new File(path);
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(id)) {
                    writer.write(line + "\n");
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Usuario con ID " + id + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con ID " + id + ".");
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al eliminar el usuario: " + e.getMessage());
        }

        if (!file.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }
        if (!tempFile.renameTo(file)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }

    public void updateUserById(UserDTO userDTO) {

        File file = new File(path);

        File tempFile = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(userDTO.getId())) {
                    writer.write(userDTO.getId() + "," + userDTO.getName() + "," + userDTO.getEmail() + "," + userDTO.getAge() + "\n");
                    found = true;
                } else {
                    writer.write(line + "\n");
                }
            }

            if (found) {
                System.out.println("Usuario con ID " + userDTO.getId() + " actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con ID " + userDTO.getId() + ".");
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al actualizar el usuario: " + e.getMessage());
        }

        if (!file.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }
        if (!tempFile.renameTo(file)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }
}
