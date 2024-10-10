package user;

import user.model.UserEntity;

import java.util.List;

public class UserService {


    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void List<UserEntity> findAll(){
        return this.userRepository.findAll();
    }

}
