package com.cimplist.cip.user.web;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cimplist.cip.user.domain.User;
import com.cimplist.cip.user.svc.UserProfileService;

@Controller
@RequestMapping(value = "/userprofile")	
public class UserProfileController {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	@Inject
	private UserProfileService userService;
	
	@RequestMapping(value = "/myteam")	
	public String myTeam(HttpServletRequest request, Model model) {  
		String userName=request.getParameter("userName");		
		if(userName==null){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			userName = userDetails.getUsername();
			Collection<GrantedAuthority> roles=	(Collection<GrantedAuthority>) userDetails.getAuthorities();
			for(GrantedAuthority role:roles){
				logger.info(role.getAuthority());
			}
		}
		User user = userService.getUserWithTeamByUserName(userName);
		Set<User> team = user.getSubordinates();
		model.addAttribute("team",team);
		model.addAttribute("user",user);
		return "myteam.tile";
	}
	@RequestMapping(value = "/myaccount")	
	public String myAccount(Model model) {  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		String userName = userDetails.getUsername();
		User user = userService.getUserWithTeamByUserName(userName);
		model.addAttribute("user",user);
		return "myaccount.tile";
	}
}
