package com.kep.cnp.sam.management.repository;

import com.kep.cnp.sam.management.vo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findByNameLike(String name);
}
