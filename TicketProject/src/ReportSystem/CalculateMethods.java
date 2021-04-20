package ReportSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CalculateMethods {
	ArrayList<String> date = new ArrayList<String>();
	ArrayList<Integer> dayNight = new ArrayList<Integer>();
	ArrayList<Integer> ageGroup = new ArrayList<Integer>();
	ArrayList<Integer> ticket = new ArrayList<Integer>();
	ArrayList<Integer> price = new ArrayList<Integer>();
	ArrayList<Integer> pref = new ArrayList<Integer>();

	public CalculateMethods(ArrayList<CustomInfo> custom) {

		for (int i = 0; i < custom.size(); i++) {
			CustomInfo info = custom.get(i);
			date.add(info.getDate());
			dayNight.add(info.getDayNight());
			ageGroup.add(info.getAgeGroup());
			ticket.add(info.getTicket());
			price.add(info.getPrice());
			pref.add(info.getPreference());
		}

	}

	public ArrayList<Integer> CalPerDay() {
		ArrayList<Integer> pricePerDay = new ArrayList<Integer>();

		ArrayList<String> Date_arr = getSortedDate();

		for (int i = 0; i < Date_arr.size(); i++) {
			int sumPrice = 0;
			for (int j = 0; j < date.size(); j++) {
				if (this.date.get(j).equals(Date_arr.get(i))) {
					sumPrice += price.get(j);
				}
			}
			pricePerDay.add(sumPrice);
		}

		return pricePerDay;
	}

	// hash set saves unique values but not sorted, so get unique date and save as
	// arraylist
	public ArrayList<String> getSortedDate() {
		HashSet<String> uniDate = new HashSet<String>(date);

		ArrayList<String> Date_arr = new ArrayList<String>(uniDate);

		Collections.sort(Date_arr);

		return Date_arr;
	}

	// total ticket sum -- > used in pref status
	public int CalTotalTicket() {

		int totalSum = 0;

		for (int i = 0; i < ticket.size(); i++) {
			totalSum += ticket.get(i);
		}

		return totalSum;

	}

	// day nigth ticket sum
	public int[] countTicket(boolean retValue) {
		int[] ticketAndPrice = new int[2];

		int ticketSum = 0;
		int priceSum = 0;
		for (int i = 0; i < dayNight.size(); i++) {
			if (dayNight.get(i) == ConstValue.day && retValue == true) {
				ticketSum += ticket.get(i);
				priceSum += price.get(i);
			} else if (dayNight.get(i) == ConstValue.night && retValue == false) {
				ticketSum += ticket.get(i);
				priceSum += price.get(i);
			}
		}
		ticketAndPrice[0] = ticketSum;
		ticketAndPrice[1] = priceSum;

		return ticketAndPrice;

	}

	// count day entry ticket per ageGroup
	public int[] countAgeTDay() {
		int[] countTicket = new int[5];

		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;

		for (int i = 0; i < dayNight.size(); i++) {
			if (ageGroup.get(i) == ConstValue.baby && dayNight.get(i) == ConstValue.day) {
				babySum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.child && dayNight.get(i) == ConstValue.day) {
				childSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.teen && dayNight.get(i) == ConstValue.day) {
				teenSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.adult && dayNight.get(i) == ConstValue.day) {
				adultSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.old && dayNight.get(i) == ConstValue.day) {
				oldSum += ticket.get(i);

			}
		}
		countTicket[0] = babySum;
		countTicket[1] = childSum;
		countTicket[2] = teenSum;
		countTicket[3] = adultSum;
		countTicket[4] = oldSum;

		return countTicket;
	}

	// count night entry ticket per ageGroup
	public int[] countAgeTNight() {
		int[] countTicket = new int[5];

		int babySum = 0;
		int childSum = 0;
		int teenSum = 0;
		int adultSum = 0;
		int oldSum = 0;

		for (int i = 0; i < dayNight.size(); i++) {
			if (ageGroup.get(i) == ConstValue.baby && dayNight.get(i) == ConstValue.night) {
				babySum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.child && dayNight.get(i) == ConstValue.night) {
				childSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.teen && dayNight.get(i) == ConstValue.night) {
				teenSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.adult && dayNight.get(i) == ConstValue.night) {
				adultSum += ticket.get(i);

			} else if (ageGroup.get(i) == ConstValue.old && dayNight.get(i) == ConstValue.night) {
				oldSum += ticket.get(i);

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

		for (int i = 0; i < pref.size(); i++) {
			if (pref.get(i) == ConstValue.none) {
				noneSum += ticket.get(i);

			} else if (pref.get(i) == ConstValue.disabled) {
				disabledSum += ticket.get(i);

			} else if (pref.get(i) == ConstValue.national) {
				nationalSum += ticket.get(i);

			} else if (pref.get(i) == ConstValue.multiChild) {
				multiChildSum += ticket.get(i);

			} else if (pref.get(i) == ConstValue.pregnant) {
				pregnantSum += ticket.get(i);

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
