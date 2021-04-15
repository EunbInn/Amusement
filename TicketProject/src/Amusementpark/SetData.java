package Amusementpark;

public class SetData {
	final static int[] dayPrice = {0, 44000, 47000, 56000, 44000};//유아 소인 청소년 대인 경로
	final static int[] nightPrice = {0, 37000, 40000, 46000, 37000};//유아 소인 청소년 대인 경로
	final static double[] discount = {1, 0.6, 0.5, 0.2, 0.15};//장애인, 국가유공자, 다자녀, 임산부
	final static String[] ageName = {"유아","소인","청소년","대인","경로"};
	final static String[] preName = {"없음","장애인","국가유공자","다자녀","임산부"};
	
	final static int childMin = 3;// 나이대별 민맥스 상수화
	final static int childMax = 12;
	final static int teenMin = 13;
	final static int teenMax = 18;
	final static int adultMin = 19;
	final static int adultMax = 64;	
	
	final static int baby = 1;//나이대별 그룹 넘버 상수화
	final static int child = 2;
	final static int teen = 3;
	final static int adult = 4;
	final static int old = 5;
	
	final static int less00male = 1; //2000년대생 아래
	final static int less00female = 2; 
	final static int over00male = 3; //2000년대생 이상
	final static int over00female = 4; 
	
	final static int ticketMax = 10; //티켓 맥스
	
	final static String filePath = "C:\\project\\amuse.csv"; //파일경로
}
