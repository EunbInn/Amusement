package ReportSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//권종별 판매현황, 일자별 매출현황, 우대권 판매형황
		
		FileRead file = new FileRead();
		CalculateMethods cal = new CalculateMethods();
		PrintResult print = new PrintResult();
		
		ArrayList<String[]> raw;
		String[] retDate;
		int[] retDayNight, retAgeGroup, retTicket, retPrice, retPref; //read and return values
		int[] dayAgeT, nightAgeT,dayTicket, nightTicket;
		int totalTicket;
		
		ArrayList<Integer> calPerDay;
		
		raw = file.fileReader(); // read file raw
		
		retDate = file.readDate(raw);
		retDayNight = file.readDayNight(raw);
		retAgeGroup = file.readAgeGroup(raw);
		retTicket = file.readTicket(raw);
		retPrice = file.readPrice(raw);
		retPref = file.readPreference(raw);
		
		
		calPerDay = cal.CalPerDay(retDate, retPrice);//calculate daily sales status
		
		totalTicket = cal.CalTotalTicket(retTicket);//calculate number of tickets
		dayTicket = cal.countTicket(retDayNight,retTicket,retPrice,true);
		nightTicket = cal.countTicket(retDayNight,retTicket,retPrice,false);
		dayAgeT = cal.countAgeTDay(retDayNight, retTicket, retAgeGroup);
		nightAgeT = cal.countAgeTNight(retDayNight, retTicket, retAgeGroup);
		
		print.printAll(retDate,retDayNight,retAgeGroup,retTicket,retPrice,retPref);
		print.ticketSaleStatus(dayTicket, nightTicket, dayAgeT, nightAgeT);
		

	}

}
