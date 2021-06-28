package com.kep.cnp.sam.management.service;

import com.kep.cnp.sam.management.vo.Manager;
import org.springframework.stereotype.Service;

@Service
public class ManagerAccountServiceImple implements ManagerAccountService{

    @Override
    public boolean createManager(Manager manager) {
        return false;
    }

    @Override
    public Manager getDetailManager(String librarianId) {
        return null;
    }

    @Override
    public String generateToken(Manager manager) {
        return null;
    }

    @Override
    public boolean validationToken(String token) {
        return false;
    }

    @Override
    public String checkAuthentication(String librarianId, String password) {
        return null;
    }
}
