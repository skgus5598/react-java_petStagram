package com.project.petstagram.board.boardService;

import com.project.petstagram.board.boardDto.BoardRequest;
import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardRepo.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    @Override
    public List<BoardResponse> getBoardList() {
        List<BoardEntity> boardList = repository.findAll();
        return boardList.stream().map(BoardResponse::new).collect(Collectors.toList());

    }

    @Override
    public BoardResponse addContent(BoardRequest boardRequest) {
        BoardEntity boardEntity = repository.save(boardRequest.toEntity());
        return new BoardResponse(boardEntity);
    }

    @Override
    @Transactional
    public void deleteContent(Long boardNo) {
        repository.deleteById(boardNo);
    }
}
