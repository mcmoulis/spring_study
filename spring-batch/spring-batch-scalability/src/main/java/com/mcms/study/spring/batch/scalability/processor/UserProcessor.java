package com.mcms.study.spring.batch.scalability.processor;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.batch.item.ItemProcessor;

import com.mcms.study.spring.batch.scalability.reader.User;

/**
 * 
 * @author user
 *
 */
public class UserProcessor implements ItemProcessor<User, User> {
	@Override
	public User process(User user) throws Exception {
		user.setPassword(getPassword(user.getUserName()));
		return user;
	}

	private String getPassword(String userName) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encode(userName.getBytes()).toString();
	}
}
