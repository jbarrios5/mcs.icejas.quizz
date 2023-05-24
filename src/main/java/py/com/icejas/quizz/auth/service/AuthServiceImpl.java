package py.com.icejas.quizz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import py.com.icejas.quizz.auth.dao.AuthDAO;
import py.com.icejas.quizz.auth.dto.AuthDTO;
import py.com.icejas.quizz.auth.dto.AuthUserDTO;
import py.com.icejas.quizz.commons.bean.AccessToken;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.commons.constant.ApiMessage;
import py.com.icejas.quizz.commons.constant.ApiResponseCode;
import py.com.icejas.quizz.commons.constant.UserStatus;
import py.com.icejas.quizz.exception.ApiRequestException;

@Service
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

        AuthUserDTO user = authDAO.getUserByUserName(userName);
        if( user == null )
            throw new ApiRequestException(ApiResponseCode.USER_NOT_FOUND.getCode());

        if(user.getStatus().equals(UserStatus.INACTIVE.getValue()))
            throw new ApiRequestException(ApiResponseCode.USER_INVALIDED.getCode());

        if(!passwordEncoder.matches(password,user.getPassword()))
            throw new ApiRequestException(ApiResponseCode.LOGIN_FAILED.getCode());

        AccessToken accessToken = accessTokenService.createAccessToken();

        boolean hasSession = sessionService.createSession(accessToken,user.getId());
        if(!hasSession)
            throw new ApiRequestException(ApiResponseCode.SESSION_ERROR.getCode());


        AuthDTO authDTO = new AuthDTO();
        authDTO.setUserId(user.getId());
        authDTO.setAccessToken(accessToken);
        authDTO.setMessage(ApiMessage.LOGIN_SUCCESFULLY);

        return authDTO;


    }
}
