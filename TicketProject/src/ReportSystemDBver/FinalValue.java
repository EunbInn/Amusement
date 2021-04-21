package ReportSystemDBver;

public class FinalValue {
	
	public final static String[] ageName = {"유아","소인","청소년","대인","경로"};
	public final static String[] preName = {"없음","장애인","국가유공자","다자녀","임산부"};
	public final static String[] dayNight = {"주간권","야간권"};
	
	public final static int day = 1;
	public final static int night = 2;
	
	public final static int dayNightV = 0;
	public final static int price = 6;
	
	public final static int baby = 1;//나이대별 그룹 넘버 상수화
	public final static int child = 2;
	public final static int teen = 3;
	public final static int adult = 4;
	public final static int old = 5;
	
	public final static int none = 1; //우대 종류 상수화
	public final static int disabled = 2;
	public final static int national = 3;
	public final static int multiChild = 4;
	public final static int pregnant = 5;
	
	final static String dbPath = "jdbc:mysql://127.0.0.1:3306/testdb";
	final static String admingId = "root";
	final static String adminPw = "1234567";
	
}
