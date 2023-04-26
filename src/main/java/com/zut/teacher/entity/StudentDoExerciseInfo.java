package com.zut.teacher.entity;

import java.sql.Date;

public class StudentDoExerciseInfo {
	private String StudentId;
	private String doExerciseWebSiteUrl;
	private String doExerciseWebSiteAccount;
	private Integer solveExerciseNumber;
	private Date doExerciseStartTime;
	private Date doExerciseEndTime;
	private byte[] doExercisePhoto1;
	private byte[] doExercisePhoto2;
	private byte[] doExercisePhoto3;

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

	public byte[] getDoExercisePhoto1() {
		return doExercisePhoto1;
	}

	public void setDoExercisePhoto1(byte[] doExercisePhoto1) {
		this.doExercisePhoto1 = doExercisePhoto1;
	}

	public byte[] getDoExercisePhoto2() {
		return doExercisePhoto2;
	}

	public void setDoExercisePhoto2(byte[] doExercisePhoto2) {
		this.doExercisePhoto2 = doExercisePhoto2;
	}

	public byte[] getDoExercisePhoto3() {
		return doExercisePhoto3;
	}

	public void setDoExercisePhoto3(byte[] doExercisePhoto3) {
		this.doExercisePhoto3 = doExercisePhoto3;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

}
