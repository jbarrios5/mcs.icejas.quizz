package py.com.icejas.quizz.auth.service;

import org.springframework.stereotype.Service;
import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.commons.bean.User;
@Service
public class SessionServiceImpl implements SessionService{

    @Override
    public Session createSession(AccessToken accessToken, Integer userId) {
        Session session = new Session();
        session.setExpiration(accessToken.getExpiration());
        session.setTokenValue(accessToken.getValue());
        session.setUserId(userId);

        return session;
    }

    @Override
    public Boolean isSessionExpires() {
        return null;
    }
}
