package com.trungtamjava.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.trungtamjava.hellospringboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	    List<Product> findByName(String name); // = ,

	    // like
	    @Query("SELECT p from Product p WHERE p.name LIKE :uname")
	    List<Product> search(@Param("uname") String name); // == ,
	    @Query("SELECT p from Product p JOIN p.category c WHERE c.id = :cid")
	    List<Product> searchByCategory(@Param("cid") int cateId); // ==

}
