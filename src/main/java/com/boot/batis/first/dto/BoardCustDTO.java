package com.boot.batis.first.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardCustDTO {

    // Cust M
    private Long custNo;
    private String custEmal;		/*고객email*/
    private String custId;			/*고객ID*/
    private String custPw;			/*고객PW*/
    private String custNm;			/*고객이름*/
    private String custHphn;		/*고객핸드폰번호*/
    private String custGen;			/*고객성별*/
    private String custAge;			/*고객나이*/
    private String custAddr;		/*고객주소*/

    // Board
    private Long board_no;
    private String board_title;
    private String board_content;
    private String board_writer;
    private Long board_count;

}
