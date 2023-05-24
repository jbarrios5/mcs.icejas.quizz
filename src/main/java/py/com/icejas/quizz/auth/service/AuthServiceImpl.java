package py.com.icejas.quizz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import py.com.icejas.quizz.auth.dao.AuthDAO;
import py.com.icejas.quizz.auth.dto.AuthDTO;
import py.com.icejas.quizz.auth.dto.UserDTO;
import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.commons.bean.User;
import py.com.icejas.quizz.commons.constant.ApiMessage;
import py.com.icejas.quizz.commons.constant.ApiResponseCode;
import py.com.icejas.quizz.exception.ApiRequestException;

public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthDAO authDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private AccessTokenService accessTokenService;
    @Override
    public AuthDTO login(String userName, String password) {

        UserDTO user = authDAO.getUserByUserName(userName);
        if( user == null )
            throw new ApiRequestException(ApiResponseCode.USER_NOT_FOUND.getCode());

        if(!passwordEncoder.matches(password,user.getPassword()))
            throw new ApiRequestException(ApiResponseCode.LOGIN_FAILED.getCode());


        AccessToken accessToken = accessTokenService.createAccessToken();

        Session session =  sessionService.createSession(accessToken,user.getId());

        AuthDTO authDTO = new AuthDTO();
        authDTO.setAccessToken(accessToken);
        authDTO.setMessage(ApiMessage.LOGIN_SUCCESFULLY);


        return authDTO;


    }
}
