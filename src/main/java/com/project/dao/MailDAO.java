package com.project.dao;

public interface MailDAO {
	public void send(String toAddress, String subject, String content);
}
