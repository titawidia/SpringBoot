package com.itc.springboot.repository;

import com.itc.springboot.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //method name convention
    //find+keyword
    //sql -> select * from Author a where a.id= :authorId
    public Optional<Author> findById(Long id);

    //where id = :id AND deleted=false
    public Optional<Author> findByIdAndDeletedFalse(Long id);

    //sql -> select * from Author a where a.name LIKE : authorId
    public List<Author> findByNameLike(String authorName);

}
