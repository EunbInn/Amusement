package ReportSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//권종별 판매현황, 일자별 매출현황, 우대권 판매형황	
		FileRead file = new FileRead();
		
		String[] retDate;
		int[] retDayNight, retAgeGroup, retTicket, retPrice, retPref, calPrePrefT; //read and return values
		int[] dayAgeT, nightAgeT,dayTicket, nightTicket;
		int totalTicket;
		
		ArrayList<Integer> calPerDay;
		ArrayList<String> sortedDate;
		
		file.fileReader(); // read file raw
		
		retDate = file.readDate();
		retDayNight = file.readDayNight();
		retAgeGroup = file.readAgeGroup();
		retTicket = file.readTicket();
		retPrice = file.readPrice();
		retPref = file.readPreference();
			CalculateMethods cal = new CalculateMethods(				retDate, retDayNight, retAgeGroup, retTicket, retPrice, retPref);;
		
		calPerDay = cal.CalPerDay();//calculate daily sales status
		sortedDate = cal.getSortedDate();
		
		dayTicket = cal.countTicket(true);
		nightTicket = cal.countTicket(false);
		dayAgeT = cal.countAgeTDay();
		nightAgeT = cal.countAgeTNight();
		
		totalTicket = cal.CalTotalTicket();//calculate number of tickets
		calPrePrefT = cal.calPreferenceTicket();
		
		PrintResult print = new PrintResult(retDate, retDayNight, retAgeGroup, retTicket, retPrice, retPref,
					dayTicket, nightTicket, dayAgeT, nightAgeT, sortedDate, calPerDay, 
				calPrePrefT, totalTicket);
		
		print.printAll();
		print.ticketSaleStatus();
		print.SalesSatatusPerDay();
		print.PreferenceStatus();
		
		FileWriteStatistics fw = new FileWriteStatistics();
		
		fw.writeKind(dayTicket, nightTicket, dayAgeT, nightAgeT);
		fw.writeDaily(sortedDate, calPerDay);
		fw.writePref(totalTicket, calPrePrefT);

	}

}
