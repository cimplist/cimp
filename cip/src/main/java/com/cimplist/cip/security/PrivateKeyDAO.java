package com.cimplist.cip.security;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

public class PrivateKeyDAO {
	private String privateKey = null;
	private String algorithm;

	public PrivateKeyDAO(String algorithm) {
		this.algorithm = algorithm;
	}

	public Key loadKey() {
		byte[] pkey = Base64Util.decodeBase64(privateKey);
		Key key = new SecretKeySpec(pkey, algorithm);
		return key;
	}

	public void saveKey(Key key) {
		byte[] pkey = key.getEncoded();

		privateKey = Base64Util.encodeBase64(pkey);
		System.out.println("Private Key Base 64 Encoded: " + privateKey);
	}

}
