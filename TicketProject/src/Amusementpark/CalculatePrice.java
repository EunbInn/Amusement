package Amusementpark;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculatePrice {
	public int calculateAge(String inputYear) {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");// �⵵ ����
		SimpleDateFormat date = new SimpleDateFormat("MMdd");// ��¥ ����

		int thisYear = Integer.parseInt(year.format(cal.getTime()));// ���� ����
		int today = Integer.parseInt(date.format(cal.getTime()));// ���� ��¥
		String bYear = inputYear.substring(0, 2); // �¾ �⵵
		int bDay = Integer.parseInt(inputYear.substring(2, 6)); // ������ ���� ���� ��¥
		int sort00 = Integer.parseInt(inputYear.split("")[6]); // 1900, 2000���� �����ϴ� �ڸ���

		int age = 0;

		// ������ ��� : ���� ��¥ >= ���� (==�̹� ��������) ���� - ���� �� �� + 1
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
		// ���̺� �׷� ��ȣ ����
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

		return ageGroup; // ���е� �׷� ��ȣ ����
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