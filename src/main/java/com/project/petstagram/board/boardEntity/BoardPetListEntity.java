package com.project.petstagram.board.boardEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.petstagram.myPet.myPetEntity.MypetEntity;
import lombok.*;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "BOARD_PETLIST")
public class BoardPetListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "boardPetList_seq_generator")
    @SequenceGenerator( name = "boardPetList_seq_generator", sequenceName = "boardpetlist_seq", initialValue = 1, allocationSize = 1)
    private Long bpId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity boardNo;

    @Column(name = "pet_no")
    private Integer petNo;



}
