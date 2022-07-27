package com.whalee.springboot.web;

import com.whalee.springboot.web.dto.IndexResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String goIndexPage(){
        return "nice to meet you. it's index page";
    }

    @GetMapping("/index/dto")
    public IndexResponseDto indexDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new IndexResponseDto(name, amount);
    }

}
