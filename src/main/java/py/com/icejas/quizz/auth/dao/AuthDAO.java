package py.com.icejas.quizz.auth.dao;

import py.com.icejas.quizz.commons.User;

public interface AuthDAO {
    User getUserByUserName(String userName);
}
