package Problem2;

import java.util.Scanner;

/*
 * Problem 2. necklace
 * n개의 유리알로 구성된 목걸이가 있다. (n <= 350)
 * 유리알의 색은 빨간색(r), 파란색(b), 흰색(w)으로 구성되어 있다.
 * 목걸이의 줄을 끊었을때 연속적으로 등장하는 같은 색의 유리알을 모을 수 있다고 가정할 때,
 * 어디를 끊어야 많은 유리알을 모을 수 있는지 계산하는 프로그램을 작성한다.
 * 
 * 입력 : 목걸이의 길이 n, 길이 n의 문자열
 * 출력 : 끊었을 때 가장 많이 모을 수 있는 알의 개수 출력
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		
		String inputs = scanner.nextLine();
		
		char[] necklace = createArrays(inputs, n);
		
		int result = findMax(necklace);
		
		System.out.println(result);
	}

	private static int findMax(char[] necklace) {
		
		int max = 0;
		
		max = countFront(necklace) + countBack(necklace);
		
		for(int i=1; i<necklace.length; i++) {
			
			necklace = rotation(necklace);
			
			int temp = countFront(necklace)+countBack(necklace);
			
			if(max < temp) {
				max = temp;
			}
			
		}
		
		if(max >= necklace.length) {
			max = necklace.length;
		}
				
		return max;
	}

	private static char[] rotation(char[] necklace) {
		
		char temp = necklace[0];
		
		for(int i=0; i<necklace.length-1; i++) {
			necklace[i] = necklace[i+1];
		}
		
		necklace[necklace.length-1] = temp;
		
		return necklace;
	}

	private static int countBack(char[] necklace) {
		
		int count = 0;
		
		char c = 'w';
		
		for(int i=necklace.length-1; i>=0; i--) {
			if(necklace[i] != 'w') {
				c = necklace[i];
				break;
			}
		}
		
		for(int i=necklace.length-1; i>=0; i--) {
			if(necklace[i] == c || necklace[i] == 'w') {
				count++;
			}else {
				break;
			}
		}
		
		return count;
	}

	private static int countFront(char[] necklace) {
		
		int count = 0;
		
		char c = 'w';
		
		for(int i=0; i<necklace.length; i++) {
			if(necklace[i] != 'w') {
				c = necklace[i];
				break;
			}
		}
		
		for(int i=0; i<necklace.length; i++) {
			if(necklace[i] == c || necklace[i] == 'w') {
				count++;
			}else {
				break;
			}
		}
		
		return count;
	}

	private static char[] createArrays(String inputs, int n) {
		
		char[] result = new char[n];
		
		for(int i=0; i<n; i++) {
			result[i] = inputs.charAt(i);
		}
		
		return result;
	}

}
