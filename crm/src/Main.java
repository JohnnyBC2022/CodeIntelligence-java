import user.UserRepository;
import user.model.UserEntity;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserRepository repo = new UserRepository();
        File file=new File("C:/Users/Asus/IdeaProjects/CodeIntelligence-java/crm/src/resources/users.csv");

        repo.setArchivoCsv(file);
        UserEntity firstUser = repo.findById("1");
        System.out.println(firstUser.getName());

        List<UserEntity> users = repo.findAll();
        for (UserEntity user : users) {
            System.out.println(user.getName());
        }

        //Creacion simple
        UserEntity user = new UserEntity();
        user.setId("34");
        user.setName("ajdf");
        user.setEmail("pafdn");
        user.setAge(12);

//        try {
//            repo.create(user);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //34,ajdf,pafdn,12

        //Eliminación
//        try {
//            repo.delete("1");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        UserEntity updatedUser = new UserEntity();
        updatedUser.setId("1");
        user.setName("Sergio");
        user.setEmail("carlos@example.com");
        user.setAge(40);
        //Update
        try {
            repo.update(updatedUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}