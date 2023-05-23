package py.com.icejas.quizz.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import py.com.icejas.quizz.constants.ApiError;
import py.com.icejas.quizz.exception.ApiRequestException;
import py.com.icejas.quizz.user.dao.UserDAO;
import py.com.icejas.quizz.user.dto.UserDTO;
import py.com.icejas.quizz.commons.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class UserServieImpl implements UserService {
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

    @Override
    public UserDTO getUserById(Integer id) {
        log.info(String.format("We'll get user with id [%s]",id));

        return userDAO.getUserById(id);
    }
}
