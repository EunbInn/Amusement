package Amusementpark;

import java.util.ArrayList;

public class PrintMenu {
	CalculatePrice cal = new CalculatePrice();
	SaveData save;
	
	public void dayNightOption() {//권종 선택
		System.out.println("#권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
	}

	public void IDNumber() {//주민번호
		System.out.println("#주민번호를 입력하세요. (123456-1234567 : '-' 빼고 입력)");
	}

	public void ticketNumber() {
		System.out.println("#몇 장을 주문하시겠습니까? (최대 10 장)");
	}

	public void PreferenceOption() {
		System.out.println(
				"#우대사항을 선택하세요.\n" + "1. 없음 (나이 우대 자동처리)\n" + "2. 장애인\n" + "3. 국가유공자\n" + "4. 다자녀\n" + "5. 임산부");
	}

	public void priceAndMore(int price) {
		System.out.printf("가격은 %d 원 입니다.\n", price);
		System.out.println("감사합니다.\n-------------------------");
		System.out.println("#계속 발권 하시겠습니까?\n" + "1. 티켓 발권\n" + "2. 종료");
	}

	public void printResult(ArrayList<SaveData> saveArr, int sumPrice) {
		
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n\n");
		System.out.println("========================== 코포랜드 ============================");

		for (int i = 0; i < saveArr.size(); i++) {
				System.out.printf("%s %s  x  %d\t%d\t우대 내역: %s\n", 
						saveArr.get(i).getDayNight(), saveArr.get(i).getAgeGroup(),
						saveArr.get(i).getTicket(), saveArr.get(i).getPrice(),
						saveArr.get(i).getPreference());			
		}

		System.out.printf("\n\n입장료 총액은 %d원 입니다.\n", sumPrice);
		System.out.println("==============================================================\n\n");
	}

	public void printContinueOr() {
		System.out.print("계속 진행 (1: 새로운 주문, 2: 프로그램 종료) : ");
	}
	

}
