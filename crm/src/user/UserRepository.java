package user;

import user.model.UserEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
