package com.cimplist.cip.epms.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KpiControllerUtil {
	private static final Logger logger = LoggerFactory.getLogger(KpiControllerUtil.class);
	static String prefix ="item.comments.";
	public static Map<Long,String> getKpiReviewComments(Map<String, String[]> form){
		Map<Long,String> comments =  new HashMap<>();
		for(String pname:form.keySet()){
			String val = concat(form.get(pname));
			Long key = getIdFromParamName (pname);
			if(key>=0){
				comments.put(key, val);
			}else{
				
			}
			logger.info(pname+":"+val);	
			
		}
		return comments;
	}
	public static String concat(String[] sr){
		String val="";
		for(String v:sr){
			val=val+v;
		}
		return val;
	}
	public static boolean isComment(String pname){
		if(pname.indexOf(prefix)>=0){
			return true;
		}
		return false;
	}
	public static Long getIdFromParamName(String pname){
		if(isComment( pname)){
			int beginIndex=prefix.length();
			String id = pname.substring(beginIndex);
			return Long.valueOf(id);
			
		}
		return -1L;
	}
}
