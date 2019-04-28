package org.ssm.dufy.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailOperation {

	/**
	 * �����ʼ�
	 * @param user����������
	 * @param password��Ȩ��
	 * @param host
	 * @param from������
	 * @param to����������
	 * @param subject�ʼ�����
	 * @param content�ʼ�����
	 * @return success���ͳɹ���failure����ʧ��
	 * @return
	 */
	public String sendMail(String user,String password,String host,
			String from ,String to,String subject,String content){
		if(to!=null){
			Properties props=System.getProperties();
			props.put("mail.smtp.host",host);
			props.put("mail.smtp.auth","true");
			MailAuthenticator auth=new MailAuthenticator();
			MailAuthenticator.USERNAME=user;
			MailAuthenticator.PASSWORD=password;
			Session session=Session.getInstance(props,auth);
			session.setDebug(true);
			try{
				MimeMessage message=new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				if(!to.trim().equals("")){
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress(to.trim()));
				}
				message.setSubject(subject);
				MimeBodyPart mbp1=new MimeBodyPart();//����
				mbp1.setContent(content,"text/html;charset=utf-8");
				Multipart mp=new MimeMultipart();//�����ʼ���
				mp.addBodyPart(mbp1);
				message.setContent(mp);
				message.setSentDate(new Date());
				message.saveChanges();
				Transport trans=session.getTransport("smtp");
				trans.send(message);
				System.out.println(message.toString());
			}catch(Exception e){
				e.printStackTrace();
				return "failure";
			}
			return "success";
		}else{
			return "failure";
		}
	}
	
	public static void main(String[] args) {
		MailOperation operation = new MailOperation();
        String user = "1640611853@qq.com";
        String password ="nhwbobugeidwddac";
        String host = "smtp.qq.com";
        String from = "1640611853@qq.com";
        String to = "1640611853@qq.com";// �ռ���
        String subject = "javaʵ�����䷢�Ͳ���";
        //��������
        StringBuffer sb = new StringBuffer();
       // String yzm = RandomUtil.getRandomString(6);
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>��ܰ��ʾ��</span>"
                          + "<div style='width:950px;font-family:arial;'>��ӭʹ��NET΢�������ע����Ϊ��<br/><h2 style='color:green'></h2><br/>���ʼ���ϵͳ�Զ�����������ظ���<br/>��л����ʹ�á�<br/>���ݶ���������������޹�˾</div>"
                         +"</div>");
        try {
            String res = operation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            System.out.println(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
