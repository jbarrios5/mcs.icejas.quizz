package py.com.icejas.quizz.auth.dto;

public class UserDTO {
    private final Integer id;
    private final String password;

    public UserDTO(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
