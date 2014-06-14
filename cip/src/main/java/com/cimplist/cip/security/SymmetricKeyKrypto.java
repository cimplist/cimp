package com.cimplist.cip.security;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class SymmetricKeyKrypto {

	PrivateKeyCipherManager keymgr = new PrivateKeyCipherManager();

	public static void main(String[] args) throws Exception {
		SymmetricKeyKrypto krypto = new SymmetricKeyKrypto();

		String input = "sanjay singh";
		System.out.println("Entered: " + input);
		String encoded = krypto.encryptEncode(input);

		System.out.println("Encrypted Data: " + encoded);

		System.out.println("Recovered: " + krypto.decryptDecode(encoded));
	}

	public String encryptEncode(String input) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		byte[] encryptionBytes = encrypt(input);

		String encoded = Base64Util.encodeBase64(encryptionBytes);
		return encoded;
	}

	public String decryptDecode(String encryptedEncoded) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		byte[] decoded = Base64Util.decodeBase64(encryptedEncoded);
		String recovered = decrypt(decoded);
		return recovered;
	}
	private byte[] encrypt(String input) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = keymgr.getCipher();

		cipher.init(Cipher.ENCRYPT_MODE, keymgr.getKey());
		byte[] inputBytes = input.getBytes();
		return cipher.doFinal(inputBytes);
	}

	private String decrypt(byte[] encryptionBytes) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = keymgr.getCipher();
		cipher.init(Cipher.DECRYPT_MODE, keymgr.getKey());
		byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
		String recovered = new String(recoveredBytes);
		return recovered;
	}

}
