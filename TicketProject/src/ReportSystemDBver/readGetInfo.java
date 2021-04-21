package ReportSystemDBver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ReportSystem.ConstValue;

public class readGetInfo {
	private Connection con;
	private Statement stat;
	private ResultSet rs;
	
	public readGetInfo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					FinalValue.dbPath, FinalValue.admingId, FinalValue.adminPw);
			stat = con.createStatement();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	
	}
	
	public ArrayList<String> readAll() { //모든 데이터 읽기
		ArrayList<String> str = new ArrayList<String>();
		
		try {
			rs = stat.executeQuery("select * from `new`");
		
			while (rs.next()) {
			String ret = String.format( "%10.10s%5.5s%7.5s%10.10s%10.10s%8.8s",
								rs.getString(1), 
								readDayNight(rs.getString(2)) + "", 
								readAgeGroup(rs.getString(3)) + "",
								rs.getString(4),
								rs.getString(5), 
								readPreference(rs.getString(6)));
				str.add(ret);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return str;
		
	}
	
	public ArrayList<String> readSalesReportPerDay() { //일별 매출
		ArrayList<String> str = new ArrayList<String>();
		try {
			rs = stat.executeQuery("select `Date`, sum(price) from `new` "
					+ "group by `Date` order by `Date` asc");
			while (rs.next()) {
				String ret = rs.getString(1) + "     " + rs.getString(2);
				str.add(ret);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return str;
	}
	
	public ArrayList<int[]> readReportDayNight() { // 권종별 판매현황
		ArrayList<int[]> array = new ArrayList<int[]>();
		int[] day = new int[7];
		int[] night = new int[7];
		try {
			rs = stat.executeQuery("select `Daynight`, sum(ticketNumber) from `new` group by `Daynight`");
			while (rs.next()) {
				if (rs.getString(1).equals(FinalValue.dayNight[0])) {
					day[FinalValue.dayNightV] = rs.getInt(2);
				} else {
					night[FinalValue.dayNightV] = rs.getInt(2);
				}
			}
			
			rs = stat.executeQuery("select `AgeGroup`, sum(TicketNumber) from `new` "
					+ "where `DayNight` like '주간권' group by `AgeGroup` ");
			while (rs.next()) {
				if (rs.getString(1).equals(FinalValue.ageName[0])) {
					day[FinalValue.baby] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[1])) {
					day[FinalValue.child] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[2])) {
					day[FinalValue.teen] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[3])) {
					day[FinalValue.adult] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[4])) {
					day[FinalValue.old] = rs.getInt(2);
				}
			}
			
			rs = stat.executeQuery("select `AgeGroup`, sum(TicketNumber) from `new` "
					+ "where `DayNight` like '야간권' group by `AgeGroup` ");
			while (rs.next()) {
				if (rs.getString(1).equals(FinalValue.ageName[0])) {
					night[FinalValue.baby] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[1])) {
					night[FinalValue.child] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[2])) {
					night[FinalValue.teen] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[3])) {
					night[FinalValue.adult] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.ageName[4])) {
					night[FinalValue.old] = rs.getInt(2);
				}
			}
			
			rs = stat.executeQuery("select `Daynight`, sum(price) from `new` group by `Daynight`");
			while (rs.next()) {
				if (rs.getString(1).equals(FinalValue.dayNight[0])) {
					day[FinalValue.price] = rs.getInt(2);
				} else {
					night[FinalValue.price] = rs.getInt(2);
				}
			}
			
			array.add(day);
			array.add(night);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return array;
	}
	
	public int[] readAdvantage() {
		int[] advantage = new int[6];
		
		try {
			rs = stat.executeQuery("select sum(ticketNumber) from `new`");
			while (rs.next()) {
				advantage[0] = rs.getInt(1);
			}
			
			rs= stat.executeQuery("select `advantage`, sum(ticketNumber) "
							+ "from `new` group by `advantage`");
			int i = 0;
			while (rs.next()) {
				i++;
				if (rs.getString(1).equals(FinalValue.preName[0])) {
					advantage[FinalValue.none] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.preName[1])) {
					advantage[FinalValue.disabled] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.preName[2])) {
					advantage[FinalValue.national] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.preName[3])) {
					advantage[FinalValue.multiChild] = rs.getInt(2);
				} else if (rs.getString(1).equals(FinalValue.preName[4])) {
					advantage[FinalValue.pregnant] = rs.getInt(2);
				}

			}
			rs.close();
			stat.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return advantage;
	}
	
	
	
	
	public int readDayNight(String raw_day) { // 주야권 넘버
		int dayNight = 0;

		if (raw_day.equals(ConstValue.dayNight[0])) {
			dayNight = ConstValue.day;

		} else if (raw_day.equals(ConstValue.dayNight[1])) {
			dayNight = ConstValue.night;

		}

		return dayNight;
	}

	public int readAgeGroup(String raw_age) { // 나이 그룹 넘버
		int ageGroup = 0;

		if (raw_age.equals(ConstValue.ageName[0])) {
			ageGroup = ConstValue.baby;

		} else if (raw_age.equals(ConstValue.ageName[1])) {
			ageGroup = ConstValue.child;

		} else if (raw_age.equals(ConstValue.ageName[2])) {
			ageGroup = ConstValue.teen;

		} else if (raw_age.equals(ConstValue.ageName[3])) {
			ageGroup = ConstValue.adult;

		} else if (raw_age.equals(ConstValue.ageName[4])) {
			ageGroup = ConstValue.old;

		}

		return ageGroup;

	}



	public int readPreference(String raw_pref) { // 우대
		int preference = 0;

		if (raw_pref.equals(ConstValue.preName[0])) {
			preference = ConstValue.none;

		} else if (raw_pref.equals(ConstValue.preName[1])) {
			preference = ConstValue.disabled;

		} else if (raw_pref.equals(ConstValue.preName[2])) {
			preference = ConstValue.national;

		} else if (raw_pref.equals(ConstValue.preName[3])) {
			preference = ConstValue.multiChild;

		} else if (raw_pref.equals(ConstValue.preName[4])) {
			preference = ConstValue.pregnant;

		}

		return preference;

	}
	

}
