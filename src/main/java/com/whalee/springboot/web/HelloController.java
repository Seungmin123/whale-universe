package com.whalee.springboot.web;

import com.whalee.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String goIndexPage(){
        return "nice to meet you. it's index page";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto indexDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

}
