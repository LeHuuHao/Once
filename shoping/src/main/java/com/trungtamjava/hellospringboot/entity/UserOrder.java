package com.trungtamjava.hellospringboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_order")
@Data
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name="buyer_id")
	private Person buyer;
	
	@OneToMany(mappedBy = "userOrder",cascade = CascadeType.ALL)
	List<UserOrderProduct> userOrderProducts;


	

}
