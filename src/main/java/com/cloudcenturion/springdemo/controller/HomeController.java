package com.cloudcenturion.springdemo.controller;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private static Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping({"/hello","/"})
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        logger.info("Sono in HomeController");
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }


}
