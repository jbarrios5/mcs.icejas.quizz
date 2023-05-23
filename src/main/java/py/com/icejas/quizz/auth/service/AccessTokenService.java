package py.com.icejas.quizz.auth.service;

import py.com.icejas.quizz.commons.AccessToken;

public interface AccessTokenService {
    AccessToken createAccessToken();
    Boolean isExpiration();
}
