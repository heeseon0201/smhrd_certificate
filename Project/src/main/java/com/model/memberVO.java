package com.model;

public class memberVO {//(memberValueObject)
	
	//필드(속성)선언
	//private: 접근제한자(현재 객체 내에서만 접근가능)
	private String id;
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	//생성자 반환타입 필요없음
	//생성자 오버로딩 해서 2가지값, 4가지값 가져올 수 있는 생성자를 만들 수 있다.
	public memberVO(String email, String tel, String address) {
		this.email=email;
		this.tel=tel;
		this.address=address;
	}
	
	//getter
	public String getEmail() {
		return email;
	}
	public String getPw() {
		return pw;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	//setter는 쓸 일이 별로 없다. 데이터베이스에서 update를 주로 사용한다.

	public String getId() {
		return id;
	}


	
}
