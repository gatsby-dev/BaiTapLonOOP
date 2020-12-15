package com.englishpractice.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.englishpractice.model.Question;
import com.englishpractice.utils.ConnectionUtils;

public class QuestionController {
	private List<Question> questionsList = new ArrayList<>();

	public List<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}

	public void addQuestion(Question question) throws SQLException {
		this.questionsList.add(question);
		String sql = "INSERT INTO Questions(ID, Content, Level) VALUES (?, ?, ?)";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement prStmt = conn.prepareStatement(sql);
		prStmt.setInt(1, question.getId());
		prStmt.setString(2, question.getContent());
		prStmt.setString(3, question.getLevel().toString());
		prStmt.executeUpdate();
	}
	
	public void Practice(Scanner scanner) {
		List <Question> multipleChoiceQuestions = getQuestionsList();
		Collections.shuffle(multipleChoiceQuestions);
		int n = questionsList.size() < 10 ? questionsList.size() : 10;
		int score = 0;
		for (int i = 0; i < n; i++) {
			Question q = multipleChoiceQuestions.get(i);
			System.out.println(q);
			System.out.print("Trả lời: ");
			String ans = scanner.next();
			if (q.checkAnswer(ans)) {
				System.out.println("Correct!!!");
				score++;
			} else {
				System.out.println("Incorrect!!!");
			}
		}
		System.out.printf("Điểm của bạn: %d\n", score);
	}
}
