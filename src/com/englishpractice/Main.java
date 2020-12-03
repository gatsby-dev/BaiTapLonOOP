package com.englishpractice;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.englishpractice.controller.CandidateController;
import com.englishpractice.entity.Candidate;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		CandidateController candidateController = new CandidateController();
		int userSelection, subchoice = 0;
		do {
			userSelection = publicMenu(scanner);
			switch (userSelection) {
			case 1:
				do {
					subchoice = loginMenu(scanner, candidateController);
				} while(subchoice != 0);
				break;
			case 2:
				break;
			}
		} while (userSelection != 0);
		scanner.close();
	}

	public static int publicMenu(Scanner scanner) {
		int selection;
		do {
			System.out.print("\n====== WELCOME TO ENGLISH PRACTICE ======\n1. Đăng nhập\n"
					+ "2. Đăng ký tài khoản mới\n" + "0. Thoát\n" + "Nhập lựa chọn: ");
			selection = scanner.nextInt();
			if (selection < 0 || selection > 2) {
				System.out.println("Mời nhập lại.");
			}
		} while (selection < 0 || selection > 2);
		return selection;
	}
	
	public static int loginMenu(Scanner scanner, CandidateController candidateController) throws SQLException {
		String username, password;
		System.out.print("\nNhập tài khoản: ");
		username = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Nhập mật khẩu: ");
		password = scanner.nextLine();
		for (Candidate candidate : candidateController.getAllCandidates()) {
			if(candidate.getUsername().equals(username) && candidate.getPassword().equals(password)) {
				return 1;
			}
		}
		return 0;
	}

	public static int userMenu(Scanner scanner) {
		int selection;
		do {
			System.out.print("\n1. Làm trắc nghiệm\n2. Xem thông tin cá nhân\n0. Đăng xuất\nNhập lựa chọn: ");
			selection = scanner.nextInt();
			if (selection < 0 || selection > 2) {
				System.out.println("Mời nhập lại.");
			}
		} while (selection < 0 || selection > 2);
		return selection;
	}

	// ĐĂNG KÍ
	public static void registerMenu(Scanner scanner, List<Candidate> candidates) throws ParseException, SQLException {
		CandidateController candidateController = new CandidateController();
		String username, password, fullName, country;
		Date dateOfBirth;
		int gender;
		do {
			System.out.print("\nNhập tài khoản mới: ");
			username = scanner.nextLine();
			if(!checkValidAccount(username, candidates)) {
				System.out.println("Tên tài khoản đã tồn tại, vui lòng nhập tên tài khoản mới.");
			}
		} while(!checkValidAccount(username, candidates));
		System.out.print("Nhập mật khẩu: ");
		password = scanner.nextLine();
		System.out.print("Họ và tên: ");
		fullName = scanner.nextLine();
		do {
			System.out.print("Chọn giới tính - (1: nam - 0: nữ): ");
			gender = scanner.nextInt();
			if(gender != 0 || gender!= 1) {
				System.out.println("Giới tính không hợp lệ, mời chọn lại.");
			}
		} while (gender != 0 || gender!= 1);
		System.out.print("Nhập ngày sinh: ");
		dateOfBirth = new SimpleDateFormat().parse(scanner.nextLine());
		java.sql.Date sqlDOB = new java.sql.Date(dateOfBirth.getTime());
		System.out.print("Quê quán: ");
		country = scanner.nextLine();
		Date joinDate = new Date();
		java.sql.Date sqlJoinDate = new java.sql.Date(joinDate.getTime());
		// Xử lí SQL
		candidateController.addCandidate(username, password, fullName, sqlDOB, gender, country, sqlJoinDate);
	}
	
	// Kiểm tra tài khoản hợp lệ
	public static boolean checkValidAccount(String username, List<Candidate> candidates) {
		for (Candidate candidate : candidates) {
			if (candidate.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

}
