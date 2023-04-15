package com.boot.batis.board;

import com.boot.batis.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardDAO {

    private final SqlSessionTemplate template;

    //get List
    public List<BoardDTO> findAllList() {
        List<BoardDTO> result = template.selectList("boardMapper.boardList");
        return result;
    }

}
