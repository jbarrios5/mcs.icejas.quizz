package py.com.icejas.quizz.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.icejas.quizz.user.dto.UserDTO;
import py.com.icejas.quizz.commons.bean.User;
import py.com.icejas.quizz.user.service.UserService;

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
    @GetMapping("/{id}")
    public UserDTO getUser(
            @PathVariable Integer id
    ){
        return userService.getUserById(id);
    }
}
