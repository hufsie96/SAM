package com.kep.cnp.sam.manageraccount.service;

import com.kep.cnp.sam.manageraccount.factory.JwtFactory;
import com.kep.cnp.sam.manageraccount.repository.ManagerAccountRepository;
import com.kep.cnp.sam.manageraccount.vo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImple implements AccountService {

    @Autowired
    private ManagerAccountRepository managerAccountRepository;

    //@Autowired
    private JwtFactory jwtFactory = new JwtFactory();

    @Override
    public boolean createManager(Manager manager) {
        try {
            managerAccountRepository.save(manager);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Manager getDetailManager(String librarianId){
        return managerAccountRepository.findByLibrarianId(librarianId);
    }

    @Override
    public String generateToken(Manager manager) {
        return jwtFactory.generateToken(manager);
    }

    @Override
    public boolean validationToken(String token) {
        try {
            jwtFactory.decodeJwt(token);
        }catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public Manager checkPassword(Manager manager){
        return managerAccountRepository.findByLibrarianIdAndPassword(manager.getLibrarianId(), manager.getPassword());
    }

    @Override
    public String authentication(Manager manager) {
        if(null == checkPassword(manager)) {
            return "";
        } else {
            return generateToken(manager);
        }
    }

}
