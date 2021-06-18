package com.kep.cnp.sam.manageraccount.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String librarianId;

    private String username;

    private String role;

    public AccountDTO(String id, String username, String role){
        this.librarianId = id;
        this.username = username;
        this.role = role;
    }
}
