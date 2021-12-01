package com.trungtamjava.hellospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.entity.UserOrder;

public interface UserOrderReposity extends JpaRepository<UserOrder, Integer>{

}
