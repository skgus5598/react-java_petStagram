package com.project.petstagram.user.userEntity;

import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.myPet.myPetEntity.MypetEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name= "PET_USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq_generator")
    @SequenceGenerator( name = "user_seq_generator",sequenceName = "user_seq",initialValue = 1, allocationSize = 1)
    private Long userNo;

    private String userId;

    private String userPwd;

    private String userNick;

    private String userImg;

    private String userIntro;

    private String question;

    private String answer;

    @CreationTimestamp // 생성 시 이거 , 업데이트시엔 @UpdateTimestamp
    private Date user_regdate;

    // 회원삭제 -> 작성한 게시물, 펫, 댓글 테이블에서 모두 삭제. 아래는 테이블 컬럼이 아님.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BoardEntity> boardEntities;

    @OneToMany(mappedBy = "userNo", cascade = CascadeType.ALL)
    private List<MypetEntity> mypetEntities;


}
