package py.com.icejas.quizz.auth.service;

import py.com.icejas.quizz.auth.dto.AuthDTO;

public interface AuthService {
    AuthDTO login(String userName,String password);

    boolean logout(String sessionId);


}
