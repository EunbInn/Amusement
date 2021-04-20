package Amusementpark;

public class SaveData {
	private String dayNight;

	private String ageGroup;
	private int ageInt;
	private int ticket;
	private int price;
	private String preference;
	private int prefInt;

	public String getDayNight() {
		return dayNight;
	}

	public void setDayNight(int dayNight) {
		if (dayNight == 1) {
			this.dayNight = SetData.day;
		} else if (dayNight == 2) {
			this.dayNight = SetData.night;
		}
	}

	public int getDayNight(String str) {
		int dayNight = 0;
		if (str.equals(SetData.day)) {
			dayNight = 1;
		} else if (str.equals(SetData.night)) {
			dayNight = 2;
		}
		return dayNight;
	}



	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getAgeInt() {
		return ageInt;
	}

	public void setAgeInt(int ageInt) {
		this.ageInt = ageInt;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public int getPrefInt() {
		return prefInt;
	}

	public void setPrefInt(int prefInt) {
		this.prefInt = prefInt;
	}
}