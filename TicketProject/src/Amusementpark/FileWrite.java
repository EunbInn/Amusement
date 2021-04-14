package Amusementpark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWrite {
	public void fileWrite(String result) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		BufferedWriter bw;
		
		result = "\"" + sdf.format(cal.getTime()) + "\"," + result;

		try {
			File file = new File(SetData.filePath + "amuse.csv");

			if (file.exists() == false) {
				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(SetData.filePath + "amuse.csv", true), "MS949"));
				bw.write(firstLine());
				bw.write(result);
			} else {
				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(SetData.filePath + "amuse.csv", true), "MS949"));
				bw.write(result);
			}
			
			bw.close();

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException io) {
			io.getStackTrace();
		}

	}

	public String resultCombine(int dayNight, int ageGroup, int ticket, int price, int pref) {
		String writeCom = "";

		writeCom = String.format("\"%d\",\"%d\",\"%d\",\"%d\",\"%d\"\n", dayNight, ageGroup, ticket, price, pref);
		return writeCom;
	}

	public String firstLine() {
		String first = "\"날짜\",\"권종\",\"연령구분\",\"수량\",\"가격\",\"우대사항\"\n";

		return first;
	}
}
