package py.com.icejas.quizz.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.icejas.quizz.auth.dto.AuthDTO;
import py.com.icejas.quizz.auth.service.AuthService;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
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

    @PutMapping("/logout")
    public Boolean logout(
            @RequestParam(value = "session_id",required = true) String sessionId
    ){
        return authService.logout(sessionId);
    }


}
