package com.boot.batis.first.controller;

import com.boot.batis.first.dao.CustDAO;
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

    @GetMapping("/v1/getOne")
    public CustDTO getOne(@RequestParam String custId) {
        // http://localhost:8080/v1/getOne?custId=seoul
        CustDTO dto = new CustDTO();
        dto.setCustId(custId);

        CustDTO one = dao.getOne(dto);
        System.out.println("one = " + one);
        return one;
    }

    @PostMapping("/v1/saveCustOne")
    public CustDTO saveCustOne(@RequestBody CustDTO dto) {
        return service.saveCustOne(dto);
    }


    @GetMapping("/v1/cust/findAll")
    public List<CustDTO> findAll() {
        List<CustDTO> all = service.findAll();
        System.out.println("all = " + all);
        return all;
    }

    @PutMapping("/v1/cust/update")
    public CustDTO updateCustOne(@RequestBody CustDTO dto) {
        CustDTO result = service.updateCustOne(dto);
        return result;
    }

    @DeleteMapping("/v1/cust/deleteOne")
    public String deleteCustOne(CustDTO dto) {
        String msg = "null";
        int i = service.deleteCustOne(dto);
        if(i == 1) {
            msg = "Delete Success";
        }
        return msg;
    }

}//class
