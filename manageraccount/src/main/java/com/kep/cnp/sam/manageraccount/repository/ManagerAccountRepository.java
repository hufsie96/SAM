package com.kep.cnp.sam.manageraccount.repository;

import com.kep.cnp.sam.manageraccount.vo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerAccountRepository extends CrudRepository<Manager, String>, JpaRepository<Manager, String> {

    Manager findByLibrarianId(String librarianId);

    Manager findByLibrarianIdAndPassword(String librarianId, String password);

}
