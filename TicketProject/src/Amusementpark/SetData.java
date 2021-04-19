package Amusementpark;

public class SetData {

	final static int[] dayPrice = { 0, 44000, 47000, 56000, 44000 };// ���� ���� û�ҳ� ���� ���
	final static int[] nightPrice = { 0, 37000, 40000, 46000, 37000 };// ���� ���� û�ҳ� ���� ���
	final static double[] discount = { 1, 0.6, 0.5, 0.2, 0.15 };// �����, ����������, ���ڳ�, �ӻ��
	final static String[] ageName = { "����", "����", "û�ҳ�", "����", "���" };
	final static String[] preName = { "����", "�����", "����������", "���ڳ�", "�ӻ��" };
	
	final static String day = "�ְ���";
	final static String night = "�߰���";

	final static int childMin = 3;// ���̴뺰 �θƽ� ���ȭ
	final static int childMax = 12;
	final static int teenMin = 13;
	final static int teenMax = 18;
	final static int adultMin = 19;
	final static int adultMax = 64;

	final static int baby = 1;// ���̴뺰 �׷� �ѹ� ���ȭ
	final static int child = 2;
	final static int teen = 3;
	final static int adult = 4;
	final static int old = 5;

	final static int less00male = 1; // 2000���� �Ʒ�
	final static int less00female = 2;
	final static int over00male = 3; // 2000���� �̻�
	final static int over00female = 4;

	final static int ticketMax = 10; // Ƽ�� �ƽ�

	final static String filePath = ".\\amuse.csv"; // ���ϰ��
}