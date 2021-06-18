package com.kep.cnp.sam.management.vo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Component
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="book")
public class Book {

    @Id
    private String bookId;

    private String category;

    private String name;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    private String company;

    private String writer;

    private String status;

    private int quantity;

}
