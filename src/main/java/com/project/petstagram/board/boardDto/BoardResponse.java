package com.project.petstagram.board.boardDto;

import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardEntity.BoardPetListEntity;
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
public class BoardResponse {

    private String userId;
    private String boardContents;
    private long boardNoList;
    private List<BoardPetListEntity> boardPetListEntities;


    //Entity -> dto로 담아주는 생성자. 아래와 같이 생성자를 만들어주거나 빌더로 만들어주나 동일하다.
    public BoardResponse(BoardEntity entity){
        this.userId = entity.getUser().getUserId();
        this.boardContents = entity.getBoardContents();
        this.boardNoList = entity.getBoardNo();
        this.boardPetListEntities = entity.getBoardPetListEntities();
    }



}
