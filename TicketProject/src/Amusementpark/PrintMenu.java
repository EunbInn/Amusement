package Amusementpark;

import java.util.ArrayList;

public class PrintMenu {
	CalculatePrice cal = new CalculatePrice();
	SaveData save;

	public void dayNightOption() {// ���� ����
		System.out.println("#������ �����ϼ���.\n" + "1. �ְ���\n" + "2. �߰���");
	}

	public void IDNumber() {// �ֹι�ȣ
		System.out.println("#�ֹι�ȣ�� �Է��ϼ���. (123456-1234567 : '-' ���� �Է�)");
	}

	public void ticketNumber() {
		System.out.println("#�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10 ��)");
	}

	public void PreferenceOption() {
		System.out.println(
				"#�������� �����ϼ���.\n" 
						+ "1. ���� (���� ��� �ڵ�ó��)\n" 
						+ "2. �����\n" 
						+ "3. ����������\n" 
						+ "4. ���ڳ�\n" 
						+ "5. �ӻ��");
	}

	public void priceAndMore(int price) {
		System.out.printf("������ %d �� �Դϴ�.\n", price);
		System.out.println("�����մϴ�.\n-------------------------");
		System.out.println("#��� �߱� �Ͻðڽ��ϱ�?\n" + "1. Ƽ�� �߱�\n" + "2. ����");
	}

	public void printResult(ArrayList<SaveData> saveArr, int sumPrice) {

		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n\n");
		System.out.println("========================== �������� ============================");

		for (int i = 0; i < saveArr.size(); i++) {
			SaveData print = saveArr.get(i);
			System.out.printf("%s %s  x  %d\t%d\t��� ����: %s\n", print.getDayNight(), print.getAgeGroup(),
					print.getTicket(), print.getPrice(), print.getPreference());
		}

		System.out.printf("\n\n����� �Ѿ��� %d�� �Դϴ�.\n", sumPrice);
		System.out.println("==============================================================\n\n");
	}

	public void printContinueOr() {
		System.out.print("��� ���� (1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
	}

}