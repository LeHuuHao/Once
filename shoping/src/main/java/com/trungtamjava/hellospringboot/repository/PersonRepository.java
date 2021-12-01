package com.trungtamjava.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	// tuy bien cau lenh theo y minh JPQL
    @Query("SELECT u from Person u WHERE u.username = :uname")
    Person getByUsername(@Param("uname") String username);// unique,duy nhat

    // tim theo ten thuoc tinh
    List<Person> findByName(String name); // = ,

    // like
    @Query("SELECT u from Person u WHERE u.name LIKE :uname")
    List<Person> search(@Param("uname") String name); // == ,

}
