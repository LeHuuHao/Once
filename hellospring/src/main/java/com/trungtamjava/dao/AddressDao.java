package com.trungtamjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.model.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
