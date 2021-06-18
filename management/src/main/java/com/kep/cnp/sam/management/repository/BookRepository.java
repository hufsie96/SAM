package com.kep.cnp.sam.management.repository;

import com.kep.cnp.sam.management.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String>, JpaRepository<Book, String> {

 Book findByStatus(String bookId);

 List<Book> findByNameContainingOrCategoryOrCompany(String name, String category, String company);

 Book findByBookId(String bookId);

 List<Book> findByCategory(String category);

 List<Book> findByName(String name);

 List<Book> findByWriter(String writer);

}
