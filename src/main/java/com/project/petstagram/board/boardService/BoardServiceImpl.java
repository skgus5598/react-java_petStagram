package com.project.petstagram.board.boardService;

import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardRepo.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    @Override
    public List<BoardEntity> getBoardList() {
        return repository.findAll();
    }
}
