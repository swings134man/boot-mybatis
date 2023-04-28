package com.boot.batis.product.dto;

import lombok.Data;

/************
 * @info : Product DTO Class
 * @name : ProductDTO
 * @date : 2023/04/28 11:32 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Data
public class ProductDTO {

    private int pd_id;
    private String pd_name;
    private Long pd_price;
    private String pd_subject;
    private String created_date;
    private String modified_date;

}
