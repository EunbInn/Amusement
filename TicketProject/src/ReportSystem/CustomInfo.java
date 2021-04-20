package ReportSystem;

public class CustomInfo {
	private String date;
	private int dayNight;
	private int ageGroup;
	private int ticket;
	private int price;
	private int preference;

	public CustomInfo(String date, int dayNight, int ageGroup, int ticket, int price, int preference) {
		this.date = date;
		this.dayNight = dayNight;
		this.ageGroup = ageGroup;
		this.ticket = ticket;
		this.price = price;
		this.preference = preference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDayNight() {
		return dayNight;
	}

	public void setDayNight(int dayNight) {
		this.dayNight = dayNight;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
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

	public int getPreference() {
		return preference;
	}

	public void setPreference(int preference) {
		this.preference = preference;
	}

}
