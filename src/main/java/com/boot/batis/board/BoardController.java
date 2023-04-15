package com.boot.batis.board;

import com.boot.batis.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService service;

    @GetMapping("board/v1/AllList")
    public List<BoardDTO> findAllList() {
        List<BoardDTO> allList = service.findAllList();
        log.info("Controller res={}", allList);

        return allList;
    }

}
