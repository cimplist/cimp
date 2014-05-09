package com.cimplist.cip.user.dao;

import static org.junit.Assert.*;

import java.util.Set;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cimplist.cip.user.dao.UserDAO;
import com.cimplist.cip.user.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={	
		"classpath:spring/application-config.xml"
		})
public class UserDAOTest {
	@Inject
	UserDAO userDAO;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional(readOnly=true)
	public void testFindByKey() {
		User user = userDAO.findByKey(3l);
		System.out.println("User: "+user);
		User manager = user.getManager();
		System.out.println("Manager: "+manager);
		Set<User> team = user.getSubordinates();
		System.out.println("Team: "+team);
	}

}
