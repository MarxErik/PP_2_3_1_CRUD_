package org.marx.controller;

import org.marx.model.User;
import org.marx.service.UserService;
import org.marx.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping({"/users", ""})
    public String readAllUsers(Model model) {
        model.addAttribute("user", userService.readAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String addUser(@ModelAttribute("user") User user) {
        return "create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes attributes) {
        if (user.getId() == null) {
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        attributes.addFlashAttribute("flashMessage", "User " + user.getName() +
                " created!");
        return "redirect:/users";
    }

    @GetMapping(value = "/edit", params = "id")
    public String editUserForm(@RequestParam("id") int id,
                               RedirectAttributes attributes, Model model) {
        try {
            model.addAttribute("user", userService.readUser(id));
        } catch (NumberFormatException | NullPointerException e) {
            attributes.addFlashAttribute("flashMessage", "User not found");
            return "redirect:/users";
        }
        return "create";
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
