package com.trungtamjava.hellospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
