package com.example.CRUD_312.controller;

import com.example.CRUD_312.repo.UserRepository;
import com.example.CRUD_312.model.User;

import com.example.CRUD_312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user" , user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user) {
        userService.save(user);
        return "redirect:/";
    }

}


