package com.boot.batis.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    // Board
    private Long board_no;
    private String board_title;
    private String board_content;
    private String board_writer;
    private Long board_count;

}
