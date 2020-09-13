package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author manoj.bardhan
 */


@RestController
public class Test {

    @RequestMapping("/hello")


    public String sayHello() {

        return "Hello World Developer!!!";

    }

}