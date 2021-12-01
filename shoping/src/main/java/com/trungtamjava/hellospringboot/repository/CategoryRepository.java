package com.trungtamjava.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("SELECT p from Category p WHERE p.name = :name") // ten class
	Category getByname(@Param("name") String name);// unique,duy nhat

	List<Category> findByname(String name);
	
	@Query("SELECT p from Category p WHERE p.name LIKE :name")
	List<Category> search(@Param("name") String name) ; //==
}
