package com.boot.batis.first.controller;

import com.boot.batis.first.dao.CustDAO;
import com.boot.batis.first.dto.CustDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustController {

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
}
