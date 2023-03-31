package py.com.icejas.quizz.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.constants.ApiError;
import py.com.icejas.quizz.exception.ApiRequestException;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private static final String  INSERT_USER = "INSERT INTO users (name, full_name, password, create_at, last_access, status, total_scored, id_church, id_role) " +
            "values (?,?,?,?,?,?,?,?,?)";
    private static final String GET_USERS = "select u.name,u.full_name ,u.last_access ,u.status,u.total_scored, r.name as roleName ,c.name as church  " +
            "from users u join church c on c.id  = u.id_church join role r on r.id = u.id_role";

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUser(User user) throws ApiRequestException {
        int result = jdbcTemplate.update(INSERT_USER,
                user.getName(),
                user.getFullName(),
                user.getPassword(),
                user.getCreateAt(),
                user.getLastAccess(),
                user.getStatus(),
                user.getTotalScored(),
                user.getChurchId(),
                user.getRoleId()
        );

        if( result <= 0 )
            throw new ApiRequestException("We have an error inserting user errorCode="+ ApiError.UNEXPECTED_ERROR);

        log.info("User inserted successfully");
    }

    @Override
    public List<UserDTO> getUsers() throws ApiRequestException {
        return jdbcTemplate.query(GET_USERS,new UserMapper());
    }

    @Override
    public UserDTO getUser(Integer userId) throws ApiRequestException {
        return null;
    }
}
