package com.project.petstagram.board.boardDto;


import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.myPet.myPetEntity.MypetEntity;
import com.project.petstagram.user.userEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder  // 생성자가 많은 경우 빌더 패턴을 쓴다
@Getter
@AllArgsConstructor  // 모든 필드값을 파라미터로 받는 생성자 생성
@NoArgsConstructor // 파라미터가 없는 기본생성자
public class BoardRequest {

    private UserEntity user;
    private MypetEntity myPet;
    private String boardContents;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .user(user)
                .myPet(myPet)
                .boardContents(boardContents)
                .build();
    }
}
