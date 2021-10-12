package com.model;

public class CourseVO {
	// 필드생성
	private int member_no_co;	// 회원번호
	private int lecture_no_co;	// 인강순번
	private String course_sd; // 수강시작일자
	private String course_comp; // 수료여부
	private int course_no;	// 수강번호
	
	// 생성자
	public CourseVO(int member_no_co, int lecture_no_co, String course_sd, String course_comp, int course_no) {
		super();
		this.member_no_co = member_no_co;
		this.lecture_no_co = lecture_no_co;
		this.course_sd = course_sd;
		this.course_comp = course_comp;
		this.course_no = course_no;
	}
	
	// 메소드(get,set)
	public int getMember_no_co() {
		return member_no_co;
	}

	public void setMember_no_co(int member_no_co) {
		this.member_no_co = member_no_co;
	}

	public int getLecture_no_co() {
		return lecture_no_co;
	}

	public void setLecture_no_co(int lecture_no_co) {
		this.lecture_no_co = lecture_no_co;
	}

	public String getCourse_sd() {
		return course_sd;
	}

	public void setCourse_sd(String course_sd) {
		this.course_sd = course_sd;
	}

	public String getCourse_comp() {
		return course_comp;
	}

	public void setCourse_comp(String course_comp) {
		this.course_comp = course_comp;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
}
