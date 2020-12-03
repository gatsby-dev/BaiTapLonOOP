package com.englishpractice.controller;

import java.util.ArrayList;
import java.util.List;

import com.englishpractice.entity.Question;

public class QuestionController {
	private List<Question> questionsList = new ArrayList<>();

	public List<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}
	
	
}
