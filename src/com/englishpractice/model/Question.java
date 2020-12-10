package com.englishpractice.model;

enum Level {
	EASY,
	MEDIUM,
	HARD
}

enum Category {
	Noun,
	Adjective,
	Verb,
	Adverb
}

public abstract class Question {
	private String content;
	private Level level;
	
	public Question() {
	}

	public Question(String content, Level level) {
		this.content = content;
		this.level = level;
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
	
	@Override
	public String toString() {
		return String.format("%s\n", this.content);
	}
}
