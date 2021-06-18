package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.repository.BookRepository;
import com.kep.cnp.sam.management.repository.CategoryRepository;
import com.kep.cnp.sam.management.util.DateFormatter;
import com.kep.cnp.sam.management.vo.Book;
import com.kep.cnp.sam.management.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementServiceImple implements ManagementService {

    Book book;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean createBook(Book book){
        if ( 0 < book.getQuantity()  )
            book.setStatus("최초등록");
            for(int i = 1; i <= book.getQuantity(); i++){
                book.setBookId(book.getCategory() + "-" + DateFormatter.getDateToString(book.getPublishDate()) + "-" + i);
                bookRepository.save(book);
            }
        return true;
    };

    public boolean deleteBook(String bookId){
        bookRepository.deleteById(bookId);
        return true;
    };

    public boolean updateBook(Book book){
        bookRepository.save(book);
        return true;
    };

    public boolean updateBookStatus(String bookId, String status){
        bookRepository.save(book);
        return true;
    };

    public Book findBookStatus(String bookId){
        Book book = bookRepository.findByStatus(bookId);
        return book;
    };

    public List<Book> findBookList(String search){
        String name = search, catetory = search, company = search;
        List<Book> books = bookRepository.findByNameContainingOrCategoryOrCompany(name, catetory, company);
        return books;
    };

    /*{"도서명", "카테고리", "저자"}*/
    public List<Book> findBookList(String searchType, String searchData){
        List<Book> books = null;
        if("도서명".equals(searchType))
            books = bookRepository.findByName(searchData);
        if("카테고리".equals(searchType))
            books = bookRepository.findByCategory(searchData);
        if("저자".equals(searchType))
            books = bookRepository.findByWriter(searchData);

        return books;
    };

    public Book findBookDetail(String bookId){
        Book book = bookRepository.findByBookId(bookId);

        return book;
    };

    public List<Book> findAll(){
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(e -> books.add(e));
        return books;
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> categorys = categoryRepository.findAll();
        return categorys;
    }

    @Override
    public List<Book> findBookListByCategory(String category) {
        List<Book> books = bookRepository.findByCategory(category);
        return books;
    }

}
