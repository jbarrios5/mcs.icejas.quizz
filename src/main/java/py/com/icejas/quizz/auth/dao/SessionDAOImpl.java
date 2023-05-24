package py.com.icejas.quizz.auth.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.commons.bean.Session;
@Repository
public class SessionDAOImpl implements SessionDAO{
    private static final Logger log = LoggerFactory.getLogger(SessionDAOImpl.class);
    private static final String INSERT_SESSION = "INSERT INTO session (user_id,token,expiration) VALUES(?,?,?)";
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
}
