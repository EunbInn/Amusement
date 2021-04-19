package ReportSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileRead {
	ArrayList<String[]> raw = fileReader();

	public ArrayList<String[]> fileReader() {
		ArrayList<String[]> raw = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ConstValue.filePath), "MS949"));

			String line;

			while ((line = br.readLine()) != null) {
				raw.add(line.split(","));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return raw;

	}

	public String[] readDate() { // ��¥
		String[] date = new String[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String[] raw_split = raw.get(index + 1);// ù�� ���� �б�
			date[index] = raw_split[0];

		}

		return date;
	}

	public int[] readDayNight() { // �־߱� �ѹ�
		int[] dayNight = new int[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String raw_day = raw.get(index + 1)[1];// ù�� ���� �б�

			if (raw_day.equals(ConstValue.dayNight[0])) {
				dayNight[index] = ConstValue.day;

			} else if (raw_day.equals(ConstValue.dayNight[1])) {
				dayNight[index] = ConstValue.night;

			}
		}
		return dayNight;

	}

	public int[] readAgeGroup() { // ���� �׷� �ѹ�
		int[] ageGroup = new int[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String raw_age = raw.get(index + 1)[2];// ù�� ���� �б�

			if (raw_age.equals(ConstValue.ageName[0])) {
				ageGroup[index] = ConstValue.baby;

			} else if (raw_age.equals(ConstValue.ageName[1])) {
				ageGroup[index] = ConstValue.child;

			} else if (raw_age.equals(ConstValue.ageName[2])) {
				ageGroup[index] = ConstValue.teen;

			} else if (raw_age.equals(ConstValue.ageName[3])) {
				ageGroup[index] = ConstValue.adult;

			} else if (raw_age.equals(ConstValue.ageName[3])) {
				ageGroup[index] = ConstValue.old;

			}
		}
		return ageGroup;

	}

	public int[] readTicket() { // Ƽ�� �� ��
		int[] ticket = new int[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String raw_ticket = raw.get(index + 1)[3];// ù�� ���� �б�
			ticket[index] = Integer.parseInt(raw_ticket);

		}

		return ticket;

	}

	public int[] readPrice() { // ����
		int[] price = new int[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String raw_price = raw.get(index + 1)[4];// ù�� ���� �б�
			price[index] = Integer.parseInt(raw_price);

		}

		return price;

	}

	public int[] readPreference() { // ���
		int[] preference = new int[raw.size() - 1];

		for (int index = 0; index < raw.size() - 1; index++) {
			String raw_age = raw.get(index + 1)[5];// ù�� ���� �б�

			if (raw_age.equals(ConstValue.preName[0])) {
				preference[index] = ConstValue.none;

			} else if (raw_age.equals(ConstValue.preName[1])) {
				preference[index] = ConstValue.disabled;

			} else if (raw_age.equals(ConstValue.preName[2])) {
				preference[index] = ConstValue.national;

			} else if (raw_age.equals(ConstValue.preName[3])) {
				preference[index] = ConstValue.multiChild;

			} else if (raw_age.equals(ConstValue.preName[3])) {
				preference[index] = ConstValue.pregnant;

			}

		}

		return preference;

	}

}