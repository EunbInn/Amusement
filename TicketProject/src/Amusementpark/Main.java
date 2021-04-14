package Amusementpark;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String idNum;
		int inputContinue, inputDayNight, inputPref, inputMore, ageGroup, inputTicket, price, sumPrice;
		int[][] saveData;
		String writeData;
		ArrayList<String> printData;

		while (true) {
			
			PrintMenu pm = new PrintMenu();
			GetInput input = new GetInput();
			FileWrite fw = new FileWrite();
			CalculatePrice calP = new CalculatePrice();

			while (true) {
				inputDayNight = input.inputDayNight(); // 주야권여부 리턴
				idNum = input.inputID(); // 주민번호 리턴
				ageGroup = calP.calculateAge(idNum);// 나이대 그룹 넘버 리턴
				inputTicket = input.inputTicketNum(); // 티켓 장 수 리턴
				inputPref = input.inputPreference(); // 우대여부 리턴

				price = calP.calPrice(inputDayNight, ageGroup, inputTicket, inputPref); // 구매가격 리턴
				sumPrice = calP.sumPrice(price);
				saveData = calP.savePrice(inputDayNight, ageGroup, inputTicket, price, inputPref); // 결과 세이브
				printData = pm.getPrintResult(saveData);
				inputMore = input.inputMore(price); // 회당 구매 결과 출력 및 구매 계속 여부 리턴
				writeData = fw.resultCombine(inputDayNight, ageGroup, inputTicket, price, inputPref);

				fw.fileWrite(writeData);
				if (inputMore == 2) {
					pm.printResult(printData, sumPrice);
					break;
				}
			}
			inputContinue = input.ContinueOffProgram();

			if (inputContinue == 2)
				break;
		}
	}

}
