package com.englishpractice.controller;

import java.util.ArrayList;
import java.util.List;

import com.englishpractice.model.ConversationQuestion;
import com.englishpractice.model.IncompleteQuestion;
import com.englishpractice.model.MultipleChoiceQuestion;
import com.englishpractice.model.Question;

public class QuestionController {
	private List<Question> questionsList = new ArrayList<>();

	public void addQuestion(Question question) {
		this.questionsList.add(question);
	}
	
	public List<Question> getMultipleChoiceQuestion() {
		List<Question> multipleChoiceQuestions = new ArrayList<>();
		for (Question q: questionsList) {
			if (q instanceof MultipleChoiceQuestion) {
				multipleChoiceQuestions.add(q);
			}
		}
		return multipleChoiceQuestions;
	}
	
	public List<Question> getIncompleteQuestion() {
		List<Question> incompleteQuestions = new ArrayList<>();
		for (Question q: questionsList) {
			if (q instanceof IncompleteQuestion) {
				incompleteQuestions.add(q);
			}
		}
		return incompleteQuestions;
	}
	
	public List<Question> getConversationQuestion() {
		List<Question> conversationQuestions = new ArrayList<>();
		for (Question q: questionsList) {
			if (q instanceof ConversationQuestion) {
				conversationQuestions.add(q);
			}
		}
		return conversationQuestions;
	}
	
	public void Practice(int numberOfQuestion) {
		
	}
}
