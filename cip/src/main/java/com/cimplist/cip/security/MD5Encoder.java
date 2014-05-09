package com.cimplist.cip.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5Encoder {
	static String salt="idc2014";
	public static void main(String args[]){
		System.out.print(MD5Encoder.encode("password"));
	}
	public static String encode(String password){
		
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String hashedPass = encoder.encodePassword(password, salt);
		
		
		return hashedPass;
		
	}
}
