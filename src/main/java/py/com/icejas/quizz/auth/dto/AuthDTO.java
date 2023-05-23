package py.com.icejas.quizz.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import py.com.icejas.quizz.commons.AccessToken;

public class AuthDTO {
    @JsonProperty(value = "access_token")
    private AccessToken accessToken;
    private String message;

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
}
