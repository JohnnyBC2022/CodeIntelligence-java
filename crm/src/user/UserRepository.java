package user;

import user.model.UserEntity;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private File archivoCsv;

    public UserRepository() {

    }

    public File getArchivoCsv() {
        return archivoCsv;
    }

    public void setArchivoCsv(File archivoCsv) {
        this.archivoCsv = archivoCsv;
    }

    /**
     * encuentra todos los user del csv y los retorna en una lista
     */
    public List <UserEntity> findAll(){
                List<UserEntity> allUsers = new ArrayList<UserEntity>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            while ((linea = br.readLine()) != null) {
                UserEntity user = this.convertToEntity(linea);
                if (user != null) {
                    allUsers.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    /**
     * encuentra un user por su id
     * @param id
     * @return
     */
    public UserEntity findById(String id){
        if(this.verifyUserExistsInCsv(id)){
            return this.convertToEntityGivenId(id);
        }
        return null;
    }

    /**
     * crea el usuario.
     * <br>
     * Primero verifica que no exista para insertarlo
     * @param user
     * @throws Exception
     */
    public void create(UserEntity user) throws Exception{
        if(!verifyUserExistsInCsv(user.getId())){
            try (FileWriter fw = new FileWriter(this.archivoCsv, true);
                 PrintWriter pw = new PrintWriter(fw)) {

                String newLine = user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getAge();

                pw.println(newLine);

                System.out.println("Usuario agregado correctamente.");

            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
            }
        }else  throw new Exception("El usuario ya existe. Imposible volverlo a crear");
    }

    /**
     * actualiza el usuario
     * <br>
     * Primero verifica que exista para borrarlo e insertar la actualizacion
     * @param user
     * @throws Exception
     */
    public void update(UserEntity user) throws Exception{
        if(verifyUserExistsInCsv(user.getId())){
            try (FileWriter fw = new FileWriter(this.archivoCsv, true);
                 PrintWriter pw = new PrintWriter(fw)) {

                this.delete(user.getId());



                String newLine = user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getAge();

                pw.println(newLine);

                System.out.println("Usuario agregado correctamente.");

            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
            }
        }else  throw new Exception("El usuario ya existe. Imposible volverlo a crear");
    }

    /**
     * borra un usuario pasado por parámetro
     * @param id
     */
    public void delete (String id) throws Exception{
        if (verifyUserExistsInCsv(id)){
            File originalFile = this.archivoCsv;
            File tempFile = new File("C:/Users/Asus/IdeaProjects/CodeIntelligence-java/crm/src/resources/users-new.csv");

            try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String currentLine;
                boolean userFound = false;

                // Leer cada línea del archivo original
                while ((currentLine = reader.readLine()) != null) {
                    // Dividir la línea en columnas (asumiendo que está separada por comas)
                    String[] datosUsuario = currentLine.split(",");

                    // Si el ID coincide, no escribir esta línea en el archivo temporal
                    if (Objects.equals(datosUsuario[0], id)) {
                        userFound = true; // Usuario encontrado y no copiado
                        continue;
                    }

                    // Escribir la línea en el archivo temporal
                    writer.write(currentLine);
                    writer.newLine();
                }

                if (userFound) {
                    System.out.println("Usuario con ID " + id + " eliminado.");
                } else {
                    System.out.println("Usuario con ID " + id + " no encontrado.");
                }

            } catch (IOException e) {
                System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
            }

            // Reemplazar el archivo original con el archivo temporal
            try {
                Files.delete(originalFile.toPath()); // Borrar el archivo original
                Files.move(tempFile.toPath(), originalFile.toPath()); // Renombrar el archivo temporal como el original
            } catch (IOException e) {
                System.out.println("Error al reemplazar el archivo: " + e.getMessage());
            }
        }else throw new Exception ("El usuario no existe, y no puede ser borrado.");
    }

    /**
     * convierte una linea de un objeto que busco del csv en un UserEntity
     * @param id
     * @return
     */
    private UserEntity convertToEntityGivenId (String id){
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            while ((linea = br.readLine()) != null) {
                UserEntity user = convertToEntity(linea);
                if (user != null && user.getId().equals(id)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * convierte una linea del csv en un UserEntity
     * @param linea
     * @return
     */
    private UserEntity convertToEntity(String linea) {
        UserEntity user = new UserEntity();
        String[] datos = linea.split(",");

        String id = datos[0];
        String name = datos[1];
        String email = datos[2];
        int age;

        try {
            age = Integer.parseInt(datos[3]);
        } catch (NumberFormatException e) {
            return null;
        }

        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        return user;
    }

    /**
     * verifica que el usuario existe en el csv
     * @param id
     * @return
     */
    private boolean verifyUserExistsInCsv(String id){
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].equals(id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
