package com.project.petstagram.user.userDto;

import com.project.petstagram.user.userEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String userId;
    private String userPwd;
    private String userNick;
    private String userImg;
    private String userIntro;
    private String question;
    private String answer;

/*    @Builder --> 이게 위에 빌더 풀어 쓴거
    public UserResponse( String userId, String userPwd, String userNick,
                        String userImg, String userIntro, String question, String answer){
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNick = userNick;
        this.userImg = userImg;
        this.userIntro = userIntro;
        this.question = question;
        this.answer = answer;
    }*/

    public UserResponse(UserEntity user){
        this.userId = user.getUserId();
        this.userPwd = user.getUserPwd();
        this.userNick = user.getUserNick();
        this.userImg = user.getUserImg();
        this.userIntro = user.getUserIntro();
        this.question = user.getQuestion();
        this.answer = user.getAnswer();
    }

}
