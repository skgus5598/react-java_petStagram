package com.project.petstagram.board.boardController;

import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardService.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/getBoardList")
    public List<BoardEntity> getBoardList(){
        return boardService.getBoardList();
    }



}
