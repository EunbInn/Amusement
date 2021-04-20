package ReportSystem;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileWriteStatistics {

	public void writeKind(int[] sumDay, int[] sumNight, int[] dayAge, int[] nightAge) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(ConstValue.fileWritePath_1), "MS949"));
			bw.write(ConstValue.firstLine_ticketKind);
			bw.newLine();
			for (int i = 0; i < ConstValue.ageName.length; i++) {
				String kindWrite = ConstValue.ageName[i] + "," + dayAge[i] + "," + nightAge[i];
				bw.write(kindWrite);
				bw.newLine();
			}
			bw.write("합계," + sumDay[0] + "," + sumNight[0] + "\n");
			bw.write("매출," + sumDay[1] + "," + sumNight[1] + "\n");

			bw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDaily(ArrayList<String> date, ArrayList<Integer> sumPerDay) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(ConstValue.fileWritePath_2), "MS949"));
			bw.write(ConstValue.firstLine_dailyReport);
			bw.newLine();
			for (int i = 0; i < date.size(); i++) {
				String dateF = DateFormat(date.get(i));
				String dailyWrite = dateF + "," + sumPerDay.get(i);
				bw.write(dailyWrite);
				bw.newLine();
			}
			bw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String DateFormat(String date) {
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6);

		String returnValue = year + "-" + month + "-" + day;

		return returnValue;
	}

	public void writePref(int totalTicket, int[] prefT) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(ConstValue.fileWritePath_3), "MS949"));
			bw.write(ConstValue.firstLine_prefReport);

			for (int i = 0; i < ConstValue.preName.length; i++) {
				String dailyWrite = ConstValue.preName[i] + "," + prefT[i];
				bw.write(dailyWrite);
				bw.newLine();
			}
			bw.write("합계," + totalTicket);
			bw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}