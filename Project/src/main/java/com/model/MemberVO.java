package com.model;

public class MemberVO {
	// 필드 선언
	// private : 현재 객체 내에서만 접근가능
	private int member_no;	// 회원번호
	private String member_id;	// 회원아이디
	private String member_NM;	// 이름
	private String member_tel;	// 전화번호
	private String member_address;	// 주소
	private String member_interest;	// 관심분야
	private String member_job;	// 직업
	private String member_pw;	// 비밀번호
	
	// 생성자
	public MemberVO(int member_no, String member_id, String member_NM, String member_tel, String member_address,
			String member_interest, String member_job, String member_pw) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_NM = member_NM;
		this.member_tel = member_tel;
		this.member_address = member_address;
		this.member_interest = member_interest;
		this.member_job = member_job;
		this.member_pw = member_pw;
	}
	
	public MemberVO(String member_id, String member_NM, String member_tel, String member_address,
			String member_interest, String member_job, String member_pw) {
		super();
		this.member_id = member_id;
		this.member_NM = member_NM;
		this.member_tel = member_tel;
		this.member_address = member_address;
		this.member_interest = member_interest;
		this.member_job = member_job;
		this.member_pw = member_pw;
	}

	// 메소드(get,set)
	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_NM() {
		return member_NM;
	}

	public void setMember_NM(String member_NM) {
		this.member_NM = member_NM;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_interest() {
		return member_interest;
	}

	public void setMember_interest(String member_interest) {
		this.member_interest = member_interest;
	}

	public String getMember_job() {
		return member_job;
	}

	public void setMember_job(String member_job) {
		this.member_job = member_job;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
}
