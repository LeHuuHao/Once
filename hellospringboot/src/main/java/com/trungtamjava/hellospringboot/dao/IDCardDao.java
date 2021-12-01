package com.trungtamjava.hellospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.model.IDCard;

public interface IDCardDao extends JpaRepository<IDCard, Integer> {

}
