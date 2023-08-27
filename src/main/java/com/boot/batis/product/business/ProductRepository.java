package com.boot.batis.product.business;

import com.boot.batis.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper // MyBatis Config에서 Base Packge 설정 시 생략 가능
public interface ProductRepository {

    void save(ProductDTO dto);

    List<ProductDTO> findAll();
    ProductDTO getProduct(Map<String, Object> params);
}
