package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("resultado")
public class IndexController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/about")
    public String showAbout(Model model){
        model.addAttribute("resultado", "mensaje desde session");
        return "about";
    }
}
