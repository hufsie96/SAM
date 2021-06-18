package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.vo.Book;
import com.kep.cnp.sam.management.vo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagementService {

    public boolean createBook(Book book);

    public boolean deleteBook(String bookId);

    public boolean updateBook(Book book);

    public boolean updateBookStatus(String bookId, String status);

    public Book findBookStatus(String bookId);

    public List<Book> findBookList(String name);

    public List<Book> findBookList(String searchType, String searchData);

    public Book findBookDetail(String bookId);

    public List<Book> findAll();

    public List<Category> getCategoryList();

    public List<Book> findBookListByCategory(String category);
}
