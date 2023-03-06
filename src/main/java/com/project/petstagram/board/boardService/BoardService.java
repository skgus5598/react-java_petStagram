package com.project.petstagram.board.boardService;

import com.project.petstagram.board.boardDto.BoardRequest;
import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.board.boardEntity.BoardEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public List<BoardResponse> getBoardList();
    public BoardResponse addContent(BoardRequest boardRequest);
    public void deleteContent(Long boardNo);
}
