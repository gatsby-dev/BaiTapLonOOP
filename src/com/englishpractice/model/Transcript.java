package com.englishpractice.model;

import java.util.Date;

public class Transcript {
	private double score;
	private Date testDate;
	
	public Transcript(double score, Date testDate) {
		this.score = score;
		this.testDate = testDate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	@Override
	public String toString() {
		return String.format("\n| Ngày làm bài: %s - Điểm: %.2f |\n", this.testDate, this.score);
	}
	
}
