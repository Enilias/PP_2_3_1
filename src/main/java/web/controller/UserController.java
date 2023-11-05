package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "all";
    }

    @GetMapping("/new")
    public void newUser(Model model) {
        model.addAttribute("user", new User());
    }

    @PostMapping("/new")
    public String creat(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:all";
    }

    @GetMapping("/update")
    public void getUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user.getId(), user.getName(), user.getSurname());
        return "redirect:all";
    }


}
