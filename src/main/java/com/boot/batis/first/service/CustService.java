package com.boot.batis.first.service;

import com.boot.batis.first.dao.CustDAO;
import com.boot.batis.first.dto.BoardCustDTO;
import com.boot.batis.first.dto.CustDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/************
 * @info : Cust 고객 서비스
 * @name : CustService
 * @date : 2023/03/28 2:14 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Caching 기능 사용.
 *
 * - update 시 cache 또한 update 필요! -> Cache 의 업데이트가 없으면 '변경 전'의 값이 계속 Return 됨.
 *
 * - Delete Cache : 전체 캐시를 지우고 싶을 때는 @CacheEvict(values = "target", allEntries = true)
 *      -> 부분 삭제 : @CacheEvict(values = "target", key = "#id")
 ************/
@Service
@RequiredArgsConstructor
@Slf4j
public class CustService {

    private final CustDAO dao;

    // 고객 1개
    @Transactional
    @Cacheable(value = "cust", key = "#dto.custId")
    public CustDTO saveCustOne(CustDTO dto) {
        int i = dao.saveCustOne(dto);
        if(i == 0) {
            throw new RuntimeException("DB 에 저장되지 않았음.");
        }

        return dto;
    }// save


    // 전체 고객
    @Transactional(readOnly = true)
    @Cacheable("cust")
    public List<CustDTO> findAll() {
        List<CustDTO> result = dao.findAll();
        log.info("SERVICE : findAll Logic called");
        return result;
    }

    // 고객 리스트 페이징
    // pageNo - 페이지 번호, pageRow - 한페이지당 보여야 하는 갯수.
    @Transactional(readOnly = true)
    public List<CustDTO> findAllPaging(CustDTO dto, int pageNo, int pageRow) {
        int pageNumber = (pageNo - 1) * pageRow;

        List<CustDTO> paging = dao.findPaging(dto, pageNumber, pageRow);
        return paging;
    }

    // 고객 1개 update(수정)
    // DB Update시 Cache또한 Update -> custDTO 의 Cache의 Key는 cust로 지정했으므로 똑같이 설정해주어야 한다.
    @Transactional
    @CachePut(value = "cust", key = "#dto.custId")
    public CustDTO updateCustOne(CustDTO dto) {
        int i = dao.upateCustOne(dto);

        if(i == 1){
            log.info("Update Success");

            return dto;
        }else {throw new RuntimeException("Update 실패");}
    }// update


    // delete
    @Transactional
    @CacheEvict(value = "cust", allEntries = true)
    public int deleteCustOne(CustDTO dto) {
        int i = dao.deleteCustOne(dto);
        if(i == 1) {
            log.info("Service(cust) Delete Success = {}", dto.getCustId());
            return i;
        }else {throw new RuntimeException("Delete 실패");}
    }//delete

    // test board, cust JOIN
    public List<BoardCustDTO> joinWithBoard(BoardCustDTO inDTO) {
        List<BoardCustDTO> boardCustDTO = dao.joinWithBoard(inDTO);
        return boardCustDTO;
    }

}
