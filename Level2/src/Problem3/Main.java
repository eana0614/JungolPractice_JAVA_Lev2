package Problem3;

import java.util.Scanner;

/*
 * Problem3. Lotto
 * 
 * �ζǴ� 1~M������ ������ N���� ���ڸ� ��� ���߸� ����� Ÿ�� �����̴�.
 * 
 * � ����� ���� ������ ��ȣ�� �� ��� ���� �ʰ� ��Ģ�� ��ﳪ�� �����̴�.
 * ��Ģ : ��ȣ�� ������������ ���� ������ �� ���ڰ� ���� ������ 2�� �̻� ū ����
 * 
 * N�� M�� �־������� ����� ����� ���� �ִ��� �˾Ƴ��� ���α׷� �ۼ�
 * 
 * �Է� : N (��󳻴� ����), M (������ ����)
 * ��� : �ζ� ��ȣ�� ����� ��
 *  
 */

public class Main {

	static int result = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		while (n != 0 && m != 0) {

			for (int i = 1; i <= (m/n); i++) {
				findCase(i, n, m);
			}

			System.out.println(result);

			result = 0;
			n = scanner.nextInt();
			m = scanner.nextInt();

		}

	}

	private static boolean findCase(int i, int n, int m) {
		
		
		if (n == 1 && i <= m) {
			result++;
			return true;
		} else if (hasDoubleNum(i, m)) {
			for (int j = i * 2; j <= m; j++) {
				findCase(j, n - 1, m);
			}
		} else {
			return false;
		}
		return false;
	}

	private static boolean hasDoubleNum(int i, int m) {

		if (i * 2 <= m) {
			return true;
		}
		return false;
	}

}
