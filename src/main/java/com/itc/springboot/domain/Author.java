package com.itc.springboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
//@DynamicUpdate
public class Author {

    //postgres -> bigserial
    //mysql -> autoincrement
    //strategy identity -> cons: batch insert disabled
    //batch insert -> stored procedured
    //strategy sequence -> pros: enable batch insert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
