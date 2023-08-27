package com.boot.batis.product.business;

import com.boot.batis.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    public List<ProductDTO> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ProductDTO getName(Map<String, Object> params) {
        return repository.getProduct(params);
    }
}
