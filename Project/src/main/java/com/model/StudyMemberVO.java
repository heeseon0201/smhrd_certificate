package com.model;

public class StudyMemberVO {
	// 필드생성
	private String SM_id;	// 스터디 ID
	private int study_no_sm;	// 스터디 순번
	private int member_no_sm;	// 회원번호
	private String SM_title;	// 스터디제목
	private String SM_sd;	// 시작일자
	private String SM_ed;	// 종료일자
	private String SM_notice;	// 공지내용
	private String SM_onoff;	// 온/오프라인 구분
	private String SM_region;	// 스터디 지역

	// 생성자
	public StudyMemberVO(String sM_id, int study_no_sm, int member_no_sm, String sM_title, String sM_sd, String sM_ed,
			String sM_notice, String sM_onoff, String sM_region) {
		super();
		SM_id = sM_id;
		this.study_no_sm = study_no_sm;
		this.member_no_sm = member_no_sm;
		SM_title = sM_title;
		SM_sd = sM_sd;
		SM_ed = sM_ed;
		SM_notice = sM_notice;
		SM_onoff = sM_onoff;
		SM_region = sM_region;
	}
	
	// 메소드(get,set)
	public String getSM_id() {
		return SM_id;
	}

	public void setSM_id(String sM_id) {
		SM_id = sM_id;
	}

	public int getStudy_no_sm() {
		return study_no_sm;
	}

	public void setStudy_no_sm(int study_no_sm) {
		this.study_no_sm = study_no_sm;
	}

	public int getMember_no_sm() {
		return member_no_sm;
	}

	public void setMember_no_sm(int member_no_sm) {
		this.member_no_sm = member_no_sm;
	}

	public String getSM_title() {
		return SM_title;
	}

	public void setSM_title(String sM_title) {
		SM_title = sM_title;
	}

	public String getSM_sd() {
		return SM_sd;
	}

	public void setSM_sd(String sM_sd) {
		SM_sd = sM_sd;
	}

	public String getSM_ed() {
		return SM_ed;
	}

	public void setSM_ed(String sM_ed) {
		SM_ed = sM_ed;
	}

	public String getSM_notice() {
		return SM_notice;
	}

	public void setSM_notice(String sM_notice) {
		SM_notice = sM_notice;
	}

	public String getSM_onoff() {
		return SM_onoff;
	}

	public void setSM_onoff(String sM_onoff) {
		SM_onoff = sM_onoff;
	}

	public String getSM_region() {
		return SM_region;
	}

	public void setSM_region(String sM_region) {
		SM_region = sM_region;
	}
}
