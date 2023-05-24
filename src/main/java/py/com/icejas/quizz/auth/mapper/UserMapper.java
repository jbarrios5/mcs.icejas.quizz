package py.com.icejas.quizz.auth.mapper;

import org.springframework.jdbc.core.RowMapper;
import py.com.icejas.quizz.auth.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
