package ReportSystem;

public class ConstValue {

	final static String[] ageName = {"유아","소인","청소년","대인","경로"};
	final static String[] preName = {"없음","장애인","국가유공자","다자녀","임산부"};
	final static String[] dayNight = {"주간권","야간권"};
	
	final static int day = 1;
	final static int night = 2;
	
	final static int baby = 1;//나이대별 그룹 넘버 상수화
	final static int child = 2;
	final static int teen = 3;
	final static int adult = 4;
	final static int old = 5;
	
	final static int none = 1; //우대 종류 상수화
	final static int disabled = 2;
	final static int national = 3;
	final static int multiChild = 4;
	final static int pregnant = 5;
	
	final static String filePath = "C:\\project\\amuse.csv";
	final static String fileWritePath_1 = "C:\\project\\kindReport.csv";
	final static String fileWritePath_2 = "C:\\project\\DailyReport.csv";
	final static String fileWritePath_3 = "C:\\project\\prefReport.csv";
	
	

}
