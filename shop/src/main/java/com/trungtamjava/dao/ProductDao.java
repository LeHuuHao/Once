package com.trungtamjava.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.model.Product;

public interface ProductDao  extends JpaRepository<Product, Integer>{
//	void add(Product product)throws SQLException ;
//	void delete(int id);
//	void update(Product product);
//	  Product get(int id);// duy nhat
       @Query("SELECT p from Product p WHERE p.username = :uname")//UNIQUE la duy nhat
	  Product getByUserName(@Param("uname") String username);// unique,duy nhat
//tim theo ==
	  List<Product> findByName(String name) ;//hamf nayf tuwj timf theo ten thuowjc tinh co san trong thu vien
	  //tim theo like
	  @Query("SELECT p from Product p WHERE p.username LIKE :uname")
	  List<Product> search(@Param("uname") String name); 
	  

}
