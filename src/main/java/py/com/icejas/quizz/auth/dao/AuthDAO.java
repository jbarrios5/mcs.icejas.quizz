package py.com.icejas.quizz.auth.dao;

import py.com.icejas.quizz.auth.dto.UserDTO;
import py.com.icejas.quizz.exception.ApiRequestException;

public interface AuthDAO {
    UserDTO getUserByUserName(String userName) throws ApiRequestException;
}
