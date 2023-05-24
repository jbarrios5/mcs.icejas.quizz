package py.com.icejas.quizz.auth.dto;

public class AuthUserDTO {
    private final Integer id;
    private final String password;
    private final String status;

    public AuthUserDTO(Integer id, String password,String status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus(){
        return status;
    }
}
