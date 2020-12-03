package com.englishpractice.entity;

public class Option {
	private int optionId, questionId;
	private String content;

	public Option() {
	}

	public Option(String content) {
		this.content = content;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return content;
	}

}
