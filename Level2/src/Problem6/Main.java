package Problem6;

import java.util.Scanner;

/*
 * Problem 6. PERKET
 * 
 * N���� ��ᰡ �־����� S�� �Ÿ�, B�� ������ ���Ѵٰ� �Ҷ�, 
 * �Ÿ��� �� �Ÿ� ����� �Ÿ� ������ ���� ���̰� ������ ���� �츮�� ������ ����� ���� �������� ���� ���̴�
 * ������ ��Ŷ�� �Ÿ��� ������ ���� �ʱ� ������ �Ÿ��� �հ� ������ ���� ���� �ּҰ� �ǵ��� �ϰ��� �Ѵ�.
 * ��� �ϳ� �̻��� ��Ḧ �����ؾ� �ϰ� ���� ����� �� ����.
 * 
 * �Է� : �丮�� ���� ����� �� N, �� ����� S�� B
 * 		��� ��Ḧ �־� �丮�� ���鋚 �Ÿ��� ���̳� ������ ���� ��� 10���� ���� �ʴ´�.
 * ��� : �Ÿ��� ���� ������ �� ������ ������ ���� ���� ���� ���
 * 
 */

public class Main {

	static int min = 1000000000;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] s = new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++) {
			
			s[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			
		}
		
		
		findMinDifference(0, 1, 0, s, b);
		System.out.println(min);
		
	}

	private static void findMinDifference(int i, int mulValue, int sumValue, int[] s, int[] b) {
		
		for(int j=i; j<s.length; j++) {
			int temp = mulValue * s[j] - (sumValue+b[j]);
			
			if(Math.abs(temp) < min) {
				min = Math.abs(temp);
			}
			
			findMinDifference(j+1, mulValue*s[j], sumValue+b[j], s, b);
			
		}
		
	}

}
