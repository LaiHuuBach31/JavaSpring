package com.project.dao.impl;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.dao.MailDAO;

@Service("mailService")
public class MailDAOImpl implements MailDAO{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(String toAddress, String subject, String content) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content, true);
			mimeMessageHelper.setSentDate(new Date());
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
