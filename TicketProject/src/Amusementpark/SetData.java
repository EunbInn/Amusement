package Amusementpark;

public class SetData {
	final static int[] dayPrice = {0, 44000, 47000, 56000, 44000};//유아 소인 청소년 대인 경로
	final static int[] nightPrice = {0, 37000, 40000, 46000, 37000};//유아 소인 청소년 대인 경로
	final static double[] discount = {1, 0.6, 0.5, 0.2, 0.15};//장애인, 국가유공자, 다자녀, 임산부
	final static String[] ageName = {"유아","소인","청소년","대인","경로"};
	static boolean[] ageEx = new boolean[4];
	final static String[] preName = {"없음","장애인","국가유공자","다자녀","임산부"};
	static boolean[] preEx = new boolean[4];
	
	final static int baby = 1;
	final static int child = 2;
	final static int teen = 3;
	final static int adult = 4;
	final static int old = 5;
	
	final static String filePath = "C:\\project\\";
}
