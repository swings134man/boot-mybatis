package com.boot.batis.first.dao;

import com.boot.batis.first.dto.BoardCustDTO;
import com.boot.batis.first.dto.CustDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    // custId 를 통한 row 검색
    public CustDTO getOne(CustDTO inDTO) {
        CustDTO outDTO = sqlSessionTemplate.selectOne("custMapper.retrieveCustEntr", inDTO);
        return outDTO;
    }

    // save
    public int saveCustOne(CustDTO dto) {
        return sqlSessionTemplate.insert("custMapper.custEntr", dto);
    }

    // findAll()
    public List<CustDTO> findAll() {
        List<CustDTO> resultList = sqlSessionTemplate.selectList("custMapper.findAll");
        log.info("DAO : findAll Logic");
        return resultList;
    }

    // paging
    public List<CustDTO> findPaging(CustDTO dto , int pageNumber, int pageRow) {
        // MyBatis Paging API
        RowBounds rowBounds = new RowBounds(pageNumber, pageRow);

        List<CustDTO> list = sqlSessionTemplate.selectList("custMapper.retrieveCustAllPage", dto, rowBounds);
        log.info("DAO : Paging = {}", list);

        return list;
    }

    public int upateCustOne(CustDTO dto) {
        int update = sqlSessionTemplate.update("custMapper.updateCustEntr", dto);
        return update;
    }


    public int deleteCustOne(CustDTO dto) {
        int delete = sqlSessionTemplate.delete("custMapper.deleteCustEntr", dto);
        return delete;
    }


    // test board, cust JOIN
    public List<BoardCustDTO> joinWithBoard(BoardCustDTO inDTO) {
        List<BoardCustDTO> result = sqlSessionTemplate.selectList("boardMapper.boardJoinCustM", inDTO);
        log.info("JOIN TEST DAO = {}", result);
        return result;
    }

}
