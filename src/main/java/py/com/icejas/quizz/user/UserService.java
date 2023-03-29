package py.com.icejas.quizz.user;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    List<UserDTO> getUsers();

}
