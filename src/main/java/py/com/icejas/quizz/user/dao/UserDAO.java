package py.com.icejas.quizz.user.dao;

import py.com.icejas.quizz.exception.ApiRequestException;
import py.com.icejas.quizz.user.dto.UserDTO;
import py.com.icejas.quizz.commons.User;

import java.util.List;

public interface UserDAO {
    void insertUser(User user) throws ApiRequestException;
    List<UserDTO> getUsers() throws ApiRequestException;

    UserDTO getUserById(Integer userId) throws ApiRequestException;


}
