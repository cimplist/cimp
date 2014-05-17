package com.cimplist.cip.epms.web;


import java.util.Enumeration;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cimplist.cip.epms.domain.KpiHeader;
import com.cimplist.cip.epms.domain.KpiReviewHeader;
import com.cimplist.cip.epms.svc.KpiService;
import com.cimplist.cip.user.domain.User;
import com.cimplist.cip.user.svc.UserProfileService;

@Controller
@RequestMapping(value = "/kpi")	
public class KpiController {
	private static final Logger logger = LoggerFactory.getLogger(KpiController.class);
	@Inject
	private KpiService kpiService;
	@Inject
	private UserProfileService userService;
	
	@RequestMapping(value = "/get")	
	public String getKpi(@ModelAttribute KpiHeader kpiHeader ,HttpServletRequest request, Model model) {  
		String userName=request.getParameter("userName");	
		if(userName==null){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			userName = userDetails.getUsername();
		}
		KpiHeader kpiHeaderReloaded = kpiService.getKpi(userName);
		
		if(kpiHeaderReloaded!=null){
			model.addAttribute("kpiHeader",kpiHeaderReloaded);
		}
		
		
		User user = userService.getUserWithTeamByUserName(userName);
		model.addAttribute("user",user);
		
		return "mykpi.tile";
	}
	@RequestMapping(value = "/kpiReview")	
	public String kpiReview( HttpServletRequest request, Model model) {  
		String userName=request.getParameter("user.userName");	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		String reviewer = userDetails.getUsername();
		User reviewedBy = userService.getUserByUserName(reviewer);
		
		KpiReviewHeader kpiReviewHeader = kpiService.createKpiReviewForUser(userName);	
		kpiReviewHeader.setReviewedBy(reviewedBy);
		
		model.addAttribute("kpiReviewHeader",kpiReviewHeader);
		logger.info(kpiReviewHeader.getKpiReviewItems().toString());
		
		return "mykpireview.tile";
	}
	@RequestMapping(value = "/saveKpiReview")	
	public String kpiReviewSave(@RequestParam Long key, HttpServletRequest request, Model model) {  
		KpiReviewHeader kpiReviewHeader = kpiService.loadKPIReviewHeader(key);
		logger.info(kpiReviewHeader.toString());
		
		Map<String, String[]> form = request.getParameterMap();
		for(String p:form.keySet()){
			logger.info(p+":"+form.get(p));	
			
		}
		
		model.addAttribute("kpiReviewHeader",kpiReviewHeader);
		
		return "mykpireview.tile";
	}
}
