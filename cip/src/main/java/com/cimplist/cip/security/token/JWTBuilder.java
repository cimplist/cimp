package com.cimplist.cip.security.token;

import java.util.Date;

public class JWTBuilder {
	private String typ="JWT";
	private String iss;
	private String sub;
	private String ipAddress;
	private Date exp;
	private Date nbf=new Date();
    private String alg = "none";

	public String toString() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("{ ");
		sbuf.append("typ:").append("'").append(typ).append("'").append(",");
		sbuf.append("iss:").append("'").append(iss).append("'").append(",");
		sbuf.append("alg:").append("'").append(alg).append("'").append(",");
		
		sbuf.append("sub:").append("'").append(sub).append("'").append(",");
		sbuf.append("ipAddress:").append("'").append(ipAddress).append("'").append(",");
		sbuf.append("exp:").append("'").append(exp).append("'").append(",");
		sbuf.append("nbf:").append("'").append(nbf).append("'");

		sbuf.append(" }");
		
		return sbuf.toString();
	}


	public JWTBuilder addTyp(String typ) {
		this.typ = typ;
		return this;
	}


	public JWTBuilder addIss(String iss) {
		this.iss = iss;
		return this;

	}


	public JWTBuilder addSub(String sub) {
		this.sub = sub;
		return this;

	}


	public JWTBuilder addIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;

	}


	public JWTBuilder addExp(Date exp) {
		this.exp = exp;
		return this;

	}


	public JWTBuilder addNbf(Date nbf) {
		this.nbf = nbf;
		return this;

	}
	
}
