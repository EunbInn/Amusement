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
}
