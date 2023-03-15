package com.project.petstagram.user.userService;

import com.project.petstagram.user.userDto.UserRequest;
import com.project.petstagram.user.userDto.UserResponse;
import com.project.petstagram.user.userEntity.UserEntity;
import com.project.petstagram.user.userRepo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;


    @Override
    public int loginUser(UserRequest userRequest) {
        UserEntity userEntity =  userRepository.findByUserId(userRequest.getUserId());
        if (userEntity == null){
            return 2; // 없는 유저
        }else if(userRequest.getUserPwd().equals(userEntity.getUserPwd())){
            return 1; // 로그인 성공
        }else{
            return 0; // 비밀번호 틀림
        }
    }

    @Override
    public int registerUser(UserRequest userRequest) {
        //Optional은 값이 null일 경우 에러를 방지
        UserEntity user = userRepository.findByUserId(userRequest.getUserId());
        if(user != null){
            return 0; // 이미 존재
        }else{
            userRepository.save(userRequest.toEntity());
            return 1;
        }
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    @Transactional
    public int updateUser(UserRequest userRequest) {
        UserEntity user = userRepository.findByUserId(userRequest.getUserId());
        if(user != null){
            user.setUserIntro(userRequest.getUserIntro()); // UserEntity에서 SET만 해줘도 디비 값이 바뀐다.. @Transactional 필수
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public List<UserResponse> getUserList() {
        return userRepository.findAll() //findAll하면 UserEntity로 리턴이 되서, 이걸 아래와 같이 DTO에 담아 보여줘야 한다.
                .stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
