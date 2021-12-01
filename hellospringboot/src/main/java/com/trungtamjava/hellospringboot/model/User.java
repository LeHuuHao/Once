package com.trungtamjava.hellospringboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

//ORM: Object Relation Mappping
@Data
@Entity
@Table(name = "user")//name la  ten bang o DB
public class User {
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "username", unique = true)//ten cot trong bang
    private String username;//trung ten cot
    
    private String password;
    private String role; // Admin, Member, Teacher
    private String name;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private IDCard card;
    
    //khong yeu cau
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Car> cars;
    @ManyToMany
    @JoinTable(name="user_course", joinColumns = @JoinColumn(name="user_id"))
    private List<Course> courses;


}