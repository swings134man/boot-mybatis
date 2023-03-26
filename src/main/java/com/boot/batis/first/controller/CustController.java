package com.boot.batis.first.controller;

import com.boot.batis.first.dao.CustDAO;
import com.boot.batis.first.dto.CustDTO;
import com.boot.batis.first.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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



}//class
