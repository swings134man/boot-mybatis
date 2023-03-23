package com.boot.batis.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustDTO {

    private String custEmal;		/*고객email*/
    private String custId;			/*고객ID*/
    private String custPw;			/*고객PW*/
    private String custNm;			/*고객이름*/
    private String custHphn;		/*고객핸드폰번호*/
    private String custGen;			/*고객성별*/
    private String custAge;			/*고객나이*/
    private String custAddr;		/*고객주소*/

    private String msg;
}
