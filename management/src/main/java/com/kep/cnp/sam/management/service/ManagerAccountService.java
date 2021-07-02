package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.vo.Manager;

public interface ManagerAccountService {

    public boolean createManager(String jwt_token, Manager manager);

    public Manager getDetailManager(String jwt_token, String librarianId);

    public String generateToken(Manager manager);

    public boolean validationToken(String token);

    public String checkAuthentication(String librarianId, String password);

}
