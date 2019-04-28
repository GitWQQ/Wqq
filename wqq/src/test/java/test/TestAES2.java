package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class TestAES2 {
	
	private static final String  enType_AES="AES";
	private static final String pathStr="D://aes.key";
	private static final String testStr="AES tips you shoutld try again";
	
	public static void main(String[] args) {
		SecretKey genSecretKey=testGenerateKey();
		System.out.println("genSecretKey:"+genSecretKey);
		String string = genSecretKey.toString();
		byte[] testEncrypt=testEncrypt(testStr, genSecretKey);
		String testDecode2=testDecrpt(testEncrypt, genSecretKey);
		System.out.println(testDecode2);
	}
	/**
	 * 生成秘钥
	 */
	public static SecretKey testGenerateKey(){
		SecretKey genSecretKey=null;
		try{
			KeyGenerator keyGenerator=KeyGenerator.getInstance(enType_AES);
			SecureRandom sRandom=new SecureRandom();
			keyGenerator.init(sRandom);
			genSecretKey=keyGenerator.generateKey();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return genSecretKey;
	}
	
	/**
	 *加密 
	 */
	public static byte[] testEncryptBytes(String str ,SecretKey genSecretKey){
		byte encrypt[]=null;
		try{
			Cipher cipher = null;
			try {
				cipher = Cipher.getInstance(enType_AES);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				cipher.init(Cipher.ENCRYPT_MODE, genSecretKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				encrypt=cipher.doFinal(str.getBytes());
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(BadPaddingException e){
			e.printStackTrace();
		}
		return encrypt;
	}
	/**
	 * 加密
	 * @param str
	 * @param genSecretKey
	 * @return
	 */
	public static byte[] testEncrypt(String str,SecretKey genSecretKey){
		byte[] testEncryptBytes=testEncryptBytes(str, genSecretKey);
		System.out.println(Arrays.toString(testEncryptBytes));
		System.out.println("加密后的数组长度"+testEncryptBytes.length);
		//return (new String(testEncryptBytes));
		return testEncryptBytes;
	}
	
	
	/**
	 * 解密
	 * 
	 */
	public static String testDecrptBytes(byte[] bytes,SecretKey genSecretKey){
		String decoderStr=null;
		try{
			Cipher cipher=Cipher.getInstance(enType_AES);
			cipher.init(Cipher.DECRYPT_MODE,genSecretKey);
			byte[] doFinal=cipher.doFinal(bytes);
			decoderStr=new String(doFinal);
		}catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
			e.printStackTrace();
		}
		return decoderStr;
	}
	
	public static String testDecrpt(byte[] str,SecretKey genSecretKey){
		//System.out.println(Arrays.toString(str.getBytes()));
		System.out.println("数组的大小"+str.length);
		return testDecrptBytes(str, genSecretKey);
	}
	
}
