package py.com.icejas.quizz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.auth.dao.SessionDAO;

@Component
public class SessionServiceImpl implements SessionService{

    private final SessionDAO sessionDAO;
    @Autowired
    public SessionServiceImpl(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    @Override
    public Boolean createSession(AccessToken accessToken, Integer userId) {
        Session session = new Session();
        session.setExpiration(accessToken.getExpiration());
        session.setTokenValue(accessToken.getValue());
        session.setUserId(userId);


        return sessionDAO.createSession(session);
    }

    @Override
    public Boolean isSessionExpires() {
        return null;
    }
}
