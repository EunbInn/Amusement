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
			sd.setAgeInt(calP.calculateAge(inputId)); // 나이대 그룹 넘버 리턴
			sd.setAgeGroup(SetData.ageName[sd.getAgeInt() - 1]); //그룹이름 셋
			sd.setDayNight(sd.getDayNightInt());
			sd.setPreference(SetData.preName[sd.getPrefInt() - 1]); //우대여부 이름 셋
			price = calP.calPrice(
					sd.getDayNightInt(), sd.getAgeInt(), sd.getTicket(), sd.getPrefInt());
			sd.setPrice(price);
			sumPrice = calP.sumPrice(sd.getPrice()); // 가격 총합 연산
			
			//save result
			saveArr.add(sd); 
			
			//input continue or not
			inputMore = input.inputMore(sd.getPrice()); 

			fw.resultCombine(saveArr); // 결과값 합쳐서 file write 하기

			if (inputMore == 2) {
				pm.printResult(saveArr, sumPrice);
				saveArr = new ArrayList<SaveData>(); // array 초기화
				calP = new CalculatePrice(); // 계산값 초기화
				inputContinue = input.ContinueOffProgram();
				
				if (inputContinue == 2) // 프로그램 종료
					break; 
			}
		}
	}
}