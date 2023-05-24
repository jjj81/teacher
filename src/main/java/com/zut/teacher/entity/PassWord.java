package com.zut.teacher.entity;

public class PassWord {
	private String originalPassWord;
	private String newPassWord;
	private String confirmNew;

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getConfirmNew() {
		return confirmNew;
	}

	public void setConfirmNew(String confirmNew) {
		this.confirmNew = confirmNew;
	}

	public String getOriginalPassWord() {
		return originalPassWord;
	}

	public void setOriginalPassWord(String originalPassWord) {
		this.originalPassWord = originalPassWord;
	}

}
