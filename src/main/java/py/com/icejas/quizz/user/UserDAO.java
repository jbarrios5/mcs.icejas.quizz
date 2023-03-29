package py.com.icejas.quizz.user;

import py.com.icejas.quizz.exception.ApiRequestException;

public interface UserDAO {
    void insertUser(User user) throws ApiRequestException;

}
