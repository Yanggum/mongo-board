package com.myproject.board.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "board")
@TypeAlias("board")
public class Board {
    @Id
    private String _id;
    private String title;
    private String content;
    private String author;
    private Long hit;
    private String createdDate;
    private String modifiedDate;
}
