package com.itc.springboot.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookDetailDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7889938648939242355L;

    private Long bookId;

    private String authorName;

    private String bookTitle;

    private String bookDescription;
}
