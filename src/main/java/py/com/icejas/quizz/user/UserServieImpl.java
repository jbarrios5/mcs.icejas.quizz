package py.com.icejas.quizz.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import py.com.icejas.quizz.constants.ApiError;
import py.com.icejas.quizz.exception.ApiRequestException;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class UserServieImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServieImpl.class);
    @Autowired
    UserDAO userDAO;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void insertUser(User user) {
        log.info("We've received {}",user);
        if(user == null)
            throw new ApiRequestException("User is required "+ ApiError.BAD_REQUEST_DATA);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));



        userDAO.insertUser(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("We'll get users");
        return userDAO.getUsers();
    }
}
