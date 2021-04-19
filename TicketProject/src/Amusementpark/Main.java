package Amusementpark;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		int inputContinue, inputMore, sumPrice, price;
		String inputId;

		ArrayList<SaveData> saveArr = new ArrayList<SaveData>();
		PrintMenu pm = new PrintMenu();
		GetInput input = new GetInput();
		FileWrite fw = new FileWrite();
		CalculatePrice calP = new CalculatePrice();
		SaveData sd = null;

		while (true) {
			sd = new SaveData();
			sd.setDayNightInt(input.inputDayNight()); // �־߱ǿ��� ����
			sd.setDayNight(sd.getDayNightInt());

			inputId = input.inputID(); // �ֹι�ȣ

			sd.setAgeInt(calP.calculateAge(inputId)); // ���̴� �׷� �ѹ� ����
			sd.setAgeGroup(SetData.ageName[sd.getAgeInt() - 1]); // �׷��̸� ��

			sd.setTicket(input.inputTicketNum()); // Ƽ�� �� �� ����

			sd.setPrefInt(input.inputPreference()); // ��뿩�� ����
			sd.setPreference(SetData.preName[sd.getPrefInt() - 1]); // ��뿩�� �̸� ��

			price = calP.calPrice(sd.getDayNightInt(), sd.getAgeInt(), sd.getTicket(), sd.getPrefInt());
			sd.setPrice(price); // ���Ű��� ��
			sumPrice = calP.sumPrice(sd.getPrice()); // ���� ���� ����

			saveArr.add(sd); // ��� ���̺�

			inputMore = input.inputMore(sd.getPrice()); // ȸ�� ���� ��� ��� �� ���� ��� ���� ����

			fw.resultCombine(saveArr); // ����� ���ļ� file write �ϱ�

			if (inputMore == 2) {
				pm.printResult(saveArr, sumPrice);
				saveArr = new ArrayList<SaveData>(); // array �ʱ�ȭ
				calP = new CalculatePrice(); // ��갪 �ʱ�ȭ
				inputContinue = input.ContinueOffProgram();

				if (inputContinue == 2) // ���α׷� ����
					break;
			}
		}
	}
}