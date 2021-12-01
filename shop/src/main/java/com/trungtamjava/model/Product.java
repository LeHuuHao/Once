
package com.trungtamjava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

//ORM:OBIJECT relation mapping

@Entity
@Table(name="product")//name laf ten bangr ow data
@Data
public class Product {
	@Id //khoas chinh
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name="username",unique = true)//ten cot trong bangr//neu ko trung ten cot
	private String username;//trung ten cot
	private String password;
	private int price;
	private String name;
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private Address address;
	

}
