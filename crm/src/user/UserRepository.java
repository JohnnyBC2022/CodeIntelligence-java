package user;

public class UserRepository {
    UserRepository userRepository;

    public UserRepository() {

    }

    public void List<UserEntity> findAll(){
        return this.userRepository.findAll();
    }
}
