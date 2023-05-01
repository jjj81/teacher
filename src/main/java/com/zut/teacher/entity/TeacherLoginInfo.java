package com.zut.teacher.entity;

public class TeacherLoginInfo {
	private String teacherId;
	private String passWord;
	private String teacherName;
	private String powerToClass;

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

	public String getPowerToClass() {
		return powerToClass;
	}

	public void setPowerToClass(String powerToClass) {
		this.powerToClass = powerToClass;
	}

}
