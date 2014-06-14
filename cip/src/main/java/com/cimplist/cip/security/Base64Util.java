package com.cimplist.cip.security;

import org.springframework.security.crypto.codec.Base64;

public class Base64Util {
	public static String encodeBase64(byte[] encryptionBytes) {
		byte[] cryptBase64 = Base64.encode(encryptionBytes);
		String cryptb64text = new String(cryptBase64);

		return cryptb64text;
	}

	public static byte[] decodeBase64(String encodedB64text) {
		byte[] decoded = Base64.decode(encodedB64text.getBytes());
		return decoded;
	}
}
