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
			sd.setDayNightInt(input.inputDayNight()); // 주야권여부 리턴
			sd.setDayNight(sd.getDayNightInt());
			
			inputId = input.inputID(); // 주민번호 
			
			sd.setAgeInt(calP.calculateAge(inputId)); // 나이대 그룹 넘버 리턴
			sd.setAgeGroup(SetData.ageName[sd.getAgeInt() - 1]); //그룹이름 셋
			
			sd.setTicket(input.inputTicketNum()); // 티켓 장 수 리턴
			
			sd.setPrefInt(input.inputPreference()); // 우대여부 리턴
			sd.setPreference(SetData.preName[sd.getPrefInt() - 1]); //우대여부 이름 셋
			
			price = calP.calPrice(
					sd.getDayNightInt(), sd.getAgeInt(), sd.getTicket(), sd.getPrefInt());
			sd.setPrice(price); // 구매가격 셋
			sumPrice = calP.sumPrice(sd.getPrice()); // 가격 총합 연산

			saveArr.add(sd); // 결과 세이브

			inputMore = input.inputMore(sd.getPrice()); // 회당 구매 결과 출력 및 구매 계속 여부 리턴

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
