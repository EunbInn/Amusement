package Amusementpark;

import java.util.Scanner;

public class GetInput {
	PrintMenu print = new PrintMenu();
	Scanner sc = null;

	public GetInput() {
		sc = new Scanner(System.in);

	}

	public int inputDayNight() {// 주야권
		print.dayNightOption();
		int choice = sc.nextInt();

		return choice;
	}

	public int inputTicketNum() {// 티켓 개수 받기
		print.ticketNumber();
		int number = sc.nextInt();

		while (number > SetData.ticketMax) { // 발권 가능 최대 값 넘으면 다시 입력 요청
			System.out.println("다시 입력해주세요");
			number = sc.nextInt();
		}

		return number;
	}

	public int inputPreference() {// 우대
		print.PreferenceOption();
		int choice = sc.nextInt();

		return choice;
	}

	public int inputMore(int price) {// 발권계속여부
		print.priceAndMore(price);
		int choice = sc.nextInt();

		return choice;
	}

	public int ContinueOffProgram() {// 프로그램 계속 여부
		print.printContinueOr();
		int choice = sc.nextInt();
		return choice;
	}

	public String inputID() { // 주민번호
		print.IDNumber();
		sc = new Scanner(System.in);
		String idNum = sc.nextLine();

		while (idNum.length() < 8 || idNum.charAt(6) == '-') { // -가 들어가거나 8자리 아래로 입력하면 재입력 요구
			System.out.println("다시 입력해주세요");
			idNum = sc.nextLine();
		}

		return idNum;
	}

}