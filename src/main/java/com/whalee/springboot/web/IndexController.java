package com.whalee.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String goIndexPage(){
        return "nice to meet you. it's index page";
    }

}
