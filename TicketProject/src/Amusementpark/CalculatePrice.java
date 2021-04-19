package Amusementpark;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculatePrice {
	public int calculateAge(String inputYear) {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");// 년도 포맷
		SimpleDateFormat date = new SimpleDateFormat("MMdd");// 날짜 포맷

		int thisYear = Integer.parseInt(year.format(cal.getTime()));// 올해 연도
		int today = Integer.parseInt(date.format(cal.getTime()));// 오늘 날짜
		String bYear = inputYear.substring(0, 2); // 태어난 년도
		int bDay = Integer.parseInt(inputYear.substring(2, 6)); // 만나이 계산용 민증 날짜
		int sort00 = Integer.parseInt(inputYear.split("")[6]); // 1900, 2000년대생 구분하는 자리수

		int age = 0;

		// 만나이 계산 : 오늘 날짜 >= 생일 (==이미 지났으면) 올해 - 생년 뺀 값 + 1
		if ((sort00 == SetData.less00male || sort00 == SetData.less00female) && today >= bDay) {
			bYear = 19 + bYear;
			age = thisYear - Integer.parseInt(bYear) + 1;

		} else if ((sort00 == SetData.over00male || sort00 == SetData.over00female) && today >= bDay) {
			bYear = 20 + bYear;
			age = thisYear - Integer.parseInt(bYear) + 1;

		} else if ((sort00 == SetData.less00male || sort00 == SetData.less00female) && today < bDay) {
			bYear = 19 + bYear;
			age = thisYear - Integer.parseInt(bYear);

		} else if ((sort00 == SetData.over00male || sort00 == SetData.over00female) && today < bDay) {
			bYear = 20 + bYear;
			age = thisYear - Integer.parseInt(bYear);

		}

		return getAgeGroup(age);
	}

	private int getAgeGroup(int age) {
		int ageGroup = 0;
		// 나이별 그룹 번호 구분
		if (age < SetData.childMin) {
			ageGroup = SetData.baby;

		} else if (age >= SetData.childMin && age <= SetData.childMax) {
			ageGroup = SetData.child;

		} else if (age >= SetData.teenMin && age <= SetData.teenMax) {
			ageGroup = SetData.teen;

		} else if (age >= SetData.adultMin && age <= SetData.adultMax) {
			ageGroup = SetData.adult;

		} else if (age > SetData.adultMax) {
			ageGroup = SetData.old;

		}

		return ageGroup; // 구분된 그룹 번호 리턴
	}

	public int calPrice(int dayNight, int ageGroup, int ticket, int pref) {
		int rawPrice = 0;
		int realPrice = 0;

		if (dayNight == 1) {
			rawPrice = SetData.dayPrice[ageGroup - 1];

		} else if (dayNight == 2) {
			rawPrice = SetData.nightPrice[ageGroup - 1];

		}
		realPrice = (int) (rawPrice * ticket * SetData.discount[pref - 1]);
		return realPrice;

	}

	int sum = 0;

	public int sumPrice(int price) {

		sum += price;

		return sum;
	}

}