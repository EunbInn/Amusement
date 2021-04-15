package ReportSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileRead {

	public ArrayList<String[]> fileReader() {
		ArrayList<String[]> read = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(ConstValue.filePath), "MS949"));

			String line;

			while ((line = br.readLine()) != null) {
				read.add(line.split(","));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return read;
	}

	public void readDate() {

	}

	public void readDayNight() {

	}

	public void readAgeGroup() {

	}

	public void readTicket() {

	}

	public void readDiscount() {

	}
	
	public void readPrice() {
		
	}
}
