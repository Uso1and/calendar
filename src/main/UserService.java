import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserService userService;
    public User createUser(User user){
        return userService.save(user);

    }

    public List<User> findUsers(){
        return UserRepository.findUsers();
    }

    public Optional<User> findUserById(Long id){
        return UserRepository.findUserById(id);
    }
}
