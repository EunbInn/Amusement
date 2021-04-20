package ReportSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FileRead file = new FileRead();

		int[] calPrePrefT, dayAgeT, nightAgeT,dayTicket, nightTicket;
		int totalTicket;
		
		ArrayList<Integer> price_arr;
		ArrayList<String> date_arr;
		
		// read file raw
		ArrayList<CustomInfo> custom = file.fileReader();

		//calculate data to print and to write on file		CalculateMethods cal = new CalculateMethods(custom);
		
		price_arr = cal.CalPerDay();
		date_arr = cal.getSortedDate();
		dayTicket = cal.countTicket(true);
		nightTicket = cal.countTicket(false);
		dayAgeT = cal.countAgeTDay();
		nightAgeT = cal.countAgeTNight();
		
		totalTicket = cal.CalTotalTicket();//calculate total number of tickets
		calPrePrefT = cal.calPreferenceTicket();
		
		//print result
		PrintResult print = new PrintResult(custom,dayTicket, nightTicket,dayAgeT, nightAgeT, 
				date_arr, price_arr, calPrePrefT, totalTicket);
		
		print.printAll();
		print.ticketSaleStatus();
		print.SalesSatatusPerDay();
		print.PreferenceStatus();
		
		//file write
		FileWriteStatistics fw = new FileWriteStatistics();
		
		fw.writeKind(dayTicket, nightTicket, dayAgeT, nightAgeT);
		fw.writeDaily(date_arr, price_arr);
		fw.writePref(totalTicket, calPrePrefT);

	}

}
