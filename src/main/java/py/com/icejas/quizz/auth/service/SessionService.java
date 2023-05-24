package py.com.icejas.quizz.auth.service;

import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.commons.bean.User;

public interface SessionService {
    Boolean createSession(AccessToken accessToken, Integer userId);

    Boolean isSessionExpires();

}
