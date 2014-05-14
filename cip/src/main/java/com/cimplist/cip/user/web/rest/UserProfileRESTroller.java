package com.cimplist.cip.user.web.rest;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cimplist.cip.user.domain.User;
import com.cimplist.cip.user.svc.UserProfileService;

@RestController
@RequestMapping(value = "/rest/user")	
public class UserProfileRESTroller {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileRESTroller.class);
	@Inject
	private UserProfileService userService;

	@RequestMapping(value = "/{userName}" , method = RequestMethod.GET, produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public User get(@PathVariable("userName") String  userName) {  
		logger.info("Calling JSON service /user/"+userName);
		User user = userService.getUserWithTeamByUserName(userName);
		//user= new User();
		//user.setUserName(userName);
		return user;
	}

	
}