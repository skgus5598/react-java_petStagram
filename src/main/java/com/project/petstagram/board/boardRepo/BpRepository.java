package com.project.petstagram.board.boardRepo;

import com.project.petstagram.board.boardEntity.BoardPetListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BpRepository extends JpaRepository<BoardPetListEntity, Long> {
}
