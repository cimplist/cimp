package com.cimplist.cip.user.dao;

import static org.junit.Assert.*;

import java.util.Set;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cimplist.cip.user.dao.UserDAO;
import com.cimplist.cip.user.domain.User;
import com.cimplist.cip.user.web.rest.UserProfileRESTroller;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={	
		"classpath:spring/application-config.xml"
		})
public class UserDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileRESTroller.class);

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
		for(int i=0;i<1;i++){
			logger.info("1>*******************Running Load for user Key:"+3);

			User user = userDAO.getByKey(3l,User.class);
			System.out.println("User: "+user);
			User manager = user.getManager();
			System.out.println("Manager: "+manager);
			Set<User> team = user.getSubordinates();
			System.out.println("Team: "+team);
		}
	}
	@Test
	@Transactional(readOnly=true)
	public void testFindByKey2() {
		for(int i=0;i<1;i++){
			logger.info("2->*******************Running Load for user Key:"+3);

			User user = userDAO.getByKey(3l,User.class);
			System.out.println("User: "+user);
			User manager = user.getManager();
			System.out.println("Manager: "+manager);
			Set<User> team = user.getSubordinates();
			System.out.println("Team: "+team);
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testFindByUserName() {
		String userName="samm";
		for(int i=0;i<1;i++){
			logger.info("2->++++++**********Running Load for user ID:"+userName);

			User user = userDAO.getUserByUserName(userName);
			System.out.println("User: "+user);
			User manager = user.getManager();
			System.out.println("Manager: "+manager);
			Set<User> team = user.getSubordinates();
			System.out.println("Team: "+team);
		}
	}
	@Test
	@Transactional(readOnly=true)
	public void testFindByUserName2() {
		String userName="samm";
		for(int i=0;i<1;i++){
			logger.info("2->++++++**********Running Load for user ID:"+userName);

			User user = userDAO.getUserByUserName(userName);
			System.out.println("User: "+user);
			User manager = user.getManager();
			System.out.println("Manager: "+manager);
			Set<User> team = user.getSubordinates();
			System.out.println("Team: "+team);
		}
	}
	

}
