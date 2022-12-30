package com.itc.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3729325249054365078L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    //bersifat relasi dua arah
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
