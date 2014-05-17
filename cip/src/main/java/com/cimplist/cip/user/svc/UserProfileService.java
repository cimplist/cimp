package com.cimplist.cip.user.svc;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimplist.cip.user.dao.UserDAO;
import com.cimplist.cip.user.domain.User;
@Service
public class UserProfileService {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
	 @Inject  	
	 private UserDAO userDAO;

	@Transactional (readOnly=true)	 
	 public User getUserByKey(Long key){
		 User user = userDAO.getByKey(key,User.class);
		 logger.debug(user.toString());
		 return user;
	 }
	@Transactional (readOnly=true)	 
	 public User getUserByUserName(String userName){
		 User user = userDAO.getUserByUserName(userName);
		 logger.debug(user.toString());
		 return user;
	 }
	@Transactional (readOnly=true)	 
	 public User getUserWithTeamByUserName(String userName){
		 User user = userDAO.getUserByUserName(userName);
		 user.getSubordinates().size(); //load subordinates
		 logger.debug(user.toString());
		 return user;
	 }
	@Transactional
	 public void updateUser(User user){
		 userDAO.update(user);
		
	 }
}
