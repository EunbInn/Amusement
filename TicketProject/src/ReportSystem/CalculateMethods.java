package ReportSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CalculateMethods {
	public ArrayList<Integer> CalPerDay(String[] date, int[] price) {
		HashSet<String> uniDate = new HashSet<String>(); // input unique date in hash list
		ArrayList<Integer> pricePerDay = new ArrayList<Integer>();
		
		
		for (int i = 0; i < date.length; i++) {
			uniDate.add(date[i]);
		}	
		
		Iterator<String> iter = uniDate.iterator();
		
		for (int i = 0; i < uniDate.size(); i++) {
			String str = iter.next();
			int sumPrice = 0;
			for (int j = 0; j < date.length; j++) {
				if (date[j].equals(str)) {
					sumPrice += price[j];
				}
			}
			pricePerDay.add(sumPrice);
		}
		
		return pricePerDay;	
	}
	
	public void CalTotalTicket(int[] ticket) {
		
		int totalSum = 0;
		
		for (int i = 0; i < ticket.length; i++) {
			totalSum += ticket[i];
		}
	
	}
	
	public int countTicket(int[] DayNight, int[] ticket, boolean retValue) {	
		
		int ticketSum = 0;
		for (int i = 0; i < DayNight.length; i++) {
			if (DayNight[i] == ConstValue.day && retValue == true) {
				ticketSum += ticket[i];
				
			} else if (DayNight[i] == ConstValue.day && retValue == false) {
				ticketSum += ticket[i];	
			}
		}
		return ticketSum;

	}
	
	public int[] countAgeTDay(int[] DayNight, int[] ticket, int[] ageGroup) {
		int[] countTicket = new int[5];
		
		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;
		
		for (int i = 0; i < DayNight.length; i++) {
			if (ageGroup[i] == ConstValue.baby && DayNight[i] == ConstValue.night) {
				babySum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.child && DayNight[i] == ConstValue.night) {
				childSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.teen && DayNight[i] == ConstValue.night) {
				teenSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.adult && DayNight[i] == ConstValue.night) {
				adultSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.old && DayNight[i] == ConstValue.night) {
				oldSum += ticket[i];
				
			}
		}
		countTicket[0] = babySum;
		countTicket[1] = childSum;
		countTicket[2] = teenSum;
		countTicket[3] = adultSum;
		countTicket[4] = oldSum;
		
		return countTicket;	
	}
	
	public int[] countAgeTNight(int[] DayNight, int[] ticket, int[] ageGroup) {
		int[] countTicket = new int[5];
		
		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;
		
		for (int i = 0; i < DayNight.length; i++) {
			if (ageGroup[i] == ConstValue.baby && DayNight[i] == ConstValue.day) {
				babySum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.child && DayNight[i] == ConstValue.day) {
				childSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.teen && DayNight[i] == ConstValue.day) {
				teenSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.adult && DayNight[i] == ConstValue.day) {
				adultSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.old && DayNight[i] == ConstValue.day) {
				oldSum += ticket[i];
				
			}
		}
		countTicket[0] = babySum;
		countTicket[1] = childSum;
		countTicket[2] = teenSum;
		countTicket[3] = adultSum;
		countTicket[4] = oldSum;
		
		return countTicket;
	}
}
