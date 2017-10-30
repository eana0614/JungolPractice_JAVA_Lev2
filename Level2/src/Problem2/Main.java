package Problem2;

import java.util.Scanner;

/*
 * Problem 2. necklace
 * n���� �����˷� ������ ����̰� �ִ�. (n <= 350)
 * �������� ���� ������(r), �Ķ���(b), ���(w)���� �����Ǿ� �ִ�.
 * ������� ���� �������� ���������� �����ϴ� ���� ���� �������� ���� �� �ִٰ� ������ ��,
 * ��� ����� ���� �������� ���� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ѵ�.
 * 
 * �Է� : ������� ���� n, ���� n�� ���ڿ�
 * ��� : ������ �� ���� ���� ���� �� �ִ� ���� ���� ���
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
