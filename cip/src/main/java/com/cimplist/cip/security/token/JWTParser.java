package com.cimplist.cip.security.token;


public class JWTParser {
	final String key_typ="typ";
	final String key_sub="sub";
	private String jwtToken;
	public JWTParser(String jwtToken) {
		this.jwtToken=jwtToken;
	}

	public String getTyp() {
		int i = jwtToken.indexOf(key_typ);
		int j = jwtToken.indexOf(",",i);
		String typ=jwtToken.substring(i+key_typ.length()+1, j);
		return typ;
	}


	public String getSub() {
		int i = jwtToken.indexOf(key_sub);
		int j = jwtToken.indexOf(",",i);
		String sub=jwtToken.substring(i+key_sub.length()+1, j);
		return sub;
	}
	
}
