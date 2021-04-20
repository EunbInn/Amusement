package ReportSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileRead {
	String[] rawData = null;

	public ArrayList<CustomInfo> fileReader() {
		ArrayList<CustomInfo> custom = new ArrayList<CustomInfo>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ConstValue.filePath), "MS949"));

			String line;

			int i = 0;
			while ((line = br.readLine()) != null) {
				this.rawData = line.split(",");
				if (i > 0) {
					String date = readDate();
					int dayNight = readDayNight();
					int ageGroup = readAgeGroup();
					int ticket = readTicket();
					int price = readPrice();
					int pref = readPreference();
					CustomInfo info = new CustomInfo(date, dayNight, ageGroup, ticket, price, pref);
					custom.add(info);
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return custom;
	}

	public String readDate() { // 날짜
		String date = rawData[ConstValue.date_n];

		return date;
	}

	public int readDayNight() { // 주야권 넘버
		int dayNight = 0;

		String raw_day = rawData[ConstValue.dayNight_n];

		if (raw_day.equals(ConstValue.dayNight[0])) {
			dayNight = ConstValue.day;

		} else if (raw_day.equals(ConstValue.dayNight[1])) {
			dayNight = ConstValue.night;

		}

		return dayNight;
	}

	public int readAgeGroup() { // 나이 그룹 넘버
		int ageGroup = 0;

		String raw_age = rawData[ConstValue.ageGroup_n];

		if (raw_age.equals(ConstValue.ageName[0])) {
			ageGroup = ConstValue.baby;

		} else if (raw_age.equals(ConstValue.ageName[1])) {
			ageGroup = ConstValue.child;

		} else if (raw_age.equals(ConstValue.ageName[2])) {
			ageGroup = ConstValue.teen;

		} else if (raw_age.equals(ConstValue.ageName[3])) {
			ageGroup = ConstValue.adult;

		} else if (raw_age.equals(ConstValue.ageName[4])) {
			ageGroup = ConstValue.old;

		}

		return ageGroup;

	}

	public int readTicket() { // 티켓 장 수
		int ticket = 0;

		String raw_ticket = rawData[ConstValue.ticket_n];
		ticket = Integer.parseInt(raw_ticket);

		return ticket;

	}

	public int readPrice() { // 가격
		int price = 0;

		String raw_price = rawData[ConstValue.price_n];
		price = Integer.parseInt(raw_price);

		return price;

	}

	public int readPreference() { // 우대
		int preference = 0;

		String raw_age = rawData[ConstValue.pref_n];

		if (raw_age.equals(ConstValue.preName[0])) {
			preference = ConstValue.none;

		} else if (raw_age.equals(ConstValue.preName[1])) {
			preference = ConstValue.disabled;

		} else if (raw_age.equals(ConstValue.preName[2])) {
			preference = ConstValue.national;

		} else if (raw_age.equals(ConstValue.preName[3])) {
			preference = ConstValue.multiChild;

		} else if (raw_age.equals(ConstValue.preName[4])) {
			preference = ConstValue.pregnant;

		}

		return preference;

	}

}