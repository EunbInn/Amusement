package ReportSystemDBver;

import java.util.ArrayList;

public class PrintReport {
	
	public void printAll(ArrayList<String> str) {
		System.out.println("====================== report =======================");
		System.out.println("   날짜      권종  나이대    수량    가격    우대사항 ");
			for (int i = 0; i < str.size(); i++) {
				System.out.println(str.get(i));
			}
		System.out.println("-----------------------------------------------------\n");
		
	}
	
	public void printReportDaily(ArrayList<String> str) {
		System.out.println("====== 일별 매출 ======");
		System.out.println("   날짜       매출합계");
		
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
		
		System.out.println("-----------------------\n");
	}
	
	public void printReportType(ArrayList<int[]> array) {
		int[] day = array.get(0);
		int[] night = array.get(1);
		System.out.println("================== 권종별 판매 현황 ====================");
		System.out.printf("주간권 총  %d 매\n", day[FinalValue.dayNightV]);
		System.out.printf("유아 %d매, 소인 %d매, 청소년 %d매, 대인 %d매, 경로 %d매\n",
						day[FinalValue.baby], 
						day[FinalValue.child], 
						day[FinalValue.teen], 
						day[FinalValue.adult],
						day[FinalValue.old]);
		System.out.printf("주간권 총 매출 : %d원\n", day[FinalValue.price]);

		System.out.printf("\n야간권 총  %d 매\n", night[FinalValue.dayNightV]);
		System.out.printf("유아 %d매, 소인 %d매, 청소년 %d매, 대인 %d매, 경로 %d매\n", 
						night[FinalValue.baby], 
						night[FinalValue.child], 
						night[FinalValue.teen],
						night[FinalValue.adult], 
						night[FinalValue.old]);
		System.out.printf("야간권 총 매출 : %d원\n", night[FinalValue.price]);
		System.out.println("--------------------------------------------------------\n");
	}
	
	public void printReportAdv(int[] str) {
		System.out.println("====== 우대권별 매출 ======");
			System.out.println("티켓 총 판매          " + str[0] + "장");
		for (int i = 1; i < str.length; i++) {
			
			System.out.printf("%s%10.10s장\n", strForm(FinalValue.preName[i - 1],7),str[i]);
		}
		
		System.out.println("---------------------------\n");
	}
	
	public String strForm(String str, int leng) { //공백 동일하게 출력
		String temp = str + "                ";

		temp = temp.substring(0, leng);

		int blank = leng - str.length();

		for (int i = 0; i < blank; i++) {
			temp += " ";
		}

		return temp;
	}
}
