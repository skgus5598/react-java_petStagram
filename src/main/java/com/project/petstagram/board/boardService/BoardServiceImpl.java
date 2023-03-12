package com.project.petstagram.board.boardService;

import com.project.petstagram.board.boardDto.BoardRequest;
import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.board.boardEntity.BoardEntity;
import com.project.petstagram.board.boardEntity.BoardPetListEntity;
import com.project.petstagram.board.boardRepo.BoardRepository;
import com.project.petstagram.board.boardRepo.BpRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final BpRepository bpRepository;

    @Override
    public List<BoardResponse> getBoardList() {
        List<BoardEntity> boardList = repository.findAll();
        return boardList.stream().map(BoardResponse::new).collect(Collectors.toList());

    }

    @Override
    public BoardResponse addContent(BoardRequest boardRequest) {
        System.out.println("petno? " + boardRequest.getPetNo());

        BoardEntity boardEntity = repository.save(boardRequest.toEntity());

        if (boardRequest.getPetNo().size() > 1){
            System.out.println("size? :" + boardRequest.getPetNo().size());
            for(int i : boardRequest.getPetNo()){
                System.out.println("i ::: " + i);
                bpRepository.save(BoardPetListEntity.builder()
                                    .boardNo(boardEntity)  // 여기 이상 ~
                                    .petNo(i)
                                    .build());
            }
        }
        return new BoardResponse(boardEntity);
    }

    @Override
    @Transactional
    public BoardResponse modifyContent(BoardRequest boardRequest) {
        BoardEntity boardEntity = repository.findById(boardRequest.getBoardNo())
                                            .orElseThrow(() -> new IllegalArgumentException());
        boardEntity.setBoardContents(boardRequest.getBoardContents());
        return new BoardResponse(boardEntity);
    }

    @Override
    @Transactional
    public void deleteContent(Long boardNo) {
        repository.deleteById(boardNo);
    }


}
