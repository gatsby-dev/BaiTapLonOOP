package com.englishpractice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
	private static final String[] CHOICES = {"A", "B", "C", "D"}; 
	private List<Option> options = new ArrayList<>();

	public MultipleChoiceQuestion(String content, Level level) {
		super(content, level);
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public void addOption(Option option) {
		if (this.options.size() < CHOICES.length) {
			this.options.add(option);
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
		String s = super.toString();
		for (int i = 0; i < this.options.size(); i++) {
			s.concat(String.format("%s. %s\n", CHOICES[i], this.options.get(i)));
		}
		return s;
	}
}
