package com.itc.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -493967282312085855L;

    private Long id;

    private String title;

    private String description;

    private Author author;
}
