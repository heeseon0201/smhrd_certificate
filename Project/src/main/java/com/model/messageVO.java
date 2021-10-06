package com.model;

public class messageVO {
	private int num;
	private String sendEmail;
	private String receiveEmail;
	private String message;
	private String m_day;

	public messageVO(String sendEmail, String receiveEmail, String message) {
		super();
		this.sendEmail = sendEmail;
		this.receiveEmail = receiveEmail;
		this.message = message;
	}

	public messageVO(int num, String sendEmail, String receiveEmail, String message, String m_day) {
		super();
		this.num = num;
		this.sendEmail = sendEmail;
		this.receiveEmail = receiveEmail;
		this.message = message;
		this.m_day = m_day;
	}

	public int getNum() {
		return num;
	}

	public String getSendEmail() {
		return sendEmail;
	}

	public String getReceiveEmail() {
		return receiveEmail;
	}

	public String getMessage() {
		return message;
	}

	public String getM_day() {
		return m_day;
	}
	
	
}
