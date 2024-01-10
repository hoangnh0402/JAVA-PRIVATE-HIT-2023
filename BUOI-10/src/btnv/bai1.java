package btnv;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bai1 {

	private static final Map<String, String> accounts = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Đăng kí tài khoản");
			System.out.println("2. Thoát");

			System.out.print("Chọn: ");
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				registerAccount();
				break;
			case "2":
				System.out.println("Kết thúc chương trình.");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Lựa chọn không hợp lệ.");
			}
		}
	}

	private static boolean isValidUsername(String username) {
		if (username.length() < 6) {
			return false;
		}

		if (Character.isDigit(username.charAt(0))) {
			return false;
		}

		if (!username.matches("[a-z0-9]+")) {
			return false;
		}

		return true;
	}

	private static boolean isValidPassword(String password) {
		if (password.length() < 8) {
			return false;
		}

		if (!password.matches(".*[a-z].*")) {
			return false;
		}

		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		if (!password.matches(".*\\d.*")) {
			return false;
		}

		Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+");
		Matcher matcher = specialCharPattern.matcher(password);
		if (!matcher.find()) {
			return false;
		}

		return true;
	}

	private static void registerAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập username: ");
		String username = scanner.nextLine();

		System.out.print("Nhập password: ");
		String password = scanner.nextLine();

		if (!isValidUsername(username)) {
			System.out.println("Username không hợp lệ.");
			return;
		}

		if (!isValidPassword(password)) {
			System.out.println("Password không hợp lệ.");
			return;
		}

		// Kiểm tra trùng lặp username
		if (accounts.containsKey(username)) {
			System.out.println("Username đã tồn tại.");
			return;
		}

		// Đăng kí thành công
		accounts.put(username, password);
		System.out.println("Đăng kí thành công.");
	}
}
