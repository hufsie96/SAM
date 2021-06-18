package com.kep.cnp.sam.manageraccount.service;

import com.kep.cnp.sam.manageraccount.vo.Manager;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public boolean createManager(Manager manager);

    public Manager getDetailManager(String librarianId);

    public String generateToken(Manager manager);

    public boolean validationToken(String token);

    public Manager checkPassword(Manager manager);

    public String authentication(Manager manager);
}
