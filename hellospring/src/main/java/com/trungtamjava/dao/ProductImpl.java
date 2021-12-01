//package com.trungtamjava.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.trungtamjava.model.Product;
//@Repository
//public class ProductImpl implements ProductDao{
//   @Autowired 
//   DataSource dataSource;
//	@Override
//	public void add(Product product) throws SQLException {
//		String sql="insert into product(id,username,password,name,price)\r\n"
//				+ "value(?,?,?,?,?);";
//		Connection connection=dataSource.getConnection();
//		PreparedStatement p= connection.prepareStatement(sql);
//		p.setInt(1, product.getId());
//		p.setString(2, product.getUsername());
//		p.setString(3, product.getPassword());
//		p.setString(4, product.getName());
//		p.setInt(5,product.getPrice());
//		p.executeUpdate();
//		
//		
//	}
//
//	@Override
//	public void delete(int id) {
//
//		
//	}
//
//	@Override
//	public void update(Product product) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Product get(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Product getByUsername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Product> search(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
