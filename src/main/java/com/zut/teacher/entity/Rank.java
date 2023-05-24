package com.zut.teacher.entity;

public class Rank {

	private String studentId;
	private String studentName;
	private Float compositeScore;

	private String college;
	private String faculty;
	private String clazz;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Float getCompositeScore() {
		return compositeScore;
	}

	public void setCompositeScore(Float compositeScore) {
		this.compositeScore = compositeScore;
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

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
