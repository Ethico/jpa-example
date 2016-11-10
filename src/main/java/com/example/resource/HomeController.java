package com.example.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hrushikeshp on 11/10/2016.
 */

/*
    Note :
    If you are using template engine like thymeleaf then
    you should use @Controller instead @RestController
    because @RestController automatically converts output to json.

    We are using thymeleaf as a templating engine. Output wont be a
    Json. Whatever we are saving up in the model attribute will be
    available by using thymeleaf expression language.
*/

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("message","home alone !!!");
        return "home";
    }
}
