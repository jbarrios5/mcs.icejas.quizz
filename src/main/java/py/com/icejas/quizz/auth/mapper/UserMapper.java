package py.com.icejas.quizz.auth.mapper;

import org.springframework.jdbc.core.RowMapper;
import py.com.icejas.quizz.auth.dto.AuthUserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<AuthUserDTO> {

    @Override
    public AuthUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AuthUserDTO(
                rs.getInt("id"),
                rs.getString("password"),
                rs.getString("status"));
    }
}
