package test;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class ShiroBase64 {

	public static void main(String[] args) {
		//base64进行编码/解码
		System.out.println("Base64进行编码/解码");
		String str="Hello World";
		String base64Encoded=Base64.encodeToString(str.getBytes());
		String str2=Base64.decodeToString(base64Encoded);
		System.out.println("原来："+str);
		System.out.println("加密后："+base64Encoded);
		System.out.println("解密后："+str2);
		System.out.println("==================================");
		//16进制字符串进行编码/解码
		System.out.println("16进制进行编码/解码");
		String str16="Hello World";
		String encoded=Hex.encodeToString(str16.getBytes());
		String decoded=new String(Hex.decode(encoded.getBytes()));
		System.out.println("原字符串："+str16);
		System.out.println("加密后字符串："+encoded);
		System.out.println("解密后自妇产："+decoded);
		System.out.println("==================================");
		System.out.println("MD5散列值编码");
		String str3="Hello World";
		String salt="薛婉婉";
		String md5=new Md5Hash(str3, salt).toString();
		String md52=new Md5Hash(str3, salt,1024).toString();
		System.out.println("原字符串："+str3);
		System.out.println("盐："+salt);
		System.out.println("加密后："+md5);
		System.out.println("加密1024次后："+md52);
		
		System.out.println("=====================================");
		System.out.println("SHA散列编码");
		String strSHA="Hello World";
		String saltSHA="薛婉婉";
		String sha=new Sha256Hash(strSHA, saltSHA, 1024).toString();
		System.out.println("原字符串："+strSHA);
		System.out.println("盐:"+saltSHA);
		System.out.println("加密后："+sha);
		System.out.println("===============================");
		Encode();
	}
	
	public static void Encode(){
		DefaultHashService hashService=new DefaultHashService();//默认算法sha512
		hashService.setHashAlgorithmName("SHA-512");
		hashService.setPrivateSalt(new SimpleByteSource("123"));//私盐
		hashService.setGeneratePublicSalt(true);//是否生成公盐
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐
		hashService.setHashIterations(1);//生成hash值的迭代次数
		HashRequest request=new HashRequest.Builder().setAlgorithmName("MD5")
				.setSource(ByteSource.Util.bytes("hello"))
				.setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
		String hex=hashService.computeHash(request).toHex();	
		System.out.println("hex:"+hex);
	}
}
