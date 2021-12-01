package com.trungtamjava.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.entity.UserOrder;

public interface UserOderResposity extends JpaRepository<UserOrder, Integer>{
	@Query("SELECT a from UserOrder a JOIN a.buyer b WHERE b.id = :bid")
    List<UserOrder> searchByBuyer(@Param("bid") int buyerId); // ==

}
