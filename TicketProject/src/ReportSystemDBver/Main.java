package ReportSystemDBver;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readGetInfo rgi = new readGetInfo();
		PrintReport pr = new PrintReport();
		
		ArrayList<String> all =rgi.readAll();
	
		pr.printAll(all);
		
		ArrayList<String> daily = rgi.readSalesReportPerDay();
		
		pr.printReportDaily(daily);
		
		ArrayList<int[]> type = rgi.readReportDayNight();
		
		pr.printReportType(type);
		
		int[] advantage = rgi.readAdvantage();

		pr.printReportAdv(advantage);
	}

}
