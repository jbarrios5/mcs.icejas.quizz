package py.com.icejas.quizz.user.mapper;

import org.springframework.jdbc.core.RowMapper;
import py.com.icejas.quizz.constants.Role;
import py.com.icejas.quizz.user.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getString("name"),
                rs.getString("full_name"),
                rs.getString("status"),
                rs.getInt("total_scored"),
                rs.getTimestamp("last_access"),
                rs.getString("roleName") == "ADMIN" ? Role.ADMIN_ROLE:Role.USER_ROLE ,
                rs.getString("church")
        );
    }

}
