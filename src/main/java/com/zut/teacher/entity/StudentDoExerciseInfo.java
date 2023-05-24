package com.zut.teacher.entity;

import java.sql.Date;

public class StudentDoExerciseInfo {
	private String StudentId;
	private String doExerciseWebSiteUrl;
	private String doExerciseWebSiteAccount;
	private Integer solveExerciseNumber;
	private Date doExerciseStartTime;
	private Date doExerciseEndTime;
	private String doExercisePhoto1;
	private String doExercisePhoto2;
	private String doExercisePhoto3;
	private String doExercisePhoto4;
	private String doExercisePhoto5;
	private String review;
	private String teacherComment;
	private String studentComment;

	public String getDoExerciseWebSiteUrl() {
		return doExerciseWebSiteUrl;
	}

	public void setDoExerciseWebSiteUrl(String doExerciseWebSiteUrl) {
		this.doExerciseWebSiteUrl = doExerciseWebSiteUrl;
	}

	public String getDoExerciseWebSiteAccount() {
		return doExerciseWebSiteAccount;
	}

	public void setDoExerciseWebSiteAccount(String doExerciseWebSiteAccount) {
		this.doExerciseWebSiteAccount = doExerciseWebSiteAccount;
	}

	public Integer getSolveExerciseNumber() {
		return solveExerciseNumber;
	}

	public void setSolveExerciseNumber(Integer solveExerciseNumber) {
		this.solveExerciseNumber = solveExerciseNumber;
	}

	public Date getDoExerciseStartTime() {
		return doExerciseStartTime;
	}

	public void setDoExerciseStartTime(Date doExerciseStartTime) {
		this.doExerciseStartTime = doExerciseStartTime;
	}

	public Date getDoExerciseEndTime() {
		return doExerciseEndTime;
	}

	public void setDoExerciseEndTime(Date doExerciseEndTime) {
		this.doExerciseEndTime = doExerciseEndTime;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public String getStudentId() {
		return StudentId;
	}

	public String getDoExercisePhoto1() {
		return doExercisePhoto1;
	}

	public void setDoExercisePhoto1(String doExercisePhoto1) {
		this.doExercisePhoto1 = doExercisePhoto1;
	}

	public String getDoExercisePhoto2() {
		return doExercisePhoto2;
	}

	public void setDoExercisePhoto2(String doExercisePhoto2) {
		this.doExercisePhoto2 = doExercisePhoto2;
	}

	public String getDoExercisePhoto3() {
		return doExercisePhoto3;
	}

	public void setDoExercisePhoto3(String doExercisePhoto3) {
		this.doExercisePhoto3 = doExercisePhoto3;
	}

	public String getDoExercisePhoto4() {
		return doExercisePhoto4;
	}

	public void setDoExercisePhoto4(String doExercisePhoto4) {
		this.doExercisePhoto4 = doExercisePhoto4;
	}

	public String getDoExercisePhoto5() {
		return doExercisePhoto5;
	}

	public void setDoExercisePhoto5(String doExercisePhoto5) {
		this.doExercisePhoto5 = doExercisePhoto5;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getTeacherComment() {
		return teacherComment;
	}

	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}

	public String getStudentComment() {
		return studentComment;
	}

	public void setStudentComment(String studentComment) {
		this.studentComment = studentComment;
	}

}
