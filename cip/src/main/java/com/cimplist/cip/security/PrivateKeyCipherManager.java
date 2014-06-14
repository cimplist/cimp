package com.cimplist.cip.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;


public class PrivateKeyCipherManager {
	private String algorithm = "DESede";
	PrivateKeyDAO dao = new PrivateKeyDAO( algorithm);

	public PrivateKeyCipherManager() {
		try {
			Key key = KeyGenerator.getInstance(algorithm).generateKey();
			dao.saveKey(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Key getKey() {
		return dao.loadKey();

	}

	public String getAlgorithm() {
		return algorithm;
	}

	public Cipher getCipher() {
		 Cipher cipher=null;
		try {
			cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return cipher;
	}


}
