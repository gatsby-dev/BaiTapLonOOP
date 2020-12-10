package com.englishpractice.model;

import java.util.ArrayList;
import java.util.List;

public class IncompleteQuestion extends Question{
	private List<MultipleChoiceQuestion> questions = new ArrayList<>();

	public IncompleteQuestion(String content, Level level) {
		super(content, level);
	}
	
	public List<MultipleChoiceQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MultipleChoiceQuestion> questions) {
		this.questions = questions;
	}

	public void addQuestion(MultipleChoiceQuestion question) {
		this.questions.add(question);
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		for (MultipleChoiceQuestion question : questions) {
			s += question;
		}
		return s;
	}
}
