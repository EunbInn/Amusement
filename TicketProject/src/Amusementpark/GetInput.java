package Amusementpark;

import java.util.Scanner;

public class GetInput {
	PrintMenu print = new PrintMenu();
	Scanner sc = null;

	public GetInput() {
		sc = new Scanner(System.in);

	}

	public int inputDayNight() {// �־߱�
		print.dayNightOption();
		int choice = sc.nextInt();

		return choice;
	}

	public int inputTicketNum() {// Ƽ�� ���� �ޱ�
		print.ticketNumber();
		int number = sc.nextInt();

		while (number > SetData.ticketMax) { // �߱� ���� �ִ� �� ������ �ٽ� �Է� ��û
			System.out.println("�ٽ� �Է����ּ���");
			number = sc.nextInt();
		}

		return number;
	}

	public int inputPreference() {// ���
		print.PreferenceOption();
		int choice = sc.nextInt();

		return choice;
	}

	public int inputMore(int price) {// �߱ǰ�ӿ���
		print.priceAndMore(price);
		int choice = sc.nextInt();

		return choice;
	}

	public int ContinueOffProgram() {// ���α׷� ��� ����
		print.printContinueOr();
		int choice = sc.nextInt();
		return choice;
	}

	public String inputID() { // �ֹι�ȣ
		print.IDNumber();
		sc = new Scanner(System.in);
		String idNum = sc.nextLine();

		while (idNum.length() < 8 || idNum.charAt(6) == '-') { // -�� ���ų� 8�ڸ� �Ʒ��� �Է��ϸ� ���Է� �䱸
			System.out.println("�ٽ� �Է����ּ���");
			idNum = sc.nextLine();
		}

		return idNum;
	}

}