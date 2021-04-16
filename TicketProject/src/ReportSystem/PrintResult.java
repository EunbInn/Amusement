package ReportSystem;

import java.util.ArrayList;

public class PrintResult {
	public String strForm(String str, int leng) {
		String temp = str + "                                        ";
		
		String form = new String(temp.getBytes(), 0, leng);
		
		return form;
	}
	
	public void printAll(String[] date, int[] DayNight, int[] ageGroup, int[] ticket, int[] price, int[] pref) {
		System.out.println("======================== report.csv =========================");
		System.out.printf("%6s%7s%5s%5s%10s%11s\n","날짜","권종","연령대","수량","가격","우대사항");
		
		for (int i = 0; i < date.length; i++) {
			System.out.printf("  %8.12s%4.5s%8.8s%8.6s%15.10s%10s\n",
					date[i], (DayNight[i] + ""), (ageGroup[i] + ""), 
					(ticket[i] + ""), (price[i] + ""), (pref[i] + ""));
		}
		System.out.println("============================================================");
	}
	
	public void ticketSaleStatus(int[] dayTicket,int[] nightTicket,int[] dayAgeT,int[] nightAgeT) {
		System.out.println("\n\n==================== 권종별 판매 현황 ======================");
		System.out.printf("주간권 총  %d 매\n", dayTicket[0]);
		System.out.printf("유아 %d매, 소인 %d매, 청소년 %d매, 대인 %d매, 경로 %d매\n", 
						dayAgeT[0], dayAgeT[1], dayAgeT[2], dayAgeT[3], dayAgeT[4]);
		System.out.printf("주간권 총 매출 : %d원\n", dayTicket[1]);
		
		System.out.printf("\n야간권 총  %d 매\n", nightTicket[0]);
		System.out.printf("유아 %d매, 소인 %d매, 청소년 %d매, 대인 %d매, 경로 %d매\n", 
						nightAgeT[0], nightAgeT[1], nightAgeT[2], nightAgeT[3], nightAgeT[4]);
		System.out.printf("주간권 총 매출 : %d원\n", nightTicket[1]);
		System.out.println("============================================================");
	}
}
