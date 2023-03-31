package py.com.icejas.quizz.user;

import py.com.icejas.quizz.exception.ApiRequestException;

import java.util.List;

public interface UserDAO {
    void insertUser(User user) throws ApiRequestException;
    List<UserDTO> getUsers() throws ApiRequestException;

    UserDTO getUser(Integer userId) throws ApiRequestException;

}
