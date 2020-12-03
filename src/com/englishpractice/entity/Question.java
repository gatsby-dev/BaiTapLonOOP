package com.englishpractice.entity;

import java.util.List;

enum Level {
	Easy,
	Medium,
	Hard
}

enum Category {
	Noun,
	Adjective,
	Verb,
	Adverb
}

public class Question {
	private String content;
	private Level level;
	private List<Option> options;
	private Option correctAnswer;
	
	public Question() {
	}

	public Question(String content, List<Option> options, Option correctAnswer) {
		this.content = content;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(Option correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public String toString() {
		return String.format("%s\n%s", content, options);
	}
}
