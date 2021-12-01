package com.trungtamjava.hellospringboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="course")
@Data
public class Course {
	@Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "user_course",
    	joinColumns = @JoinColumn(name = "course_id"),
    	inverseJoinColumns = @JoinColumn(referencedColumnName = "user_id")
    )
    private List<User> users;

}
