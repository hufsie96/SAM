package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.vo.Manager;

public interface ManagerAccountService {

    public boolean createManager(Manager manager);

    public Manager getDetailManager(String librarianId);

    public String generateToken(Manager manager);

    public boolean validationToken(String token);

    public String checkAuthentication(String librarianId, String password);

}
