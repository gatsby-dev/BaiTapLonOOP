package com.englishpractice.model;

import java.util.Date;
import java.util.List;

public class Candidate {
	private static int count = 1;
    private int Id = count++;
    private String username, password, fullName, country, gender;
    private Date dateOfBirth, joinDate;
    private List<Transcript> transcript;
    
	public Candidate() {}

	public Candidate(int Id, String username, String password, String fullName, String country, String gender,
			Date dateOfBirth, Date joinDate) {
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.country = country;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.joinDate = joinDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender == 1 ? "Nam" : "Nữ";
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
    
	public List<Transcript> getTranscript() {
		return transcript;
	}

	public void setTranscript(List<Transcript> transcript) {
		this.transcript = transcript;
	}

	@Override
	public String toString() {
		return String.format("\n=========================================\nAcountID: %d\nTên tài khoản: %s\nHọ tên: %s\nQuê quán: %s\nNgày sinh: %s\nGiới tính: %s\nNgày đăng kí: %s\n", Id, username, fullName, country, dateOfBirth, gender, joinDate);
	}
    
}
