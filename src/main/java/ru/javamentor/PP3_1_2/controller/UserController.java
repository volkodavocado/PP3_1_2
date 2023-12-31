package ru.javamentor.PP3_1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.PP3_1_2.model.User;
import ru.javamentor.PP3_1_2.service.UserService;

@Controller
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String printAll(Model model) {
        model.addAttribute("users", service.getAll());
        return "spring-mvc-app/index";
    }

    @GetMapping("/new")
    public String printAddForm(@ModelAttribute("user") User user) {
        return "spring-mvc-app/new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam("id") Long id) {
        service.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String printEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "spring-mvc-app/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
        service.update(user, id);
        return "redirect:/";
    }
}
