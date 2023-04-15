package com.boot.batis.board;

import com.boot.batis.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardDAO dao;

    @Transactional(readOnly = true)
    public List<BoardDTO> findAllList() {
        return dao.findAllList();
    }

}
