package com.kep.cnp.sam.management.vo;

//import com.sun.beans.decoder.ValueObject;
import lombok.*;

import javax.persistence.*;

@Data
//@Embeddable
@Entity(name="category")
public class Category {
    @Id
    private String id;
    @Column
    private String name;
}
