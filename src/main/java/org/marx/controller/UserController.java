package org.marx.controller;
import org.marx.model.User;
import org.marx.service.UserService;
import org.marx.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }
    @GetMapping("/users")
    public String createUser(Model model) {
        model.addAttribute("user", userService.createUser((User) model));
        return "users";
    }

    @GetMapping(value = "/users")
    public String readAllUsers(Model model) {
        model.addAttribute("user", userService.readAllUsers());
        return "users";
    }
}