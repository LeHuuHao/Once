package com.trungtamjava.hellospringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trungtamjava.hellospringboot.entity.Person;
import com.trungtamjava.hellospringboot.repository.PersonRepository;
import com.trungtamjava.hellospringboot.repository.ProductRepository;

@Service
public class UserService implements UserDetailsService{

	    @Autowired
	    PersonRepository personRepository;
	   

	    /// lay thong tin user theo username tu DB len
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.getByUsername(username);

		if (person == null) {// ko tim thay
		    throw new UsernameNotFoundException("no user");
		}
		/// convert role -> security role
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(person.getRole()));

		// convert user model -> security user
		User userSecurity = new User(username, person.getPassword(), authorities);

		return userSecurity;
		
		
	    }

}
