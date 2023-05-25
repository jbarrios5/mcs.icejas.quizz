package py.com.icejas.quizz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.auth.dao.SessionDAO;
import py.com.icejas.quizz.commons.constant.ApiResponseCode;
import py.com.icejas.quizz.exception.ApiException;
import py.com.icejas.quizz.exception.ApiRequestException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    public Boolean isSessionExpires(Session session) {


        Timestamp now = Timestamp.valueOf(LocalDateTime.now());

        if(session.getExpiration().compareTo(now) > 0 )
            return true;
        else
            return false;

    }

    @Override
    public Session getSessionFromAccessToken(String accessToken) {
        Session session = sessionDAO.getSessionFromAccessToken(accessToken);
        if(session == null )
            throw  new ApiRequestException(ApiResponseCode.SESSION_EXPIRES.getCode(), HttpStatus.BAD_REQUEST);

        boolean isValidSession = isSessionExpires(session);

        if(!isValidSession)
            throw  new ApiRequestException(ApiResponseCode.SESSION_EXPIRES.getCode(), HttpStatus.BAD_REQUEST);

        return session;
    }
}
