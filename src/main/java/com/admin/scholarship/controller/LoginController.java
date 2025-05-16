package com.admin.scholarship.controller;

import com.admin.scholarship.model.User;
import com.admin.scholarship.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginPage() {
        return "login"; // loads login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // loads register.html
    }
    
    @PostMapping("/register-handler")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role) {
        User newUser = new User(username, password, role);
        userService.saveUser(newUser);  
        return "redirect:/";  
    }

    @PostMapping("/login-handler")
    public String loginHandler(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session) {

        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("USER", user); // optional: store logged-in user

            // Use role from DB to redirect appropriately
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/student/home";
            }
        } else {
            return "redirect:/?error"; // invalid login
        }
    }
}
