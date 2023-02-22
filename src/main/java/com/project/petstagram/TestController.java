package com.project.petstagram;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello! 여기는 서버단 서버단!!!It's" + new Date() + " in KOREA";
    }
}
