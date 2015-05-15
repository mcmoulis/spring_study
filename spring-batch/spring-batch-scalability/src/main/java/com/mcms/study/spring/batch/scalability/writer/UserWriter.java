package com.mcms.study.spring.batch.scalability.writer;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.mcms.study.spring.batch.scalability.reader.User;

@Component
public class UserWriter implements ItemWriter<User> {

	private static final Logger log = LoggerFactory.getLogger(UserWriter.class);

	private SimpleJdbcInsert userInsert;

	@Inject
	public UserWriter(DataSource dataSource) {
		userInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("USER_INFO");
	}

	@Override
	public void write(List<? extends User> userList) throws Exception {
		for (User user : userList) {
			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("FIRST_NAME", user.getFirstName())
					.addValue("LAST_NAME", user.getLastName())
					.addValue("USER_NAME", user.getUserName())
					.addValue("PASSWORD", user.getPassword());
			userInsert.execute(parameterSource);
		}

	}
}
