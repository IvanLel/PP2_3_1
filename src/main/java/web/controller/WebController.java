package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@Validated
public class WebController {

    private final String REDIRECT_MAIN = "redirect:/users";

    private final UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "mainPage";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") int id) {
        if (id > 0) {
            model.addAttribute("user", userService.getUserById(id));
        } else {
            model.addAttribute("user", new User());
        }

        return "editPage";
    }

    @PostMapping("/edit")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            if (id > 0) {
                user.setId(id);
            }
            return "editPage";

        }
        if (user.getId() == 0) {
            userService.add(user);
        } else {
            userService.updateUser(user, id);
        }

        return REDIRECT_MAIN;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.removeUser(id);
        return REDIRECT_MAIN;
    }
}
