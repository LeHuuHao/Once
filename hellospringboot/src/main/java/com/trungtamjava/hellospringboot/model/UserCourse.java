//package com.trungtamjava.hellospringboot.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name="user_course")
//@Data
//public class UserCourse {
//	@Id //primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//	 @ManyToOne
//	  @JoinColumn(name ="user_id")
//	    private User user;
//	@ManyToOne
//    @JoinColumn(name ="course_id")
//    private Course course;
//	private int score;
//	 
//}
