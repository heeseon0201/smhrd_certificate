package com.model;

public class LectureVO {
	// 필드생성
	private int lecture_no;	// 순번
	private String lecture_name;	// 강의명
	private String lecture_teach; // 강사명
	private String lecture_count;	// 총 강의수
	private int lecture_price;		// 가격
	private double lecture_point;		// 평점
	private String lecture_review;	// 후기
	private String lecture_url;		// URL
	private String lecture_cat;		// 카테고리
	
	
	// 생성자
	public LectureVO(int lecture_no, String lecture_name, String lecture_teach, String lecture_count,
			int lecture_price, double lecture_point, String lecture_review, String lecture_url, String lecture_cat) {
		super();
		this.lecture_no = lecture_no;
		this.lecture_name = lecture_name;
		this.lecture_teach = lecture_teach;
		this.lecture_count = lecture_count;
		this.lecture_price = lecture_price;
		this.lecture_point = lecture_point;
		this.lecture_review = lecture_review;
		this.lecture_url = lecture_url;
		this.lecture_cat = lecture_cat;
	}
	
	public LectureVO(String lecture_name, String lecture_teach, double lecture_point, String lecture_cat) {
		super();
		this.lecture_name = lecture_name;
		this.lecture_teach = lecture_teach;
		this.lecture_point = lecture_point;
		this.lecture_cat = lecture_cat;
	}
	
	public LectureVO(String lecture_name, String lecture_teach,
			int lecture_price, double lecture_point, String lecture_cat) {
		super();
		this.lecture_name = lecture_name;
		this.lecture_teach = lecture_teach;
		this.lecture_price = lecture_price;
		this.lecture_point = lecture_point;
		this.lecture_cat = lecture_cat;
	}

	// 메소드(get,set)
	public int getLecture_no() {
		return lecture_no;
	}

	public void setLecture_no(int lecture_no) {
		this.lecture_no = lecture_no;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public String getLecture_teach() {
		return lecture_teach;
	}

	public void setLecture_teach(String lecture_teach) {
		this.lecture_teach = lecture_teach;
	}

	public String getLecture_count() {
		return lecture_count;
	}

	public void setLecture_count(String lecture_count) {
		this.lecture_count = lecture_count;
	}

	public int getLecture_price() {
		return lecture_price;
	}

	public void setLecture_price(int lecture_price) {
		this.lecture_price = lecture_price;
	}

	public double getLecture_point() {
		return lecture_point;
	}

	public void setLecture_point(int lecture_point) {
		this.lecture_point = lecture_point;
	}

	public String getLecture_review() {
		return lecture_review;
	}

	public void setLecture_review(String lecture_review) {
		this.lecture_review = lecture_review;
	}

	public String getLecture_url() {
		return lecture_url;
	}

	public void setLecture_url(String lecture_url) {
		this.lecture_url = lecture_url;
	}

	public String getLecture_cat() {
		return lecture_cat;
	}

	public void setLecture_cat(String lecture_cat) {
		this.lecture_cat = lecture_cat;
	}
}
