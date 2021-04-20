package ReportSystem;

import java.util.ArrayList;

public class SaveReadData {
	private String[] retDate;
	private int[] retDayNight, retAgeGroup, retTicket, retPrice, retPref;
	
	public SaveReadData(String[] retDate, int[] retDayNight, 
			int[] retAgeGroup, int[] retTicket, int[] retPrice, int[] retPref) {
		
		this.retDate = retDate;
		this.retDayNight = retDayNight;
		this.retAgeGroup = retAgeGroup;
		this.retTicket = retTicket;
		this.retPrice = retPrice;
		this.retPref = retPref;
		 
	}

	public String[] getRetDate() {
		return retDate;
	}

	public void setRetDate(String[] retDate) {
		this.retDate = retDate;
	}

	public int[] getRetDayNight() {
		return retDayNight;
	}

	public void setRetDayNight(int[] retDayNight) {
		this.retDayNight = retDayNight;
	}

	public int[] getRetAgeGroup() {
		return retAgeGroup;
	}

	public void setRetAgeGroup(int[] retAgeGroup) {
		this.retAgeGroup = retAgeGroup;
	}

	public int[] getRetTicket() {
		return retTicket;
	}

	public void setRetTicket(int[] retTicket) {
		this.retTicket = retTicket;
	}

	public int[] getRetPrice() {
		return retPrice;
	}

	public void setRetPrice(int[] retPrice) {
		this.retPrice = retPrice;
	}

	public int[] getRetPref() {
		return retPref;
	}

	public void setRetPref(int[] retPref) {
		this.retPref = retPref;
	}

	public ArrayList<Object> getAll() {
		
		ArrayList<Object> all = new ArrayList<Object>();
		all.add(getRetDate());
		all.add(getRetDayNight());
		all.add(getRetAgeGroup());
		all.add(getRetTicket());
		all.add(getRetPrice());
		all.add(getRetPref());

		return all;
	}
}
