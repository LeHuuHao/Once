package com.trungtamjava.hellospringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

    //tuy bien cau lenh theo y minh JPQL
    @Query("SELECT u from User u WHERE u.username = :uname")
    User getByUsername(@Param("uname") String username);// unique,duy nhat

    //tim theo ten thuoc tinh
    List<User> findByName(String name); //= , 

    //like
    @Query("SELECT u from User u WHERE u.name LIKE :uname")
    List<User> search(@Param("uname") String name); //== ,
}
