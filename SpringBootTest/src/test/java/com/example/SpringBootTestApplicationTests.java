package com.example;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.mail.util.MailSSLSocketFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplicationTests {

	@Test
	public void contextLoads() throws GeneralSecurityException, AddressException, MessagingException {
		  //收件人电子邮箱
	      String to="2199037782@qq.com";
	      //发件人电子邮箱
	      String from="3049247202@qq.com";
	      //指定发送邮件的主机为 smtp.qq.com
	      String host="smtp.qq.com";  //QQ邮件服务器
	      //获取系统属性
	      Properties properties=System.getProperties();
	      //设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.auth", "true");
	      /*SSL加密*/
	      MailSSLSocketFactory sf=new MailSSLSocketFactory();
	      sf.setTrustAllHosts(true);
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put("mail.smtp.ssl.socketFactory", sf);
	      //获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	          public PasswordAuthentication getPasswordAuthentication(){
	               return new PasswordAuthentication("3049247202@qq.com", "cygdvcjoeavbdhad"); //发件人邮件用户名、授权码
	          }
          });
          //创建默认的 MimeMessage对象
          MimeMessage message=new MimeMessage(session);
          //Set From:头部头字段
          message.setFrom(new InternetAddress(from));
          //Set To:头部头字段
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
          //Set Subject:头部头字段
          message.setSubject("圣诞快乐!");
          //设置消息体
          message.setText("祝福...");
          //发送消息
          Transport.send(message);
          System.out.println("发送成功!....");
	}

}

