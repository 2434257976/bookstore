package com.bookstore.utils;

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
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 发送邮件的工具类
 */
public class MailUtils {

	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {

		//定义了一个Properties类型的对象
		Properties props = new Properties();
		//设置邮件传输协议SMTP
		props.setProperty("mail.transport.protocol", "SMTP");
		//设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		//邮件服务器验证
		props.setProperty("mail.smtp.auth", "true");

		//定义验证信息
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("2434257976@qq.com", "itucamellrewdjbf");
			}
		};

		//创建会话：和邮件服务器的会话
		Session session = Session.getInstance(props, auth);

		//发送邮件的相关信息
		Message message = new MimeMessage(session);

		//设置发送方
		message.setFrom(new InternetAddress("2434257976@qq.com"));
		//设置接收方
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		//设置邮件的主题
		message.setSubject("用户激活");
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
		//设置邮件内容的编码格式
		message.setContent(emailMsg, "text/html;charset=utf-8");


		Transport.send(message);
	}
}
