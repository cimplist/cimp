package com.cimplist.cip.epms.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cimplist.cip.epms.domain.KpiHeader;
import com.cimplist.cip.user.dao.UserDAOTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={	
		"classpath:spring/application-config.xml"
		})
public class KpiHeaderDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	@Autowired
	KpiHeaderDAO kpiHeaderDAO;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	@Transactional(readOnly=true)
	public void testFindByUserName() {
		String userName="johnd";
		KpiHeader head = kpiHeaderDAO.findByUserName(userName);
		logger.debug(head.toString());
		
	}

}
