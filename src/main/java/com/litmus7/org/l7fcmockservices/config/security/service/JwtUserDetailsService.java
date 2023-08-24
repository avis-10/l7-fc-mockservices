package com.litmus7.org.l7fcmockservices.config.security.service;

import java.util.ArrayList;
import java.util.Optional;

import com.litmus7.org.l7fcmockservices.config.security.repo.AuthUser;
import com.litmus7.org.l7fcmockservices.config.security.repo.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<AuthUser> optUser = repo.findById(username);
		if (optUser.isPresent()) {
			return new User(optUser.get().getUsername(), optUser.get().getEncryptedPassword(), new ArrayList<>());
		} else {
			System.out.println("No User Found");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
//		if ("admin".equals(username)) {
//			return new User(
//				"admin",
////				"demo@123",
//				"$2a$10$.KHH/tBblriAEr8xYyAhSOah0kg.v.XaZoIZOc8wFT5urnwqMCpim",
//				new ArrayList<>()
//			);
//
//		} else if ("avis".equals(username)) {
//			return new User(
//					"avis",
////					"avis@10",
//				"$2a$12$grSUF050gMxJMKBh33IWzOKQO7/W.6b37w8PVHkZ8UkYSPI9BXAXK",
//					new ArrayList<>()
//			);
//		} else {
//			System.out.println("No User Found");
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
}
