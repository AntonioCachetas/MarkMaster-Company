package com.humber.FinalProject1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Value("${company.name}")
    private String name;

    // Custom Error
    @GetMapping("/error")
    public String handleError() {
        return "auth/error";
    }

    // Custom Login
    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        model.addAttribute("companyName", name);
        return "auth/login";
    }

    // Custom Logout
    @GetMapping("/logout")
    public String customLogout(HttpServletRequest request,
                               HttpServletResponse response,
                               Authentication authentication) {
        // Logout logic
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/login?message=You have been logged out successfully!";
    }
}
