package com.boot.batis.product.business;

import com.boot.batis.config.aop.annotations.ActionMapping;
import com.boot.batis.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{pdName}", produces = "application/json")
    @ActionMapping
    public ResponseEntity<ProductDTO> getName(@PathVariable String pdName, Map<String, Object> params) throws BadHttpRequest {
        if(pdName == null || pdName.isEmpty()){
            throw new BadHttpRequest();
        }

        if(params == null){
            params = new HashMap<>();
        }
        params.put("pdName", pdName);

        ProductDTO result = productService.getName(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
