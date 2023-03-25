package py.com.icejas.quizz.user;

import py.com.icejas.quizz.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getUsers();

}
