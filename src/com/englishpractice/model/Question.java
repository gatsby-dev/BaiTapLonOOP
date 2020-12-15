package com.englishpractice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Category {
	NOUN,
	ADJECTIVE,
	VERB,
	ADVERB
}

public class Question {
	private static final String[] CHOICES = {"A", "B", "C", "D"};
	private static int count = 0;
	private int Id = ++count;
	private String content;
	private Level level;
	private List<Option> options = new ArrayList<>();
	
	public Question() {
	}

	public Question(String content, Level level) {
		this.content = content;
		this.level = level;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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

	public void setLevel(int level) {
		if(level == 1) {
			this.level = Level.EASY;
		} else if(level == 2) {
			this.level = Level.MEDIUM;
		} else {
			this.level = Level.HARD;
		}
	}
	
	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public void addOption(Option option) {
		if (options.size() < CHOICES.length) {
			options.add(option);
		}
	}
	
	public void shuffleOptions() {
		Collections.shuffle(options);
	}
	
	public boolean checkAnswer(String answer) {
		for (int i = 0; i < this.options.size(); i++) {
			if (this.options.get(i).isCorrect() && CHOICES[i].equals(answer.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String question = this.content;
		for (int i = 0; i < this.options.size(); i++) {
			question += String.format("\n%s. %s", CHOICES[i], this.options.get(i));
		}
		return question;
	}
}
