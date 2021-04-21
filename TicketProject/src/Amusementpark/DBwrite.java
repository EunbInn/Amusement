package Amusementpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DBwrite {
	public void dbWrite(String result) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(SetData.dbPath, SetData.admingId, SetData.adminPw);

			Statement stat = con.createStatement();
			stat.execute(result);
			
			stat.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public String dateReturn() { // DB 입력할 날짜 리턴
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		return sdf.format(cal.getTime());
	}

	// DB 입력할 내용 리턴
	public void resultFormat(ArrayList<SaveData> sd) {

		for (int index = 0; index < sd.size(); index++) {
			SaveData com = sd.get(index);
			String writeCom = "";

			writeCom = String.format(
							"INSERT INTO `new`(`DATE`, `DayNight`, `AgeGroup`, `TicketNumber`, `Price`, `Advantage`) "
							+ "VALUES ('%s','%s','%s','%d','%d','%s')",
							dateReturn(), com.getDayNight(), com.getAgeGroup(), 
							com.getTicket(), com.getPrice(),com.getPreference());
			dbWrite(writeCom);
		}
	}

}
