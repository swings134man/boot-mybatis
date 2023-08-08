package com.boot.batis.product.business;

import com.boot.batis.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository repository;

    @Transactional
    public void save(ProductDTO dto) {
        log.info("ProductService save = {}", dto);
        repository.save(dto);
    }

    public ProductDTO findAll() {
        return repository.findAll();
    }
}
