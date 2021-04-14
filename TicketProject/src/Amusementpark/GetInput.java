package Amusementpark;

import java.util.Scanner;

public class GetInput {
	PrintMenu print = new PrintMenu();
	Scanner sc = null;
	
	public GetInput() {
		sc = new Scanner(System.in);
	}
	
	public int inputDayNight() {//주야권
		print.dayNightOption();
		int choice = sc.nextInt();
		
		return choice;
	}
	
	public int inputTicketNum() {
		print.ticketNumber();
		int number = sc.nextInt();
		
		return number;
	}
	
	public int inputPreference() {//우대
		print.PreferenceOption();
		int choice = sc.nextInt();
		
		return choice;
	}
	
	public int inputMore(int price) {//발권계속여부
		print.priceAndMore(price);
		int choice = sc.nextInt();
		
		return choice;
	}
	
	public int ContinueOffProgram() {//프로그램 계속 여부
		print.printContinueOr();
		int choice = sc.nextInt();
		return choice;
	}
	
	public String inputID() { //주민번호
		print.IDNumber();
		sc = new Scanner(System.in);
		String idNum = sc.nextLine();
		
		return idNum;
	}
	
	
}
