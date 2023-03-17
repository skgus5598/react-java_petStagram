package com.project.petstagram.user.userService;

import com.project.petstagram.user.userDto.UserRequest;
import com.project.petstagram.user.userDto.UserResponse;
import com.project.petstagram.user.userEntity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public int loginUser(UserRequest userRequest);
    public int registerUser(UserRequest userRequest);
    public void deleteUser(String userId);
    public int updateUser(UserRequest userRequest);
    public List<UserResponse> getUserList();
}
