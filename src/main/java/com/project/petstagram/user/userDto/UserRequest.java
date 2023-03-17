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
public class UserRequest {

    private String userId;
    private String userPwd;
    private String userNick;
    private String userImg;
    private String userIntro;
    private String question;
    private String answer;

/*    @Builder
    public UserRequest( String userId, String userPwd, String userNick,
                       String userImg, String userIntro, String question, String answer){
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNick = userNick;
        this.userImg = userImg;
        this.userIntro = userIntro;
        this.question = question;
        this.answer = answer;
    }*/

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .userPwd(userPwd)
                .userNick(userNick)
                .userImg(userImg)
                .userIntro(userIntro)
                .question(question)
                .answer(answer)
                .build();
    }

}
