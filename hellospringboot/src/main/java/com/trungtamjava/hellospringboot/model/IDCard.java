package com.trungtamjava.hellospringboot.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Table(name="id_card")
@Entity
public class IDCard {
	    @Id //primary key
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(name = "id_number", unique = true)//ten cot trong bang	    
	    private String id_Number;
	    @Temporal(TemporalType.DATE)
	    @Column(name="issue_Date")
	    private Date issue_Date;
	    @OneToOne
	    @JoinColumn(name ="user_id")
	    private User user;
	    
}
