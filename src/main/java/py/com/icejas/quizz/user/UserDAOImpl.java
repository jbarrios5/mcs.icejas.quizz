package py.com.icejas.quizz.user;

import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.exception.ApiRequestException;

@Repository
public class UserDAOImpl implements UserDAO{

    @Override
    public void insertUser(User user) throws ApiRequestException {

    }
}
