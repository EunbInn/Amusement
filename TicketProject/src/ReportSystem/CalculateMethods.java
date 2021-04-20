package ReportSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CalculateMethods {
	String[] date;
	int[] dayNight, ageGroup, ticket, price, pref;
	
	public CalculateMethods(SaveReadData save) {
		this.date = save.getRetDate();
		this.dayNight = save.getRetDayNight();
		this.ageGroup = save.getRetAgeGroup();
		this.ticket = save.getRetTicket();
		this.price = save.getRetPrice();
		this.pref = save.getRetPref();		
	}
	
	public ArrayList<Integer> CalPerDay() {
		ArrayList<Integer> pricePerDay = new ArrayList<Integer>();
		
		ArrayList<String> Date_arr = getSortedDate();
		
		for (int i = 0; i < Date_arr.size(); i++) {
			int sumPrice = 0;
			for (int j = 0; j < date.length; j++) {
				if (this.date[j].equals(Date_arr.get(i))) {
					sumPrice += price[j];
				}
			}
			pricePerDay.add(sumPrice);
		}
		
		return pricePerDay;	
	}
	
	//hash set saves unique values but not sorted, so get unique date and save as arraylist
	public ArrayList<String> getSortedDate() { 
		HashSet<String> uniDate = new HashSet<String>();
		
		for (int i = 0; i < date.length; i++) {
			uniDate.add(date[i]);
		}	
		
		ArrayList<String> Date_arr = new ArrayList<String>(uniDate);
		
		Collections.sort(Date_arr);
		
		return Date_arr;
	}
	
	//total ticket sum  -- > used in pref status
	public int CalTotalTicket() {
		
		int totalSum = 0;
		
		for (int i = 0; i < ticket.length; i++) {
			totalSum += ticket[i];
		}
		
		return totalSum;
	
	}
	
	//day nigth ticket sum
	public int[] countTicket(boolean retValue) {	
		int[] ticketAndPrice = new int[2];
		
		int ticketSum = 0;
		int priceSum = 0;
		for (int i = 0; i < dayNight.length; i++) {
			if (dayNight[i] == ConstValue.day && retValue == true) {
				ticketSum += ticket[i];
				priceSum += price[i];
			} else if (dayNight[i] == ConstValue.night && retValue == false) {
				ticketSum += ticket[i];	
				priceSum += price[i];
			}
		}
		ticketAndPrice[0] = ticketSum;
		ticketAndPrice[1] = priceSum;
		
		return ticketAndPrice;

	}
	
	//count day entry ticket per ageGroup
	public int[] countAgeTDay() {
		int[] countTicket = new int[5];
		
		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;
		
		for (int i = 0; i < dayNight.length; i++) {
			if (ageGroup[i] == ConstValue.baby && dayNight[i] == ConstValue.day) {
				babySum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.child && dayNight[i] == ConstValue.day) {
				childSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.teen && dayNight[i] == ConstValue.day) {
				teenSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.adult && dayNight[i] == ConstValue.day) {
				adultSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.old && dayNight[i] == ConstValue.day) {
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
	
	
	//count night entry ticket per ageGroup
	public int[] countAgeTNight() {
		int[] countTicket = new int[5];
		
		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;
		
		for (int i = 0; i < dayNight.length; i++) {
			if (ageGroup[i] == ConstValue.baby && dayNight[i] == ConstValue.night) {
				babySum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.child && dayNight[i] == ConstValue.night) {
				childSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.teen && dayNight[i] == ConstValue.night) {
				teenSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.adult && dayNight[i] == ConstValue.night) {
				adultSum += ticket[i];
				
			} else if (ageGroup[i] == ConstValue.old && dayNight[i] == ConstValue.night) {
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
	
	public int[] calPreferenceTicket() {
		int[] countTicket = new int[5];
		
		int noneSum = 0;
		int disabledSum = 0;
		int nationalSum = 0;
		int multiChildSum = 0;
		int pregnantSum = 0;
		
		for (int i = 0; i < pref.length; i++) {
			if (pref[i] == ConstValue.none) {
				noneSum += ticket[i];
				
			} else if (pref[i] == ConstValue.disabled) {
				disabledSum += ticket[i];
				
			} else if (pref[i] == ConstValue.national) {
				nationalSum += ticket[i];
				
			} else if (pref[i] == ConstValue.multiChild) {
				multiChildSum += ticket[i];
				
			} else if (pref[i] == ConstValue.pregnant) {
				pregnantSum += ticket[i];
				
			}
		}
		countTicket[0] = noneSum;
		countTicket[1] = disabledSum;
		countTicket[2] = nationalSum;
		countTicket[3] = multiChildSum;
		countTicket[4] = pregnantSum;
		
		return countTicket;	
	}
}
