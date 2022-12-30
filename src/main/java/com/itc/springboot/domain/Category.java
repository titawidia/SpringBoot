package com.itc.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7125859384844185149L;

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    //bersifat unidirectional
    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
