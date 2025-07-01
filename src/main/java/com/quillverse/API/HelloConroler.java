package com.quillverse.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConroler {
    @GetMapping("//hello")
    public String hello(){
        return "hello back to you";
    }
}


