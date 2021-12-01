package com.trungtamjava.hellospringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_order_product")
public class UserOrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="user_order_id")
    private UserOrder userOrder;
    private int quanity;
    private double unitPrice;//gias luc mua
    
}
