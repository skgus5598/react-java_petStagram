package com.project.petstagram.board.boardService;

import com.project.petstagram.board.boardEntity.BoardEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public List<BoardEntity> getBoardList();
}
