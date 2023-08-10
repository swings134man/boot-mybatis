package com.boot.batis.product.business;

import com.boot.batis.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface ProductRepository {

    void save(ProductDTO dto);

    List<ProductDTO> findAll();
}
