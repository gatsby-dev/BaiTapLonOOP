package com.englishpractice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.englishpractice.model.ConversationQuestion;
import com.englishpractice.model.HeadQuestion;
import com.englishpractice.model.IncompleteQuestion;
import com.englishpractice.model.Question;

public class HeadQuestionController {
	private List<HeadQuestion> headQuestionsList = new ArrayList<>();

	public List<HeadQuestion> getHeadQuestionsList() {
		return headQuestionsList;
	}

	public void setHeadQuestionsList(List<HeadQuestion> headQuestionsList) {
		this.headQuestionsList = headQuestionsList;
	}
	
	public List<HeadQuestion> getIncompleteQuestions() {
		List<HeadQuestion> incompleteQuestions = new ArrayList<>();
		for (HeadQuestion hq: headQuestionsList) {
			if (hq instanceof IncompleteQuestion) {
				incompleteQuestions.add(hq);
			}
		}
		return incompleteQuestions;
	}
	
	public List<HeadQuestion> getConversationQuestions() {
		List<HeadQuestion> conversationQuestions = new ArrayList<>();
		for (HeadQuestion hq: headQuestionsList) {
			if (hq instanceof ConversationQuestion) {
				conversationQuestions.add(hq);
			}
		}
		return conversationQuestions;
	}
	
	public List<HeadQuestion> getQuestionByClassName(String className) throws ClassNotFoundException {
		final String dirpath = "com.englishpractice.model.";
		Class<?> c = Class.forName(dirpath + className);
		List<HeadQuestion> headQuestions = new ArrayList<>();
		for (HeadQuestion hq : headQuestionsList) {
			if(c.isInstance(hq)) {
				headQuestions.add(hq);
			}
		}
		return headQuestions;
	}
	
	public void PracticeIncompleteQuestion(Scanner scanner) throws ClassNotFoundException {
		List<HeadQuestion> questions = getQuestionByClassName("IncompleteQuestion");
		Collections.shuffle(questions);
		if (questions.size() > 0) {
			int score = 0;
			IncompleteQuestion incomQues = (IncompleteQuestion) questions.get(0);
			System.out.println(incomQues);
			for(Question q: incomQues.getSubQuestions()) {
				System.out.printf("Trả lời cho câu %s\n", q.getContent());
				String ans = scanner.next();
				if(q.checkAnswer(ans)) {
					System.out.println("Correct!!!");
					score++;
				} else {
					System.out.println("Incorrect!!!");
				}
			}
			System.out.printf("Điểm của bạn: %d\n", score);
		}
	}
	
	public void PracticeConversationQuestion(Scanner scanner) throws ClassNotFoundException {
		List<HeadQuestion> questions = getQuestionByClassName("ConversationQuestion");
		Collections.shuffle(questions);
		if (questions.size() > 0) {
			int score = 0;
			ConversationQuestion converQues = (ConversationQuestion) questions.get(0);
			System.out.println(converQues);
			for(Question q: converQues.getSubQuestions()) {
				System.out.printf("Trả lời cho câu %s\n", q.getContent());
				String ans = scanner.next();
				if(q.checkAnswer(ans)) {
					System.out.println("Correct!!!");
					score++;
				} else {
					System.out.println("Incorrect!!!");
				}
			}
			System.out.printf("Điểm của bạn: %d\n", score);
		}
	}
}
