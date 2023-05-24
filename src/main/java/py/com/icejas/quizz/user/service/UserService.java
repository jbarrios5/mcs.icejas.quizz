package py.com.icejas.quizz.user.service;

import py.com.icejas.quizz.user.dto.UserDTO;
import py.com.icejas.quizz.commons.bean.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer id);



}
