package com.zut.teacher.entity;

public class TeacherLoginInfo {
	private String teacherId;
	private String passWord;
	private String teacherName;
	private String wantToManageClass;
	private String adminMessage;
	private String college;
	private String faculty;

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getWantToManageClass() {
		return wantToManageClass;
	}

	public void setWantToManageClass(String wantToManageClass) {
		this.wantToManageClass = wantToManageClass;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getAdminMessage() {
		return adminMessage;
	}

	public void setAdminMessage(String adminMessage) {
		this.adminMessage = adminMessage;
	}

}
