package com.boot.batis.product.business;

import com.boot.batis.config.aop.annotations.ActionMapping;
import com.boot.batis.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    @ActionMapping
    public ResponseEntity<ProductDTO> save(ProductDTO dto) {
        productService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ProductDTO> findAll() {
        ProductDTO dto = productService.findAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
