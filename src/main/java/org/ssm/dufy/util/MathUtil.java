package org.ssm.dufy.util;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.ssm.dufy.entity.UserInfo;

public class MathUtil {
	/**
	 * 获取随机的数值。
	 */
	public static String getRandom620(Integer length){
		   String result = "";
		   Random rand = new Random();
		   int n = 20;
		   if(null != length && length > 0){
			   n = length;
		   }
	       boolean[]  bool = new boolean[n];
	       int randInt = 0;
	       for(int i = 0; i < length ; i++) {
	            do {
	                randInt  = rand.nextInt(n);

	            }while(bool[randInt]);

	           bool[randInt] = true;
	           result += randInt;
	       }
	       return result;
	}
	
	/**
	 * MD5 加密
	 * @param str
	 * @return
	 * @throws Exception
	 */
	
	 public static String  getMD5(String str) {  
	        MessageDigest messageDigest = null;  
	            try {
					messageDigest = MessageDigest.getInstance("MD5");
					messageDigest.reset();
					messageDigest.update(str.getBytes("UTF-8"));
				} catch (Exception e) {
					LoggerUtils.fmtError(MathUtil.class,e, "MD5转换异常！message：%s", e.getMessage());
				}  
				
	        byte[] byteArray = messageDigest.digest();  
	        StringBuffer md5StrBuff = new StringBuffer();  
	        for (int i = 0; i < byteArray.length; i++) {              
	            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
	                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
	            else  
	                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
	        }  
	        return md5StrBuff.toString();  
	}
	 
	 public static String getSaltPassword(String password){
		 //Subject subject=SecurityUtils.getSubject();
		 //获取身份信息
		 //UserInfo userinfo=(UserInfo)subject.getPrincipal();
		 //生成盐
		 SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
		 String salt=secureRandomNumberGenerator.nextBytes().toHex();
		 System.out.println("salt:"+salt);
		 Md5Hash md5=new Md5Hash(password, salt,1024);
		 System.out.println("md5:"+md5);
		 String newPassword=md5.toHex();
		 //设置新密码
		 //userinfo.setPassword(newPassword);
		 //设置盐
		 //userinfo.setSalt(salt);
		 //更新密码
		 //userInfoService.updatePassword(userinfo);
		 return newPassword;
	 }
	 
	 /**
	  *生成加密盐
	  * @return
	  */
	 public static String getSalt(){
		 SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
		 String salt=secureRandomNumberGenerator.nextBytes().toHex();
		 return salt;
	 }
	 
	 /**
	  * 加密密码=MD5(明文加密)+盐
	  * @param args
	  */
	 
	 public static String getSaltPassword(String salt,String password){
		 Md5Hash md5=new Md5Hash(password,salt,1024);
		 String newPassword=md5.toHex();
		 return newPassword;
	 }
	 
	 /**
	  * 用户ID
	  * @param args
	  */
	 public static String getId(){
		 String time=String.valueOf(new Date().getTime());
		 String a="";
		 Random random=new Random();
		 for(int i=0;i<5;i++){
			a=a+random.nextInt(9);
		 }
		 return (time+a);
	 }
	 
	 public static void main(String[] args) {
		 //System.out.println(getId(UserInfo.class));
		System.out.println( getId());
		 
	 }
}
