package com.boot.batis.product.dto;

import lombok.Data;

import java.io.Serializable;

/************
 * @info : Product DTO Class
 * @name : ProductDTO
 * @date : 2023/04/28 11:32 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Data
public class ProductDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private int pdId;
    private String pdName;
    private Long pdPrice;
    private String pdSubject;
    private String createdDate;
    private String modifiedDate;

}
