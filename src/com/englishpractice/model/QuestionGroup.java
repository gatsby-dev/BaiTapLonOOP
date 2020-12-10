package com.englishpractice.model;

import java.util.List;

public abstract class QuestionGroup {
	private int questionGroupId;
	private String paragraph;
	private List<Question> questions;
	
	public QuestionGroup() {}
	
	public QuestionGroup(int questionGroupId, String paragraph) {
		this.questionGroupId = questionGroupId;
		this.paragraph = paragraph;
	}
	
	public int getQuestionGroupId() {
		return questionGroupId;
	}

	public void setQuestionGroupId(int questionGroupId) {
		this.questionGroupId = questionGroupId;
	}

	public String getParagraph() {
		return paragraph;
	}
	
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
