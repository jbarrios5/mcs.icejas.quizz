package py.com.icejas.quizz.auth.dao;

import py.com.icejas.quizz.auth.dto.AuthUserDTO;
import py.com.icejas.quizz.exception.ApiRequestException;

public interface AuthDAO {
    AuthUserDTO getUserByUserName(String userName) throws ApiRequestException;



}
