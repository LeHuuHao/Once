package com.trungtamjava.hellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.entity.UserOrderProduct;

public interface UserOrderProductResposity extends JpaRepository<UserOrderProduct, Integer> {

}
