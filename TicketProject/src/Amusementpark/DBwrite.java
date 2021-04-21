package Amusementpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	// DB 입력할 내용 리턴
	public void resultFormat(ArrayList<SaveData> sd) {

		for (int index = 0; index < sd.size(); index++) {
			SaveData com = sd.get(index);
			String writeCom = "";

			writeCom = String.format(
							"INSERT INTO `new`(`DATE`, `DayNight`, `AgeGroup`, `TicketNumber`, `Price`, `Advantage`) "
							+ "VALUES (now(),'%s','%s','%d','%d','%s')",
							com.getDayNight(), com.getAgeGroup(), 
							com.getTicket(), com.getPrice(),com.getPreference());
			dbWrite(writeCom);
		}
	}

}
