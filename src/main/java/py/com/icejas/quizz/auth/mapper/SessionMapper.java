package py.com.icejas.quizz.auth.mapper;

import org.springframework.jdbc.core.RowMapper;
import py.com.icejas.quizz.commons.bean.Session;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionMapper implements RowMapper<Session> {
    @Override
    public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
        Session session = new Session();

        session.setExpiration(rs.getTimestamp("expiration"));
        session.setTokenValue(rs.getString("token"));
        session.setUserId(rs.getInt("user_id"));

        return session;
    }
}
