package com.englishpractice;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.englishpractice.controller.CandidateController;
import com.englishpractice.model.Candidate;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner scanner = new Scanner(System.in);
		CandidateController candidateController = new CandidateController();
		int userSelection;
		do {
			userSelection = PublicMenu(scanner);
			switch (userSelection) {
			case 1:
				Candidate loggingAccount = null;
				int subchoice = 0;
				do {
					loggingAccount = SignInMenu(scanner, candidateController);
					if (loggingAccount == null) {
						System.out.println("Sai tài khoản hoặc mật khẩu. Mời đăng nhập lại");
					}
				} while (loggingAccount == null);
				System.out.println("Tài khoản: " + loggingAccount.getUsername());
				do {
					subchoice = PrivateMenu(scanner);
					switch (subchoice) {
					case 1:
						int questionType = QuestionTypeMenu(scanner);
						break;
					case 2:
						System.out.println(loggingAccount);
						break;
					case 3:
						UpdateAccountMenu(scanner, loggingAccount, candidateController);
						break;
					case 4:
						DeleteAccountMenu(scanner, loggingAccount, candidateController);
						loggingAccount = null;
						break;
					case 0:
						loggingAccount = null;
						break;
					}
				} while (loggingAccount != null);
				break;
			case 2:
				SignUpMenu(scanner, candidateController);
				break;
			}
		} while (userSelection != 0);
		scanner.close();
	}

	public static int PublicMenu(Scanner scanner) {
		int selection;
		do {
			System.out.print("\n====== WELCOME TO ENGLISH PRACTICE ======\n1. Đăng nhập\n"
					+ "2. Đăng ký tài khoản mới\n0. Thoát\nNhập lựa chọn: ");
			selection = scanner.nextInt();
			if (selection < 0 || selection > 2) {
				System.out.println("Mời nhập lại.");
			}
		} while (selection < 0 || selection > 2);
		return selection;
	}

	
	// Đăng nhập
	public static Candidate SignInMenu(Scanner scanner, CandidateController candidateController) throws SQLException {
		String username, password;
		System.out.println("\n=========================================");
		scanner.nextLine();
		System.out.print("Nhập tài khoản: ");
		username = scanner.nextLine();
		System.out.print("Nhập mật khẩu: ");
		password = scanner.nextLine();
		for (Candidate candidate : candidateController.getCandidatesList()) {
			if (candidate.getUsername().equals(username) && candidate.getPassword().equals(password)) {
				return candidate;
			}
		}
		return null;
	}

	
	// Đăng kí
	public static void SignUpMenu(Scanner scanner, CandidateController candidateController)
			throws ParseException, SQLException {
		Candidate newAccount = new Candidate();
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		boolean validAccount;
		scanner.nextLine();
		do {
			
			System.out.println("\n=========================================");
			System.out.print("Nhập tài khoản đăng kí: ");
			newAccount.setUsername(scanner.nextLine());
			validAccount = checkValidAccount(newAccount.getUsername(), candidateController);
			if (!validAccount) {
				System.out.println("Tên tài khoản đã tồn tại, vui lòng nhập tên tài khoản mới.");
			}
		} while (!validAccount);
		System.out.print("Nhập mật khẩu: ");
		newAccount.setPassword(scanner.nextLine());
		System.out.print("Họ và tên: ");
		newAccount.setFullName(scanner.nextLine());
		int gender;
		do {
			System.out.print("Chọn giới tính - (1: Nam - 0: Nữ): ");
			gender = scanner.nextInt();
			if (gender != 0 && gender != 1) {
				System.out.println("Giới tính không hợp lệ, mời chọn lại.");
			}
			newAccount.setGender(gender);
			System.out.println(newAccount.getGender());
		} while (gender != 0 && gender != 1);
		scanner.nextLine();
		System.out.print("Nhập ngày sinh: ");
		newAccount.setDateOfBirth(dateFormatter.parse(scanner.nextLine()));
		System.out.print("Quê quán: ");
		newAccount.setCountry(scanner.nextLine());
		newAccount.setJoinDate(dateFormatter.parse(dateFormatter.format(new Date())));
		candidateController.addCandidate(newAccount);
		System.out.println("Đăng kí tài khoản thành công!");
	}

	
	// Kiểm tra tài khoản hợp lệ
	public static boolean checkValidAccount(String username, CandidateController candidateController)
			throws SQLException {
		for (Candidate candidate : candidateController.getAllCandidates()) {
			if (candidate.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

	
	// Menu sau khi đăng nhập thành công
	public static int PrivateMenu(Scanner scanner) {
		int selection;
		do {
			System.out.println("=========================================");
			System.out.print(
					"1. Làm trắc nghiệm\n2. Xem thông tin tài khoản\n3. Sửa thông tin tài khoản\n4. Xoá tài khoản\n0. Đăng xuất\nNhập lựa chọn: ");
			selection = scanner.nextInt();
			if (selection < 0 || selection > 4) {
				System.out.println("Mời nhập lại.");
			}
		} while (selection < 0 || selection > 4);
		return selection;
	}
	
	
	// Cập nhật tài khoản
	public static void UpdateAccountMenu(Scanner scanner, Candidate loggingAccount, CandidateController candidateController) throws ParseException, SQLException {
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		scanner.nextLine();
		System.out.println("=========================================");
		System.out.print("Nhập họ và tên: ");
		loggingAccount.setFullName(scanner.nextLine());
		System.out.print("Nhập ngày sinh: ");
		loggingAccount.setDateOfBirth(dateFormatter.parse(scanner.nextLine()));
		int gender;
		do {
			System.out.print("Chọn giới tính - (1: Nam - 0: Nữ): ");
			gender = scanner.nextInt();
			if (gender != 0 && gender != 1) {
				System.out.println("Giới tính không hợp lệ, mời chọn lại.");
			}
			loggingAccount.setGender(gender);
		} while (gender != 0 && gender != 1);
		scanner.nextLine();
		System.out.print("Nhập quê quán: ");
		loggingAccount.setCountry(scanner.nextLine());
		candidateController.updateCandidate(loggingAccount);
		System.out.println("Cập nhật tài khoản thành công!");
	}
	
	
	// Xoá tài khoản
	public static void DeleteAccountMenu(Scanner scanner, Candidate loggingAccount, CandidateController candidateController) throws SQLException {
		String confirmDelete;
		do {
			scanner.nextLine();
			System.out.print("Bạn có chắc muốn xoá tài khoản? (Y/N): ");
			confirmDelete = scanner.nextLine();
			if (!confirmDelete.equals("Y") && !confirmDelete.equals("N")) {
				System.out.println("Mời nhập lại!");
			}
		} while (!confirmDelete.equals("Y") && !confirmDelete.equals("N"));
		candidateController.deleteCandidate(loggingAccount);
		for (Candidate candidate : candidateController.getCandidatesList()) {
			if(candidate.getId() == loggingAccount.getId()) {
				candidateController.getCandidatesList().remove(candidate);
				System.out.println("Xoá tài khoản thành công!");
				break;
			}
		}
	}

	
	// Chọn loại câu hỏi
	public static int QuestionTypeMenu(Scanner scanner) {
		int questionType;
		do {
			System.out.print("\nChọn loại câu hỏi\n1. Mutiple Choice\n2. Incomplete\n3. Conversation\nNhập lựa chọn: ");
			questionType = scanner.nextInt();
			if (questionType < 1 || questionType > 3) {
				System.out.println("Lựa chọn không hợp lệ, mời chọn lại!");
			}
		} while (questionType < 1 || questionType > 3);
		return questionType;
	}

}
