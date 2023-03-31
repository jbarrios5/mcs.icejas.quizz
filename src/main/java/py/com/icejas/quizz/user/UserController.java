package py.com.icejas.quizz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/")
    public void insertUser(
            @RequestBody User user
    ){
        userService.insertUser(user);
    }

}
