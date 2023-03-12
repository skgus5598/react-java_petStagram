package com.project.petstagram.myPet.myPetEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardEntity.BoardPetListEntity;
import com.project.petstagram.user.userEntity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "MY_PET")
public class MypetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq_generator")
    @SequenceGenerator( name = "pet_seq_generator",sequenceName = "pet_seq",initialValue = 1, allocationSize = 1)
    @Column(name = "pet_no")
    private Long petNo;

    @ManyToOne
    @JoinColumn(name = "user_no") // 다대일, 양방향 / 연관관계의 주인
    private UserEntity userNo;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "pet_birth")
    private Date petBirth;

    @Column(name = "pet_gender")
    private String petGender;

    @Column(name = "pet_intro")
    private String petIntro;

    @Column(name = "pet_img")
    private String petImg;





 /*   @Builder
    public MypetEntity (){
         MypetEntity.builder()
                .userNo(userNo)
                .petName(petName)
                .petGender(petGender)
                .build();
    }
*/
}
