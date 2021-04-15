package Amusementpark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class FileWrite {
	
	public void fileWrite(String result) {
		
		BufferedWriter bw;

		try {
			File file = new File(SetData.filePath);

			if (file.exists() == false) {
				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(SetData.filePath , true), "MS949"));
				bw.write(firstLine());
				bw.write(result);
			} else {
				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(SetData.filePath , true), "MS949"));
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
	
	public String dateReturn() { //파일 입력할 날짜 리턴
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		return sdf.format(cal.getTime());
	}
	//파일 입력할 내용 리턴
	public void resultCombine(ArrayList<SaveData> sd) { 
		
		for (int index = 0; index < sd.size(); index++) {
			SaveData com = sd.get(index);
			String writeCom = "";
		
			writeCom = String.format("%s,%s,%s,%d,%d,%s\n", 
					dateReturn(), com.getDayNight(), com.getAgeGroup(), 
					com.getTicket(), com.getPrice(), com.getPreference());
			fileWrite(writeCom);
		}
	}

	public String firstLine() {
		String first = "날짜,권종,연령구분,수량,가격,우대사항\n";

		return first;
	}
}
