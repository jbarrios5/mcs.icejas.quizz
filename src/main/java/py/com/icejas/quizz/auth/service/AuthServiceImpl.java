package py.com.icejas.quizz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import py.com.icejas.quizz.auth.dao.AuthDAO;
import py.com.icejas.quizz.auth.dto.AuthDTO;
import py.com.icejas.quizz.commons.AccessToken;
import py.com.icejas.quizz.commons.User;
import py.com.icejas.quizz.constants.ApiError;
import py.com.icejas.quizz.exception.ApiRequestException;

import java.util.UUID;

public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthDAO authDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccessTokenService accessTokenService;
    @Override
    public AuthDTO login(String userName, String password) {

        User user = authDAO.getUserByUserName(userName);
        if( user == null )
            throw new ApiRequestException(ApiError.USER_NOT_FOUND.getCode());

        if(!passwordEncoder.matches(password,user.getPassword()))
            throw new ApiRequestException(ApiError.LOGIN_FAILED.getCode());

        AccessToken accessToken = accessTokenService.createAccessToken();

        //todo crear session

        return null;


    }
}
