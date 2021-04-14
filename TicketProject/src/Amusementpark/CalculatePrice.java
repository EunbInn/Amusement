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
		int bDate = Integer.parseInt(inputYear.substring(2, 6)); // 만나이 계산용 민증 날짜
		int sort2000 = Integer.parseInt(inputYear.split("")[6]); // 1900, 2000년대생 구분하는 자리수
		char over2000 = 3; // 3~4는 2000년

		int age = 0;

		// 만나이 계산 : 오늘 날짜 >= 생일 (==이미 지났으면) 올해 - 생년 뺀 값 + 1
		if (sort2000 < over2000 && today >= bDate) {
			bYear = 19 + bYear;
			age = thisYear - Integer.parseInt(bYear) + 1;

		} else if (sort2000 >= over2000 && today >= bDate) {
			bYear = 20 + bYear;
			age = thisYear - Integer.parseInt(bYear) + 1;

		} else if (sort2000 < over2000 && today < bDate) {
			bYear = 19 + bYear;
			age = thisYear - Integer.parseInt(bYear);

		} else if (sort2000 >= over2000 && today < bDate) {
			bYear = 20 + bYear;
			age = thisYear - Integer.parseInt(bYear);

		}

		return getAgeGroup(age);
	}

	public int getAgeGroup(int age) {
		final int childMin = 3;// 나이대별 민맥스 상수화
		final int childMax = 12;
		final int teenMin = 13;
		final int teenMax = 18;
		final int adultMin = 19;
		final int adultMax = 64;

		int ageGroup = 0;
		// 나이별 그룹 번호 구분
		if (age < childMin) {
			ageGroup = SetData.baby;

		} else if (age >= childMin && age <= childMax) {
			ageGroup = SetData.child;

		} else if (age >= teenMin && age <= teenMax) {
			ageGroup = SetData.teen;

		} else if (age >= adultMin && age <= adultMax) {
			ageGroup = SetData.adult;

		} else if (age > adultMax) {
			ageGroup = SetData.old;

		}

		return ageGroup; // 구분된 그룹 번호 리턴
	}

	public int calPrice(int dayNight, int ageGroup, int ticket, int pref) {
		int rawPrice = 0;
		int realPrice = 0;
		System.out.println(ageGroup);
		if (dayNight == 1) {
			rawPrice = SetData.dayPrice[ageGroup - 1];

		} else if (dayNight == 2) {
			rawPrice = SetData.nightPrice[ageGroup - 1];

		}
		realPrice = (int) (rawPrice * ticket * SetData.discount[pref - 1]);
		return realPrice;

	}

	public int[][] savePrice(int dayNight, int ageGroup, int ticket, int price, int pref) {
		// 주야권 여부, 누가 샀는지,총 몇장 샀는지 그룹별 총 금액이 얼마인지 그룹별 우대적용이 있는지 없는지 ----> 총액
		int arrAge = ageGroup - 1;
		int[][] saveData = new int[5][5];

		saveData[arrAge][0] = dayNight; // 주간권 여부
		saveData[arrAge][1] = ageGroup;
		saveData[arrAge][2] = ticket;
		saveData[arrAge][3] = price;
		saveData[arrAge][4] = pref;

		return saveData;
	}

	int sum = 0;

	public int sumPrice(int price) {

		sum += price;

		return sum;
	}

}
