package org.marx.controller;

import org.marx.model.User;
import org.marx.service.UserService;
import org.marx.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping({"/users", ""})
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String introduceUserUser(@ModelAttribute("user") User user) {
        return "create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes attributes) {
        userService.createUser(user);
        attributes.addFlashAttribute("flashMessage", "User " + user.getName() +
                " created!");
        return "redirect:/users";
    }


    @GetMapping(value = "/update", params = "id")
    public String updateUserForm(@RequestParam("id") int id,
                                 RedirectAttributes attributes, Model model) {
        try {
            model.addAttribute("user", userService.getUser(id));
        } catch (NumberFormatException | NullPointerException e) {
            attributes.addFlashAttribute("flashMessage", "User not found");
            return "redirect:/users";
        }
        return "/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", defaultValue = "") String id,
                             RedirectAttributes attributes) {
        Optional<User> user = userService.deleteUser(Integer.parseUnsignedInt(id));
        attributes.addFlashAttribute("flashMessage", "User " +
                user.get().getName() + " " +
                " deleted!");
        return "redirect:/users";
    }
}
