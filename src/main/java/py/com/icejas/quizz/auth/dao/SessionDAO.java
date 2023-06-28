package py.com.icejas.quizz.auth.dao;

import py.com.icejas.quizz.commons.bean.Session;

import java.sql.Timestamp;

public interface SessionDAO {
    boolean createSession(Session session);
    Session getSessionFromAccessToken(String accessToken);

    boolean logout(String sessionId, Timestamp currentDate);
}
