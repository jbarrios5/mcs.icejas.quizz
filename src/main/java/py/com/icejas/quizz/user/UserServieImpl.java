package py.com.icejas.quizz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.icejas.quizz.exception.ApiRequestException;

import java.util.List;

@Service
public class UserServieImpl implements UserService{

    @Autowired
    UserDAO userDAO;
    @Override
    public void insertUser(User user) {
        if(user == null)
            throw new ApiRequestException("User is required");

        userDAO.insertUser(user);
    }

    @Override
    public List<UserDTO> getUsers() {

        return null;
    }
}
