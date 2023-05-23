package py.com.icejas.quizz.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.com.icejas.quizz.auth.dto.AuthDTO;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping("/")
    public AuthDTO login(
            @RequestParam(value = "user_name",required = true) String userName,
            @RequestParam(value = "password",required = true) String password
    ){
        return null;

    }
}
