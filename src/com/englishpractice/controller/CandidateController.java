package com.englishpractice.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// import java.util.UUID;

import com.englishpractice.entity.Candidate;
import com.englishpractice.utils.ConnectionUtils;

public class CandidateController {
	
	private static List<Candidate> candidates = new ArrayList<>();
//	Scanner sc = new Scanner(System.in);
	
	public void addCandidate(String username, String password, String fullName, Date dateOfBirth, int gender, String country, Date joinDate) throws SQLException {
        System.out.println("Register new account.");
        String sql = "INSERT INTO Candidates (Username, Password, FullName, DateOfBirth, Gender, Country, JoinDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = ConnectionUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        // String userId = UUID.randomUUID().toString();
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, fullName);
        stmt.setDate(4, dateOfBirth);
        stmt.setInt(5, gender);
        stmt.setString(6, country);
        stmt.setDate(7, joinDate);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
        	System.out.println("Đăng kí tài khoản thành công!");
        }
    }
	
	public void deleteCandidate(int ID) throws SQLException {
		Connection conn = ConnectionUtils.getConnection(); 
		String sql = "DELETE FROM EnglishPractice.Candidates WHERE ID=?";
		PreparedStatement preStmt = conn.prepareStatement(sql);
		preStmt.setInt(1, ID);
		preStmt.executeUpdate();
	}

    public List<Candidate> getAllCandidates() throws SQLException {
        Connection conn = ConnectionUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM Candidates";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Candidate candidate = new Candidate(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"), rs.getString("FullName"), rs.getString("Country"), rs.getString("Gender"), rs.getDate("DateOfBirth"), rs.getDate("JoinDate"));
            candidates.add(candidate);
        }
        System.out.println(candidates);
        return candidates;
    }
    
    public boolean isLogin(String username, String password) {
    	for (Candidate candidate : candidates) {
			if (candidate.getUsername().equals(username) && candidate.getPassword().equals(password)) {
				return true;
			}
		}
    	return false;
    }
}
