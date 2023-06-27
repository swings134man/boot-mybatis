package com.boot.batis.first.controller;

import com.boot.batis.config.aop.annotations.ActionMapping;
import com.boot.batis.first.dao.CustDAO;
import com.boot.batis.first.dto.BoardCustDTO;
import com.boot.batis.first.dto.CustDTO;
import com.boot.batis.first.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustController {

    private final CustService service;
    private final CustDAO dao;

    @ActionMapping
    @GetMapping("/v1/getOne")
    public CustDTO getOne(@RequestParam String custId) {
        // http://localhost:8080/v1/getOne?custId=seoul
        CustDTO dto = new CustDTO();
        dto.setCustId(custId);

        CustDTO one = dao.getOne(dto);
        return one;
    }

    @ActionMapping
    @GetMapping("cust/{id}")
    public CustDTO apiGetOne(@PathVariable String id) {
        CustDTO dto = new CustDTO();
        dto.setCustId(id);

        CustDTO one = dao.getOne(dto);
        return one;
    }

    @ActionMapping
    @PostMapping("/v1/saveCustOne")
    public CustDTO saveCustOne(@RequestBody CustDTO dto) {
        return service.saveCustOne(dto);
    }


    @ActionMapping
    @GetMapping("/v1/cust/findAll")
    public List<CustDTO> findAll() {
        List<CustDTO> all = service.findAll();
        return all;
    }

    @ActionMapping
    @GetMapping("/v1/cust/all/paging")
    public List<CustDTO> findAllPaging(@RequestParam(required = false) String custId,
                                       @RequestParam(required = false) String custNm,
                                       @RequestParam int pageNo,
                                       @RequestParam int pageRow) {
        CustDTO dto = CustDTO.builder()
                .custId(custId)
                .custNm(custNm)
                .build();

        List<CustDTO> allPaging = service.findAllPaging(dto, pageNo, pageRow);
        return allPaging;
    }

    @ActionMapping
    @PutMapping("/v1/cust/update")
    public CustDTO updateCustOne(@RequestBody CustDTO dto) {
        CustDTO result = service.updateCustOne(dto);
        return result;
    }

    @ActionMapping
    @DeleteMapping("/v1/cust/deleteOne")
    public String deleteCustOne(CustDTO dto) {
        String msg = "null";
        int i = service.deleteCustOne(dto);
        if(i == 1) {
            msg = "Delete Success";
        }
        return msg;
    }

    // test board, cust JOIN
    // board_writer 혹은, custId를 파라미터로 받는다.
    @GetMapping("/v1/board/joinCust")
    public List<BoardCustDTO> joinWithBoard(@RequestParam String board_writer) {
        BoardCustDTO dto = new BoardCustDTO();
        dto.setBoard_writer(board_writer);

        List<BoardCustDTO> result = service.joinWithBoard(dto);
        return result;
    }

}//class
