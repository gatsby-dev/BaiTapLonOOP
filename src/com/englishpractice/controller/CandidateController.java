package com.englishpractice.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.englishpractice.model.Candidate;
import com.englishpractice.utils.ConnectionUtils;

public class CandidateController {
	
	private List<Candidate> candidatesList = new ArrayList<>();

	public CandidateController() throws SQLException {
		Connection conn = ConnectionUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM Candidates";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Candidate candidate = new Candidate(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"), rs.getString("FullName"), rs.getString("Country"), rs.getString("Gender"), rs.getDate("DateOfBirth"), rs.getDate("JoinDate"));
            candidatesList.add(candidate);
        }
        System.out.println(candidatesList);
	}

	public List<Candidate> getCandidatesList() {
		return candidatesList;
	}

	public void setCandidates(List<Candidate> candidatesList) {
		this.candidatesList = candidatesList;
	}
	
	public List<Candidate> getAllCandidates() throws SQLException {
		Connection conn = ConnectionUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM Candidates";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Candidate candidate = new Candidate(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"), rs.getString("FullName"), rs.getString("Country"), rs.getString("Gender"), rs.getDate("DateOfBirth"), rs.getDate("JoinDate"));
            candidatesList.add(candidate);
        }
        return candidatesList;
    }

	public void addCandidate(Candidate candidate) throws SQLException {
		candidatesList.add(candidate);
        String sql = "INSERT INTO Candidates (ID, Username, Password, FullName, DateOfBirth, Gender, Country, JoinDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, candidate.getId());
        stmt.setString(2, candidate.getUsername());
        stmt.setString(3, candidate.getPassword());
        stmt.setString(4, candidate.getFullName());
        stmt.setDate(5, new Date(candidate.getDateOfBirth().getTime()));
        stmt.setString(6, candidate.getGender());
        stmt.setString(7, candidate.getCountry());
        stmt.setDate(8, new Date(candidate.getJoinDate().getTime()));
        stmt.executeUpdate();
        
    }
	
	public void deleteCandidate(Candidate loggingAccount) throws SQLException {
		Connection conn = ConnectionUtils.getConnection(); 
		String sql = "DELETE FROM Candidates WHERE ID=?";
		PreparedStatement prStmt = conn.prepareStatement(sql);
		prStmt.setInt(1, loggingAccount.getId());
		prStmt.executeUpdate();
	}
	
	public void updateCandidate(Candidate loggingAccount) throws SQLException {
		Connection conn = ConnectionUtils.getConnection();
		String sql = "UPDATE Candidates SET FullName=?, DateOfBirth=?, Gender=?, Country=?";
		PreparedStatement prStmt = conn.prepareStatement(sql);
		prStmt.setString(1, loggingAccount.getFullName());
		prStmt.setDate(2, new Date(loggingAccount.getDateOfBirth().getTime()));
		prStmt.setString(3, loggingAccount.getGender());
		prStmt.setString(4, loggingAccount.getCountry());
		prStmt.executeUpdate();
		System.out.println("");
	}
}
