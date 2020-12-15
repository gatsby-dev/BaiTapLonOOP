package com.englishpractice.model;

import java.util.List;

public abstract class HeadQuestion {
	private int Id;
	private String paragraph;
	private List<Question> subQuestions;
	
	public HeadQuestion() {}
	
	public HeadQuestion(int Id, String paragraph) {
		this.Id = Id;
		this.paragraph = paragraph;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getParagraph() {
		return paragraph;
	}
	
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	
	public List<Question> getSubQuestions() {
		return subQuestions;
	}

	public void setSubQuestions(List<Question> subQuestions) {
		this.subQuestions = subQuestions;
	}

	@Override
	public String toString() {
		String headQuestion = this.paragraph;
		for (Question question :subQuestions) {
			headQuestion += question;
		}
		return headQuestion;
	}
	
}
