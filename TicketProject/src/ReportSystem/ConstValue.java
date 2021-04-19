package ReportSystem;

public class ConstValue {

	public final static String[] ageName = {"유아","소인","청소년","대인","경로"};
	public final static String[] preName = {"없음","장애인","국가유공자","다자녀","임산부"};
	public final static String[] dayNight = {"주간권","야간권"};
	
	public final static int day = 1;
	public final static int night = 2;
	
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
	
	public final static String filePath = "amuse.csv";
	public final static String fileWritePath_1 = "kindReport.csv";
	public final static String fileWritePath_2 = "DailyReport.csv";
	public final static String fileWritePath_3 = "prefReport.csv";
	
	

}
