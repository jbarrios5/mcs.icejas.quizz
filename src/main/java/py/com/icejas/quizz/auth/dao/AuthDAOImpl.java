package py.com.icejas.quizz.auth.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import py.com.icejas.quizz.auth.dto.UserDTO;
import py.com.icejas.quizz.auth.mapper.UserMapper;
import py.com.icejas.quizz.commons.bean.User;
import py.com.icejas.quizz.exception.ApiRequestException;
import py.com.icejas.quizz.user.dao.UserDAOImpl;

public class AuthDAOImpl implements AuthDAO{
    private static final String GET_USER_BY_USERNAME = "select u.name,u.full_name ,u.last_access ,u.status,u.total_scored, r.name as roleName ,c.name as church  " +
            "from users u join church c on c.id  = u.id_church join role r on r.id = u.id_role WHERE u.name = ?" ;
    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public AuthDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public UserDTO getUserByUserName(String userName) throws ApiRequestException {
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME,new Object [] {userName},new UserMapper());

    }
}
