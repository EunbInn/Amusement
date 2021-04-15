package ReportSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FileRead file = new FileRead();
		CalculateMethods cal = new CalculateMethods();
		PrintResult print = new PrintResult();
		
		ArrayList<String[]> raw;
		String[] retDate;
		int[] retDayNight, retAgeGroup, retTicket, retPrice, retPref; //read and return values
		int[] dayAgeT, nightAgeT;
		int dayTicket, nightTicket, totalTicket;
		
		ArrayList<Integer> calPerDay;
		
		raw = file.fileReader(); // read file raw
		
		retDate = file.readDate(raw);
		retDayNight = file.readDayNight(raw);
		retAgeGroup = file.readAgeGroup(raw);
		retTicket = file.readTicket(raw);
		retPrice = file.readPrice(raw);
		retPref = file.readPreference(raw);
		
		
		calPerDay = cal.CalPerDay(retDate, retPrice);
		
		cal.CalTotalTicket(retTicket);
		dayTicket = cal.countTicket(retDayNight,retTicket,true);
		nightTicket = cal.countTicket(retDayNight,retTicket,false);
		dayAgeT = cal.countAgeTDay(retDayNight, retTicket, retAgeGroup);
		nightAgeT = cal.countAgeTNight(retDayNight, retTicket, retAgeGroup);
		
		print.printAll(retDate,retDayNight,retAgeGroup,retTicket,retPrice,retPref);
		

	}

}
