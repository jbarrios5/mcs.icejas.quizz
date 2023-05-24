package py.com.icejas.quizz.auth.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.auth.dto.AuthUserDTO;
import py.com.icejas.quizz.auth.mapper.UserMapper;
import py.com.icejas.quizz.exception.ApiRequestException;
import py.com.icejas.quizz.user.dao.UserDAOImpl;
@Repository
public class AuthDAOImpl implements AuthDAO{
    private static final String GET_USER_BY_USERNAME = "select u.id,u.password , u.status  from users u where u.name = ?";
    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public AuthDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public AuthUserDTO getUserByUserName(String userName) throws ApiRequestException {
        log.info("Getting user with userName {}",userName);
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME,new Object [] {userName},new UserMapper());

    }
}
