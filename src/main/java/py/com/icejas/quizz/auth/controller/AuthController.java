package py.com.icejas.quizz.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.com.icejas.quizz.auth.dto.AuthDTO;
import py.com.icejas.quizz.auth.service.AuthService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/")
    public AuthDTO login(
            @RequestParam(value = "user_name",required = true) String userName,
            @RequestParam(value = "password",required = true) String password
    ){
        return authService.login(userName,password);
    }

    @PostMapping("/")
    public AuthDTO logout(
            @RequestParam(value = "access_token",required = true) String accessToken
    ){
        return null;
    }


}
