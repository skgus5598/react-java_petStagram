package com.project.petstagram.user.userController;

import com.project.petstagram.user.userDto.UserRequest;
import com.project.petstagram.user.userDto.UserResponse;
import com.project.petstagram.user.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController("/")
public class UserController {

    private final UserService userService;


    @PostMapping("/loginUser")
    public int loginUser(@RequestBody UserRequest userRequest){
        return userService.loginUser(userRequest);
    }

    @PostMapping("/registerUser") // 회원가입
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity(userService.registerUser(userRequest), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<UserResponse> deleteUser(@RequestParam String userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity(userService.updateUser(userRequest), HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<List> getUserList(){
        return new ResponseEntity(userService.getUserList(), HttpStatus.OK);
    }
}
