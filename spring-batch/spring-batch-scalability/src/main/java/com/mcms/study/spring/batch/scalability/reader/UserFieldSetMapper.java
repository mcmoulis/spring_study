package com.mcms.study.spring.batch.scalability.reader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UserFieldSetMapper implements FieldSetMapper<User> {

	@Override
	public User mapFieldSet(FieldSet fieldSet) throws BindException {
		final User userInfo = new User();
		userInfo.setFirstName(fieldSet.readString("firstName"));
		userInfo.setLastName(fieldSet.readString("lastName"));
		userInfo.setUserName(fieldSet.readString("userName"));
		return userInfo;
	}

}
