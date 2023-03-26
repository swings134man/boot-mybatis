package com.boot.batis.first.service;

import com.boot.batis.first.dao.CustDAO;
import com.boot.batis.first.dto.CustDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustService {

    private final CustDAO dao;

    public CustDTO saveCustOne(CustDTO dto) {
        int i = dao.saveCustOne(dto);
        if(i == 0) {
            throw new RuntimeException("DB 에 저장되지 않았음.");
        }

        return dto;
    }

}
