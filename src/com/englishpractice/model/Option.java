package com.englishpractice.model;

public class Option {
	private String content;
	private boolean correct;

	public Option() {
	}

	public Option(String content, boolean correct) {
		this.content = content;
		this.correct = correct;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return content;
	}

}
