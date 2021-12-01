package com.trungtamjava.hellospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.entity.Person;

public interface PersonDao extends JpaRepository<Person, Integer> {

}
