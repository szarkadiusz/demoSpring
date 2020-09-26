package com.examplespring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//prefix dla wszystkich metod w klasie
public class IndexController {
    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/calculator")
    public String getCalculatorPage(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String postCalculatorPage(Model model, Integer sizeX, Integer sizeY){
        //model to obiekt potrzebny do wyslnia czegos na widok
        model.addAttribute("rowNumbet",sizeY);
        model.addAttribute("colNumbet",sizeX);

        return "calculator";

    }

}
