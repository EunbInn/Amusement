package ReportSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FileRead file = new FileRead();
		
		String[] retDate;
		int[] retDayNight, retAgeGroup, retTicket, retPrice, retPref, calPrePrefT; //read and return values
		int[] dayAgeT, nightAgeT,dayTicket, nightTicket;
		int totalTicket;
		
		ArrayList<Integer> calPerDay;
		ArrayList<String> sortedDate;
		
		// read file raw
		file.fileReader(); 
		retDate = file.readDate();
		retDayNight = file.readDayNight();
		retAgeGroup = file.readAgeGroup();
		retTicket = file.readTicket();
		retPrice = file.readPrice();
		retPref = file.readPreference();
		
		//calculate data to print and to write on file		CalculateMethods cal = new CalculateMethods(				retDate, retDayNight, retAgeGroup, retTicket, retPrice, retPref);
		
		calPerDay = cal.CalPerDay();
		sortedDate = cal.getSortedDate();
		dayTicket = cal.countTicket(true);
		nightTicket = cal.countTicket(false);
		dayAgeT = cal.countAgeTDay();
		nightAgeT = cal.countAgeTNight();
		
		totalTicket = cal.CalTotalTicket();//calculate number of tickets
		calPrePrefT = cal.calPreferenceTicket();
		
		//print result
		PrintResult print = new PrintResult(retDate, retDayNight, retAgeGroup, retTicket, retPrice, retPref,
					dayTicket, nightTicket, dayAgeT, nightAgeT, sortedDate, calPerDay, 
				calPrePrefT, totalTicket);
		
		print.printAll();
		print.ticketSaleStatus();
		print.SalesSatatusPerDay();
		print.PreferenceStatus();
		
		//file write
		FileWriteStatistics fw = new FileWriteStatistics();
		
		fw.writeKind(dayTicket, nightTicket, dayAgeT, nightAgeT);
		fw.writeDaily(sortedDate, calPerDay);
		fw.writePref(totalTicket, calPrePrefT);

	}

}
