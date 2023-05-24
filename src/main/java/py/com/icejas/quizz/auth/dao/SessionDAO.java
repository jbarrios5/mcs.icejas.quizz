package py.com.icejas.quizz.auth.dao;

import py.com.icejas.quizz.commons.bean.Session;

public interface SessionDAO {
    boolean createSession(Session session);
}
