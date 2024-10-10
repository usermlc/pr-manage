package com.await.productmanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Handler for the main page, accessible at /main
    @GetMapping("/main")
    public String mainPage(Model model) {
        // Simply returns the view name for the main page
        return "main";
    }
}
