package com.project.petstagram.user.userController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController("/")
public class UserController {
    private HttpStatus httpStatus;


    @GetMapping("/mypet")
    public ResponseEntity<String>  loginPage() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String test(){
        return "hello!";
    }

    @GetMapping("list")
    public List<String> list(){
        return Arrays.asList("1","2","3","4");
    }
}
