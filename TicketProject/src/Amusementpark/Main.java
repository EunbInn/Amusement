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
			//input
			sd.setDayNightInt(input.inputDayNight());
			inputId = input.inputID();
			sd.setTicket(input.inputTicketNum());
			sd.setPrefInt(input.inputPreference());
			
			//calculate age, price
			sd.setAgeInt(calP.calculateAge(inputId)); // ���̴� �׷� �ѹ� ����
			sd.setAgeGroup(SetData.ageName[sd.getAgeInt() - 1]); //�׷��̸� ��
			sd.setDayNight(sd.getDayNightInt());
			sd.setPreference(SetData.preName[sd.getPrefInt() - 1]); //��뿩�� �̸� ��
			price = calP.calPrice(
					sd.getDayNightInt(), sd.getAgeInt(), sd.getTicket(), sd.getPrefInt());
			sd.setPrice(price);
			sumPrice = calP.sumPrice(sd.getPrice()); // ���� ���� ����
			
			//save result
			saveArr.add(sd); 
			
			//input continue or not
			inputMore = input.inputMore(sd.getPrice()); 

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