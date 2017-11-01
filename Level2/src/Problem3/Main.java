package Problem3;

import java.util.Scanner;

/*
 * Problem3. Lotto
 * 
 * 로또는 1~M까지의 숫자중 N개의 숫자를 골라 맞추면 상금을 타는 복권이다.
 * 
 * 어떤 사람이 꿈을 꿨지만 번호가 다 기억 나지 않고 규칙만 기억나는 상태이다.
 * 규칙 : 번호를 오름차순으로 정렬 했을때 그 숫자가 앞의 수보다 2배 이상 큰 숫자
 * 
 * N과 M이 주어졌을때 몇가지의 경우의 수가 있는지 알아내는 프로그램 작성
 * 
 * 입력 : N (골라내는 숫자), M (숫자의 범위)
 * 출력 : 로또 번호의 경우의 수
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
