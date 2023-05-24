package py.com.icejas.quizz.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import py.com.icejas.quizz.commons.bean.AccessToken;

public class AuthDTO {
    @JsonProperty(value = "access_token")
    private AccessToken accessToken;
    private String message;
    private Integer userId;
    public AuthDTO() {
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
