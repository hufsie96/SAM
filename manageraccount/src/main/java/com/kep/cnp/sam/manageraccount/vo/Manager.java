package com.kep.cnp.sam.manageraccount.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


/**
 * 관리자 계정을 나타내는 entity root로 repository의 manager table에 대한 정보를 나태낸다.
 *
 * @author jackie.choi
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="manager")
public class Manager {

    public Manager(String librarianId, String password){
        this.librarianId = librarianId;
        this.password = password;
    }


    public Manager(String librarianId, String password, String name, String role, String gender, Date birthDay,
                   String address, String phone, String email){
        this.librarianId = librarianId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    //@NotEmpty(message = "id cannot be empty.")
    private String librarianId;

    @NotEmpty(message = "name cannot be empty.")
    private String name;

    private String role;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    private String address;

    @NotEmpty(message = "password cannot be empty.")
    private String password;

    private String phone;

    @NotEmpty(message = "email cannot be empty.")
    private String email;

}
