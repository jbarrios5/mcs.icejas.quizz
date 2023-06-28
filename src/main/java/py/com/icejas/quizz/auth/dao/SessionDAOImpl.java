package py.com.icejas.quizz.auth.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.auth.mapper.SessionMapper;
import py.com.icejas.quizz.auth.mapper.UserMapper;
import py.com.icejas.quizz.commons.bean.Session;

import java.sql.Timestamp;

@Repository
public class SessionDAOImpl implements SessionDAO{
    private static final Logger log = LoggerFactory.getLogger(SessionDAOImpl.class);
    private static final String INSERT_SESSION = "INSERT INTO session (user_id,token,expiration) VALUES(?,?,?)";
    private static final String GET_SESSION_FROM_AT= "select * from session where token = ?";
    private static final String UPDATE_SESSION_INVALIDATE= "update  session set  expiration = ? where token = ?";
    private final JdbcTemplate jdbcTemplate;

    public SessionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public boolean createSession(Session session) {
        log.info("Inserting session {}",session);
        int result = 0 ;
        try {
            result = jdbcTemplate.update(INSERT_SESSION,new Object[]{
                    session.getUserId(),
                    session.getTokenValue(),
                    session.getExpiration()
            });
        }catch (Exception e){
            log.debug("Unexpected error inserting session {}",e.getMessage());
            result = 0;
        }


        return result > 0 ;
    }

    @Override
    public Session getSessionFromAccessToken(String accessToken) {
        Session session = new Session();
        try {
            session =  jdbcTemplate.queryForObject(GET_SESSION_FROM_AT,new Object [] {accessToken},new SessionMapper());
            return session;
        }catch (EmptyResultDataAccessException e)
        {
            log.debug("UnepexectedError: {}",e.getMessage());
            return null;
        }
    }

    @Override
    public boolean logout(String accessToken, Timestamp currentDate) {
        log.info("Updating session logout {}",accessToken);
        int result = 0 ;
        try {
            result = jdbcTemplate.update(UPDATE_SESSION_INVALIDATE,new Object[]{
                    currentDate,
                    accessToken

            });
        }catch (Exception e){
            log.debug("Unexpected error updating session {}",e.getMessage());
            result = 0;
        }


        return result > 0 ;
    }
}
