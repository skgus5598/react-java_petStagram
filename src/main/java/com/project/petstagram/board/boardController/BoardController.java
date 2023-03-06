package com.project.petstagram.board.boardController;

import com.project.petstagram.board.boardDto.BoardRequest;
import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardService.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/getBoardList")
    public List<BoardResponse> getBoardList(){
        return boardService.getBoardList();
    }

    @PostMapping("/addContent")
    public ResponseEntity<BoardResponse> addContent(@RequestBody BoardRequest boardRequest){
        return new ResponseEntity<>(boardService.addContent(boardRequest), HttpStatus.OK);
    }

    @DeleteMapping("deleteContent")
    public void deleteContent(@RequestParam Long boardNo){
         boardService.deleteContent(boardNo);
    }





}
